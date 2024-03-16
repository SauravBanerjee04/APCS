// Name:S4-01
// Date:1/9/2020

import java.util.*;

public class ParenMatch
{
   public static final String LEFT  = "([{<";
   public static final String RIGHT = ")]}>";
   
   public static void main(String[] args)
   {
      System.out.println("Parentheses Match");
      ArrayList<String> parenExp = new ArrayList<String>();
      /* enter test cases here */
      parenExp.add("(123132131321)");
      parenExp.add("[(12313)1321<13213>1231}1123");
      parenExp.add("[(1212{)<>21313}]");
      parenExp.add("[1231321{(21313)<12312313>}12313]");
      parenExp.add("[<");
      parenExp.add("))");
   
      for( String s : parenExp )
      {
         boolean good = checkParen(s);
         if(good)
            System.out.println(s + "\t good!");
         else
            System.out.println(s + "\t BAD");
      }
   }
   
   public static boolean checkParen(String exp)
   {
   String b = LEFT + RIGHT; // string of all the grouping symbols
   Stack<Character> a = new Stack<Character>(); // makes a stack for all the grouping symbols
   for(char c: exp.toCharArray()){ // goes through and pushes all the grouping symbols
      if(b.contains(c + ""))
         a.push(new Character(c));
   }
   Stack<Character> rightGroupings = new Stack<Character>(); // stack for all the popped right grouping symbols
      while(!a.isEmpty()){ // checks if we're done
      Character d = a.peek(); // peeks 
      if(RIGHT.contains(d+"")){ // if right grouping symbols pops and pushes to the other stack
         Character temp = a.pop();
         Character l = rightGroupings.push(temp);
      }
      else if(LEFT.contains(d+"")){ // if left
         if(rightGroupings.isEmpty()) // if there's too many left returns false
            return false;
         if(!(LEFT.indexOf(a.pop()) == RIGHT.indexOf(rightGroupings.pop()))){ // if they are not a match returns false
         return false;
         }
      }
      
      }
      if(a.isEmpty() && rightGroupings.isEmpty())
      return true; // if both are empty returns true
      else return false; // otherwise returns 0
   
   }
}

/*
 Parentheses Match
 5+7	 good!
 (5+7)	 good!
 )5+7(	 BAD
 ((5+7)*3)	 good!
 <{5+7}*3>	 good!
 [(5+7)*]3	 good!
 (5+7)*3	 good!
 5+(7*3)	 good!
 ((5+7)*3	 BAD
 [(5+7]*3)	 BAD
 [(5+7)*3])	 BAD
 ([(5+7)*3]	 BAD
 */
