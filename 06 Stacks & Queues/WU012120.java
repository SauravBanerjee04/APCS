//Saurav Banerjee
//1/21/20



import java.util.*;
public class WU012120{
public static void main(String[] args){
   Queue<String> z = new LinkedList<String>();
   z.add("Bob");
   z.add("Bob");
   z.add("c");
   z.add("Bob");
   System.out.println(checkBob(z));
}
public static int checkBob(Queue<String> a){
int f = 0;
Queue<String> c = new LinkedList<String>();
while(!(a.isEmpty())){
   String b = a.remove();
   if(b.equals("Bob"))
      f++;
  c.add(b);
}
a = c;
return f;
}
}