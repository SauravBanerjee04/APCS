// Name:   S4-01
// Date:   6/5/20
 
import java.util.*;
import java.io.*;

/* Resource classes and interfaces
 * for use with Graphs6: Dijkstra
 *              Graphs7: Dijkstra with Cities
 */

class Edge 
{
   public final wVertex target;  //if it's public, you don't need accessor methods
   public final double weight;   //if it's public, you don't need accessor methods
  
   public Edge(wVertex argTarget, double argWeight) 
   {
      target = argTarget;
      weight = argWeight;
   }
}

interface wVertexInterface 
{
   String getName();
   double getMinDistance();
   void setMinDistance(double m);
   //wVertex getPrevious();   //for Dijkstra 7
   //void setPrevious(wVertex v);  //for Dijkstra 7
   ArrayList<Edge> getAdjacencies();
   void addEdge(wVertex v, double weight);   
   int compareTo(wVertex other);
}

class wVertex implements Comparable<wVertex>, wVertexInterface
{
   private final String name;
   private ArrayList<Edge> adjacencies;
   private double minDistance = Double.POSITIVE_INFINITY;
   //private wVertex previous;  //for building the actual path in Dijkstra 7
   
   /*  enter your code for this class here   */ 
   public wVertex(String s){
      name = s;
      adjacencies = new ArrayList<Edge>();
   }
   public String getName(){
      return name;
   }
   public double getMinDistance(){
      return minDistance;
   }
   public void setMinDistance(double m){
      minDistance = m;
   }
   public ArrayList<Edge> getAdjacencies(){
      return adjacencies;
   }
   public void addEdge(wVertex v, double weight){
      Edge e = new Edge(v,weight);
      adjacencies.add(e);
   }
   public int compareTo(wVertex other){
      double d = minDistance - other.getMinDistance();
      if(d < 0)
         return -1;
      if(d>0)
         return 1;
      return 0;
   }
}

interface AdjListWeightedInterface 
{
   List<wVertex> getVertices();
   Map<String, Integer> getNameToIndex();
   wVertex getVertex(int i);   
   wVertex getVertex(String vertexName);
   void addVertex(String v);
   void addEdge(String source, String target, double weight);
   void minimumWeightPath(String vertexName);   //Dijkstra's
}

/* Interface for Graphs 7:  Dijkstra with Cities 
 */

interface AdjListWeightedInterfaceWithCities 
{       
   List<String> getShortestPathTo(wVertex v);
   AdjListWeighted graphFromEdgeListData(File vertexNames, File edgeListData) throws FileNotFoundException ;
}
 

public class AdjListWeighted implements AdjListWeightedInterface //,AdjListWeightedInterfaceWithCities
{
   private List<wVertex> vertices = new ArrayList<wVertex>();
   private Map<String, Integer> nameToIndex = new HashMap<String, Integer>();
   int number = 0;
   //the constructor is a no-arg constructor 
   public AdjListWeighted(){
   }
   /*  enter your code for Graphs 6 */ 
   public List<wVertex> getVertices(){
      return vertices;
   }
   public Map<String, Integer> getNameToIndex(){
      return nameToIndex;
   }
  public wVertex getVertex(int i){
      for(String s: nameToIndex.keySet())
         if(nameToIndex.get(s) == i)
            return getVertex(s);
      return null;
   }
   public wVertex getVertex(String vertexName){
      for(wVertex e: vertices)// goes through and finds it
         if(e.getName().equals(vertexName))
            return e;
      return null;
   }
   public void addVertex(String v){
      if(getVertex(v) == null){
         vertices.add(new wVertex(v));
         nameToIndex.put(v,number);
         number ++;
      }
   
   }
   public void addEdge(String source, String target, double weight){
   getVertex(source).addEdge(getVertex(target),weight);
   }
   public void minimumWeightPath(String vertexName){
      ArrayList<Edge> a = getVertex(vertexName).getAdjacencies();
      PriorityQueue<wVertex> queue = new PriorityQueue<wVertex>();
      queue.add(getVertex(vertexName));
      queue.peek().setMinDistance(0);
      for(int i = 0; i < a.size(); i++){
         queue.add(a.get(i).target);      
      }
      while(!queue.isEmpty()){
         wVertex l = queue.remove();
         ArrayList<Edge> e = l.getAdjacencies();
         for(Edge f : e)
            if(l.getMinDistance() + f.weight < f.target.getMinDistance())
               f.target.setMinDistance(l.getMinDistance() + f.weight);

      }
      
   
   }
   
   
   
   /*  enter your code for two new methods in Graphs 7 */
   
   
}   


