// Name:S4-01
// Date:1/16/19

import java.util.*;

public class Infix
{
   public static void main(String[] args)
   {
      System.out.println("Infix  \t-->\tPostfix\t\t-->\tEvaluate");
     /*build your list of Infix expressions here  */
      ArrayList<String> infixExp = new ArrayList<String>();
      infixExp.add("3 - 4 + 5");
      infixExp.add("3 + 4 * 5");
      infixExp.add("3 * 4 + 5");
      infixExp.add("( -5 + 15 ) - 6 / 3");
      infixExp.add("( 3 + 4 ) * ( 5 + 6 )");
      infixExp.add("3 - 4 + 5");
      infixExp.add("( 3 * ( 4 + 5 ) - 2 ) / 5");
      infixExp.add("8 + -1 * 2 - 9 / 3");
      infixExp.add("3 * ( 4 * 5 + 6 )");
      infixExp.add("3 * ( 4 * 5 - 6 + 2 )");
       
      for( String infix : infixExp )
      {
         String pf = infixToPostfix(infix);  //get this to work first
         //System.out.println(infix + "\t\t\t" + pf); 
         System.out.println(infix + "\t\t\t" + pf + "\t\t\t" + Postfix.eval(pf));  //Postfix must work!
      }
   }
   
   public static String infixToPostfix(String infix)
   {
      List<String> infixParts = new ArrayList<String>(Arrays.asList(infix.split(" ")));
      /* enter your code here  */
      String result = ""; // result string
      Stack<String> stack = new Stack<String>(); // stack that was used
      for(String s: infixParts){
         if(Postfix.isOperator(s)){ // if opetator then keeps popping till conditions are satisfied
           //  if((stack.isEmpty()) || (stack.peek() == "(") || !isLowerOrEqual(s.charAt(0),(stack.peek()).charAt(0))){
         //                if(!stack.isEmpty() && stack.peek() != "(" && stack.peek() != ")")
         //                   result += (" " + stack.pop());
            while(!((stack.isEmpty()) || (stack.peek().equals("(")) || !isLowerOrEqual(s.charAt(0),(stack.peek()).charAt(0))))
               result += (" " + stack.pop());
            stack.push(s);
            //}
            //else result += (" " + s);
         }
         else if(s.equals("(")) // pushes left
            stack.push(s);
         else if(s.equals(")")){
            while((!stack.isEmpty()) && stack.peek() != "(")
               result = result + " " + stack.pop(); //goes through till left parentheses
            //result = result + " " + stack.pop();
         }
         else{
            result += (" " + s);
         }
      }
      while(!(stack.isEmpty())){
         if(Postfix.isOperator(stack.peek()))
            result += (" " + stack.pop()); // pops all the operators back
         else{
            String e = stack.pop();
         }
      }
      while(result.contains(" (")){
         int a = result.indexOf(" (");
         result = result.substring(0,a) + result.substring(a+2); // removes all the "(" don't know why it doesn't work normally tho?
      }
      return result;
   }
   
	//returns true if c1 has lower or equal precedence than c2
   public static boolean isLowerOrEqual(char c1, char c2)
   {
   // plus or minus is less than multiplication and division  (PE MD AS)
      if((c1 == '+') || (c1 == '-'))  // if its plus or minus then it's always true
         return true;
      else{ // case that is is * or /
         if((c2 == '*') || (c2 == '/')) // otherwise if same then returns true
            return true;
         else 
            return false; // otherwise returns false
      }
   }
   
}
	
/********************************************

 Infix  	-->	Postfix		-->	Evaluate
 3 - 4 + 5			3 4 - 5 +			4
 3 + 4 * 5			3 4 5 * +			23
 3 * 4 + 5			3 4 * 5 +			17
 ( -5 + 15 ) - 6 / 3			-5 15 + 6 3 / -			8
 ( 3 + 4 ) * ( 5 + 6 )			3 4 + 5 6 + *			77
 ( 3 * ( 4 + 5 ) - 2 ) / 5			3 4 5 + * 2 - 5 /			5
 8 + -1 * 2 - 9 / 3			8 -1 2 * + 9 3 / -			3
 3 * ( 4 * 5 + 6 )			3 4 5 * 6 + *			78
 3 * ( 4 * 5 - 6 + 2 )			3 4 5 * 6 - 2 + *			48
  
***********************************************/