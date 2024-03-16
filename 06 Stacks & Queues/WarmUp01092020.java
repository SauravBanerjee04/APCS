import java.util.*;
public class WarmUp01092020{
public static void main(String[] args){
   String s = "ABC";
   System.out.println(inverse(s));
   
}
public static String inverse(String s){
   Stack<Character> a = new Stack<Character>();
   for(char c: s.toCharArray()){
      a.push(new Character(c));
   }
   String d = "";
   while(!(a.isEmpty())){
      Character e = a.pop();
      if(Character.isLowerCase(e))
         d += Character.toUpperCase(e);
      else d+= Character.toLowerCase(e);
   
   }
   return d;
   }

}