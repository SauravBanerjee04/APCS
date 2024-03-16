// Name:   S4-01
// Date:   5/4/20
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graph0 AdjMat_0_Driver,
 *              Graph1 WarshallDriver,
 *          and Graph2 FloydDriver
 */

interface AdjacencyMatrix
{
   void addEdge(int source, int target);
   void removeEdge(int source, int target);
   boolean isEdge(int from, int to);
   String toString();   //returns the grid as a String
   int edgeCount();
   List<Integer> getNeighbors(int source);
   //public List<String> getReachables(String from);  //Warshall extension
}

interface Warshall      //User-friendly functionality
{
   boolean isEdge(String from, String to);
   Map<String, Integer> getVertices();     
   void readNames(String fileName) throws FileNotFoundException;
   void readGrid(String fileName) throws FileNotFoundException;
   void displayVertices();
   void allPairsReachability();  // Warshall's Algorithm
}

interface Floyd
{
   int getCost(int from, int to);
   int getCost(String from, String to);
   void allPairsWeighted(); 
}

public class AdjMat implements AdjacencyMatrix,Warshall//,Floyd 
{
   private int[][] grid = null;   //adjacency matrix representation
   private Map<String, Integer> vertices = null;   // name maps to index (for Warshall & Floyd)
   /*for Warshall's Extension*/  ArrayList<String> nameList = null;  //reverses the map, index-->name
   public AdjMat(int a){
      grid = new int[a][a];
      vertices = new TreeMap<String,Integer>();
   }
   /*  enter your code here  */  
   public void addEdge(int source, int target){
      grid[source][target] = 1;
   }
   public void removeEdge(int source, int target){
      grid[source][target] = 0;
   }
   public boolean isEdge(int from, int to){
      return (grid[from][to] == 1);
   }
   public String toString(){   //returns the grid as a String
      String s = "";
      for(int i = 0; i < grid.length; i++){
         for(int j = 0; j < grid[0].length; j++) {
            s += (grid[i][j] + " "); 
         }
         s += "\n";
      }
      return s;
   }
   public int edgeCount(){ // counts edges by checking for ones
      int c = 0;
      for(int a = 0; a < grid.length; a++)
         for(int b = 0; b<grid[0].length; b++)
            if((grid[a][b]> 0) && (grid[a][b] < 9999))
               c ++;
      return c;
   }
   public List<Integer> getNeighbors(int source){ // looks at the ones in the row with ones
      List<Integer> b = new ArrayList<Integer>();
      for(int a = 0; a < grid[source].length; a++)
         if(grid[source][a] == 1)
            b.add(new Integer(a));
      return b;
   }
   
   
   public Map<String,Integer> getVertices(){
      return vertices;
   }
   public void readNames(String fileName) throws FileNotFoundException{
      Scanner sc = new Scanner(new File(fileName)); // reads through the number first then the names
      int n = Integer.parseInt(sc.next());
      for(int a = 0; a <n; a++){
         vertices.put(sc.next(),a);
      } 
      sc.close();
   } 
   public void readGrid(String fileName) throws FileNotFoundException{ // goes through each int in the grid one by one
      Scanner sc = new Scanner(new File(fileName));
      int a = sc.nextInt();
      int n = 0;
      while(sc.hasNextInt()){
         grid[n/a][n%a] = sc.nextInt();
         n++;
      }
      sc.close();
   }
   public void displayVertices(){
      for(int a = 0; a <grid[0].length;a++){
         for(String b : vertices.keySet())
            if (vertices.get(b) == a)
               System.out.println(a + "-" + b);
      }
   }
   public void allPairsReachability(){ // checks by applying warshall's algorithm
      int b = grid[0].length;
      int[][] reach = new int[b][b];
      for(int l = 0; l < b; l++)
         for(int m = 0; l < b; l++)
            reach[l][m] = grid[l][m];
      for(int i = 0; i < b; i++)
         for(int v = 0; v < b; v++)
            for(int j = 0; j < b; j++)
               if((grid[i][v] == 1) && (grid[v][j] == 1))
                  grid[i][j] = 1;
      String s = "";
      for(int i = 0; i < reach.length; i++){
         for(int j = 0; j < reach[0].length; j++) {
            s += (reach[i][j] + " "); 
         }
         s += "\n";
      }
      System.out.println(s);
               
   }
   
   public boolean isEdge(String from, String to){
      return isEdge(vertices.get(from),vertices.get(to)); // calls other method
   }
   
   public int getCost(int from, int to){
      return grid[from][to];
   }
   public int getCost(String from, String to){
      return getCost(vertices.get(from),vertices.get(to)); // calls other method
   }
   public void allPairsWeighted(){
      int b = grid[0].length;
      int[][] reach = new int[b][b];
      reach = grid;
      for(int a = 0; a < b; a++)
         for(int i = 0; i < b; i++)
            for(int v = 0; v < b; v++)
               for(int j = 0; j < b; j++)
                  if(reach[i][v] + reach[v][j] < reach[i][j])
                     reach[i][j] = (reach[i][v] + reach[v][j]);
      // String s = "";
   //       for(int i = 0; i < reach.length; i++){
   //          for(int j = 0; j < reach[0].length; j++) {
   //             s += (reach[i][j] + " "); 
   //          }
   //          s += "\n";
   //       }
   //       System.out.println(s);
      
   }
   

   
   
}

