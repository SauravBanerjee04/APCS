// Name:   S4-01
// Date:    6/5/19
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs3: EdgeList,
 *              Graphs4: DFS-BFS
 *          and Graphs5: EdgeListCities
 */

/* Graphs 3: EdgeList 
 */
interface VertexInterface
{
   String toString(); // Don't use commas in the list.  Example: "C [C D]"
   String getName();
   ArrayList<Vertex> getAdjacencies();
   void addEdge(Vertex v);
} 

class Vertex implements VertexInterface 
{
   private final String name;
   private ArrayList<Vertex> adjacencies;
   public Vertex(String s){
      name = s;
      adjacencies = new ArrayList<Vertex>();
   }
  /* enter your code here  */
   public String toString(){
      String s = name + " [";
      for(Vertex b : adjacencies)
         if(b != null)
            s = s + b.getName() + " ";
      if(s.substring(s.length()-1).equals(" "))
         s = s.substring(0,s.length()-1);
      return s + "]";
   }
   public String getName(){
      return name;
   }
   public ArrayList<Vertex> getAdjacencies(){
      return adjacencies;
   }
   public void addEdge(Vertex v){
      adjacencies.add(v);
   }

}   

interface AdjListInterface 
{ 
   List<Vertex> getVertices();
   Vertex getVertex(int i) ;
   Vertex getVertex(String vertexName);
   Map<String, Integer> getVertexMap();
   void addVertex(String v);
   void addEdge(String source, String target);
   String toString();  //returns all vertices with their edges (omit commas)
}

  
/* Graphs 4: DFS and BFS 
 */
interface DFS_BFS
{
   List<Vertex> depthFirstSearch(String name);
   List<Vertex> depthFirstSearch(Vertex v);
   List<Vertex> breadthFirstSearch(String name);
   List<Vertex> breadthFirstSearch(Vertex v);
   /*  three extra credit methods */
   List<Vertex> depthFirstRecur(String name);
   List<Vertex> depthFirstRecur(Vertex v);
   void depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable);
}

/* Graphs 5: Edgelist with Cities 
 */
interface EdgeListWithCities
{
   void graphFromEdgeListData(String fileName) throws FileNotFoundException;
   int edgeCount();
   int vertexCount(); //count the vertices in the object
   boolean isReachable(String source, String target);
   boolean isConnected();
}


public class AdjList implements AdjListInterface ,DFS_BFS ,EdgeListWithCities
{
   private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
   private Map<String, Integer> nameToIndex = new TreeMap<String, Integer>();
   private int numberOfNodes;
   public AdjList(){
      numberOfNodes = 0;
   }
  
 /* enter your code here  */
   public List<Vertex> getVertices(){
      return vertices;
   }
   public Vertex getVertex(int i){ // same thing as below but goes through the keyset
      for(String s: nameToIndex.keySet())
         if(nameToIndex.get(s) == i)
            return getVertex(s);
      return null;
   }
   public Vertex getVertex(String vertexName){
      for(Vertex e: vertices)// goes through and finds it
         if(e.getName().equals(vertexName))
            return e;
      return null;
   }
   public Map<String, Integer> getVertexMap(){
      return nameToIndex;
   }
   public void addVertex(String v){ //adds vertex in if not there already
      if(getVertex(v) == null){
         vertices.add(new Vertex(v));
         nameToIndex.put(v,numberOfNodes);
         numberOfNodes ++;
      }
      
   }
   public void addEdge(String source, String target){ // the extra lines solve the problem of it not being added yet
      Vertex v = getVertex(source);
      Vertex w = getVertex(target);
      if(v == null){
         addVertex(source);
         v = getVertex(source);
      }
      if(w == null){
         addVertex(target);
         w = getVertex(target);
      }
      v.addEdge(w);
   }
   public String toString(){
      String b = "";
      for(Vertex s: vertices)
         b += s.toString()+ "\n";
      return b;
   }
   
   
   public List<Vertex> depthFirstSearch(String name){
      ArrayList<Vertex> v = new ArrayList<Vertex>(); // arraylist with reachable vertices
      Stack<Vertex> s = new Stack<Vertex>(); // temportary storage
      s.push(getVertex(name));
      Vertex l = s.pop(); // taks first one out
      v.add(l);
      ArrayList<Vertex> temporary = l.getAdjacencies();
      for(Vertex e : temporary) // goes through ones to add and pushes
         s.push(e);
      while(!s.isEmpty()){ // goes till stack is empty
         if(v.indexOf(s.peek()) != -1) // if already in list
            s.pop();
         else{
            ArrayList<Vertex> temp = s.peek().getAdjacencies(); // otherwise does this instead
            v.add(s.pop());
            for(Vertex e : temp)
               s.push(e);
         }
      }
      return v;
      
   }
   public List<Vertex> depthFirstSearch(Vertex v){
      return depthFirstSearch(v.getName());
   
   }
   public List<Vertex> breadthFirstSearch(String name){
      ArrayList<Vertex> v = new ArrayList<Vertex>(); // arraylist with reachable vertices
      Queue<Vertex> s = new LinkedList<Vertex>(); // temportary storage
      s.add(getVertex(name));
      Vertex l = s.remove();
      v.add(l);
      ArrayList<Vertex> temporary = l.getAdjacencies();
      for(Vertex e : temporary)
         s.add(e);
      while(!s.isEmpty()){
         if(v.indexOf(s.peek()) != -1)
            s.remove();
         else{
            ArrayList<Vertex> temp = s.peek().getAdjacencies();
            v.add(s.remove());
            for(Vertex e : temp)
               s.add(e);
         }
      }
      return v;
   }
   public List<Vertex> breadthFirstSearch(Vertex v){
      return breadthFirstSearch(v.getName()); // calls other method
   }
 
 
 
   public void graphFromEdgeListData(String fileName) throws FileNotFoundException{
      Scanner sc = new Scanner(new File(fileName));
      while(sc.hasNextLine()){
         addEdge(sc.next(),sc.next()); // adds them in using the sc.next
      }
   }
   public int edgeCount(){
      int a = 0;
      for(String s: nameToIndex.keySet()){
         a += getVertex(s).getAdjacencies().size(); // counts adjacencies using keyset
      }
      return a;
   }
   public int vertexCount(){//count the vertices in the object
      int a = 0;
      for(String s: nameToIndex.keySet()){ // counts the vertices using the key set
         a += 1;
      }
      return a;
   }
   public boolean isReachable(String source, String target){
      if((depthFirstSearch(source)).indexOf(getVertex(target)) != -1)
         return true;
      return false;
   }
   public boolean isConnected(){
      Vertex v = vertices.get(0); // compares the depth first search to the vertex count
      if(depthFirstSearch(v).size() == vertexCount())
         return true;
      return false;
   }
 
 
 
 
 
 
 
 /*  three extra credit methods, recursive version  */
   public List<Vertex> depthFirstRecur(String name)
   {
      return null;
   }
   
   public List<Vertex> depthFirstRecur(Vertex v)
   {
      return null;
   }
   
   public void depthFirstRecurHelper(Vertex v, ArrayList<Vertex> reachable)
   {
      
   }   
}


