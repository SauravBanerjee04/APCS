 //Name:   
 //Date:
 
import java.util.*;


/* implement the API for java.util.PriorityQueue
 * test this class with HeapPriorityQueue_Driver.java.
 * test this class with LunchRoom.java.
 * add(E) and remove()  must work in O(log n) time
 */
public class HeapPriorityQueue<E extends Comparable<E>> 
{
   private ArrayList<E> myHeap;
   
   public HeapPriorityQueue()
   {
      myHeap = new ArrayList<E>();
      myHeap.add(null);
   }
   
   public boolean add(E obj)
   {
     
   }
   
   public E remove()
   {
   
   }
   
   public E peek()
   {
   
   }
   
   public boolean isEmpty()
   {
     
   }
   
   private void heapUp(int k)
   {
         
   }
   
   private void swap(int a, int b)
   {
     
   }
   
   private void heapDown(int k, int size)
   {
   
   }
   
   public String toString()
   {
      return myHeap.toString();
   }  
}
