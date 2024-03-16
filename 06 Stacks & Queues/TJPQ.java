import java.util.*;
public class TJPQ<E extends Comparable<E>>{
   private LinkedList<E> d;
   public TJPQ(){
      d = new LinkedList<E>();
   }

   public boolean isEmpty(){
      return data.size() == 0;
   }
   public void add(E entry){
      // if(d.size() == 0)
//          d.add(entry);
//       else{
//          int a = 0;
//          while((a < d.size())){
//             if(entry.compareTo(d.get(a)) < 0){
//                d.add(a,entry);
//                return;
//             }
//             else a++;
//          }
//       }
      int i = 0;
      while((i< data.size()) && entry.compareTo(data.get(i)) > = 0){
      i++;}
      data.add(i,entry);
   }
   public E peek(){
      if(!d.isEmpty())
         return d.get(0);
      else 
         return null;
   }
   public E remove(){
      if(!isEmpty())
         return d.remove(0);
      else 
         return null;
   }



}