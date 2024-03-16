// Name: S4-01
// Date: 3/9/20

import java.util.*;
import java.io.*;

public class SetsOfLetters
{
   public static void main(String[] args) throws FileNotFoundException
   {
      String fileName = "declarationLast.txt";
      fillTheSets(fileName);
   }
   
   public static void fillTheSets(String fn) throws FileNotFoundException
   {
      Scanner infile = new Scanner(new File(fn));
      Set<Character> d1 = new TreeSet<Character>(); //sets to keep common elements
      Set<Character> d2 = new TreeSet<Character>();
      Set<Character> d3 = new TreeSet<Character>();
      d1 = null; d2= null; d3 = null; // beginning state
      
      /*  enter your code here  */
      while(infile.hasNextLine()){
         String string = infile.nextLine(); // takes next lines
         Set<Character> t1 = new TreeSet<Character>();  // tree sets for lower,upper, and other case
         Set<Character> t2 = new TreeSet<Character>();
         Set<Character> t3 = new TreeSet<Character>();
         System.out.println(string);// prints string
         char[] d = string.toCharArray(); // makes a char array
         for(char c: d){
            if(Character.toString(c).equals(" ")){ // does nothing if blank space
            
            }
            else if(Character.isLowerCase(c)) // otherwise adds it to the right place
               t1.add(new Character(c));
            else if(Character.isUpperCase(c))
               t2.add(new Character(c));
            else t3.add(new Character(c));
         
         }
         if(d1 == null) // sets d1 if not set
            d1 = t1;
         else
            d1.retainAll(t1); //checks common elements
         if(d2 == null)
            d2 = t2;
         else
            d2.retainAll(t2);
         if(d3 == null)
            d3 = t3;
         else
            d3.retainAll(t3);
         
         System.out.println("Lower Case: " + t1.toString()); // prints lowercase
         System.out.println("Upper Case: " + t2.toString()); // prints upperase
         System.out.println("Other: " + t3.toString()); // prints other
         System.out.println();
         
      }
      System.out.println("Common Lower Case: " + d1); // prints common ones
      System.out.println("Common Upper Case: " + d2);
      System.out.println("Common Other: " + d3);
      
   }
   
}

/***********************************
  ----jGRASP exec: java SetsOfLetters_teacher
 
 We, therefore, the Representatives of the united States of 
 Lower Case: [a, d, e, f, h, i, n, o, p, r, s, t, u, v]
 Upper Case: [R, S, W]
 Other: [ , ,]
 
 America, in General Congress, Assembled, appealing to the 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, p, r, s, t]
 Upper Case: [A, C, G]
 Other: [ , ,]
 
 Supreme Judge of the world for the rectitude of our intentions,
 Lower Case: [c, d, e, f, g, h, i, l, m, n, o, p, r, s, t, u, w]
 Upper Case: [J, S]
 Other: [ , ,]
 
 do, in the Name, and by the Authority of the good People of 
 Lower Case: [a, b, d, e, f, g, h, i, l, m, n, o, p, r, t, u, y]
 Upper Case: [A, N, P]
 Other: [ , ,]
 
 these Colonies, solemnly publish and declare, That these United 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, u, y]
 Upper Case: [C, T, U]
 Other: [ , ,]
 
 Colonies are, and of Right ought to be Free and Independent 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, p, r, s, t, u]
 Upper Case: [C, F, I, R]
 Other: [ , ,]
 
 States; that they are Absolved from all Allegiance to the 
 Lower Case: [a, b, c, d, e, f, g, h, i, l, m, n, o, r, s, t, v, y]
 Upper Case: [A, S]
 Other: [ , ;]
 
 British Crown, and that all political connection between them 
 Lower Case: [a, b, c, d, e, h, i, l, m, n, o, p, r, s, t, w]
 Upper Case: [B, C]
 Other: [ , ,]
 
 and the State of Great Britain, is and ought to be totally 
 Lower Case: [a, b, d, e, f, g, h, i, l, n, o, r, s, t, u, y]
 Upper Case: [B, G, S]
 Other: [ , ,]
 
 dissolved; and that as Free and Independent States, they have 
 Lower Case: [a, d, e, h, i, l, n, o, p, r, s, t, v, y]
 Upper Case: [F, I, S]
 Other: [ , ,, ;]
 
 full Power to levy War, conclude Peace, contract Alliances, 
 Lower Case: [a, c, d, e, f, i, l, n, o, r, s, t, u, v, w, y]
 Upper Case: [A, P, W]
 Other: [ , ,]
 
 establish Commerce, and to do all other Acts and Things which 
 Lower Case: [a, b, c, d, e, g, h, i, l, m, n, o, r, s, t, w]
 Upper Case: [A, C, T]
 Other: [ , ,]
 
 Independent States may of right do. And for the support of this 
 Lower Case: [a, d, e, f, g, h, i, m, n, o, p, r, s, t, u, y]
 Upper Case: [A, I, S]
 Other: [ , .]
 
 Declaration, with a firm reliance on the protection of divine 
 Lower Case: [a, c, d, e, f, h, i, l, m, n, o, p, r, t, v, w]
 Upper Case: [D]
 Other: [ , ,]
 
 Providence, we mutually pledge to each other our Lives, our 
 Lower Case: [a, c, d, e, g, h, i, l, m, n, o, p, r, s, t, u, v, w, y]
 Upper Case: [L, P]
 Other: [ , ,]
 
 Fortunes and our sacred Honor.
 Lower Case: [a, c, d, e, n, o, r, s, t, u]
 Upper Case: [F, H]
 Other: [ , .]
 
 Common Lower Case: [d, e, n, o, r, t]
 Common Upper Case: []
 Common Other: [ ]
  ----jGRASP: operation complete.
  ************************************/