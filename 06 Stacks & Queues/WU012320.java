import java.util.*;
public class WU012320{
public static void main(String[] args){

}
public static Queue<String> sortedQueue(Queue<String> f){
   Iterator d = f.iterator();
   PriorityQueue<String> l = new PriorityQueue<String>();
   while(d.hasNext())
      l.add((String)d.next());
   Iterator e = l.iterator();
   Queue<String> o = new LinkedList<String>();
   while(e.hasNext())
      o.add((String)e.next());
   return o;
   
}

}