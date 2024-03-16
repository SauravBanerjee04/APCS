import java.util.*;
public class test{
   public static void main(String[] args){
      Stack<Integer> q = new Stack<Integer>();
      q.push(4);
      q.push(20);
      q.push(15);
      q.push(15);
      q.push(8);
      q.push(5);
      q.push(7);
      q.push(12);
      q.push(10);
      q.push(5);
      q.push(0);
      expunge(q);
   }
   public static void expunge(Stack<Integer> s){
      if(s.size() == 0)
      return; int b = 0; boolean r = true; 
      Queue<Integer> queue = new LinkedList<Integer>();
      b = s.peek();
      while(!s.isEmpty()){
      int a = s.pop();
      if(a >= b){
      queue.add(a);
      }
      b = a;
      }
//     //  q2s(queue,s);
//       s2q(s,queue);
//       q2s(queue,s);
   }
}
