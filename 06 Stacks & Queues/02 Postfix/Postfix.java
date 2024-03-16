// Name: S4-01
// Date: 1/13/20

import java.util.*;

public class Postfix
{
   public static void main(String[] args)
   {
      System.out.println("Postfix  -->  Evaluate");
      ArrayList<String> postfixExp = new ArrayList<String>();
      /*  build your list of expressions here  */
      postfixExp.add("3 4 5 * +");
      postfixExp.add("3 4 * 5 +");  
      postfixExp.add("10 20 + -6 6 * +");  
      postfixExp.add("3 4 + 5 6 + *");  
      postfixExp.add("3 4 5 + * 2 - 5 /");     
      postfixExp.add("8 1 2 * + 9 3 / -"); 
      postfixExp.add("2 3 ^"); 
      postfixExp.add("20 3 %"); 
      postfixExp.add("21 3 %"); 
      postfixExp.add("22 3 %"); 
      postfixExp.add("5 !"); 
      postfixExp.add("1 1 1 1 1 + + + + !"); 
      
         
      
      for( String pf : postfixExp )
      {
         System.out.println(pf + "\t\t" + eval(pf));
      }
   }
   
   public static int eval(String pf)
   {
      List<String> postfixParts = new ArrayList<String>(Arrays.asList(pf.split(" ")));
      /*  enter your code here  */
      Stack<Integer> stacked = new Stack<Integer>(); // stacks to store integers
      int a = 0; // placeholder for going through postFixParts
      int d = 0; // placeholder for last value
      int z = postfixParts.size(); // size of postFixParts
      stacked.add(0); // adds zero at beginnning
      while(a<z){
         while(!(isOperator((postfixParts.get(a))))){ // adds numbers into arrays
            stacked.add(Integer.parseInt(postfixParts.get(a)));
            a++;
         }
         boolean ee = true;
         while((ee) && isOperator(postfixParts.get(a))){ //looks for operators
            String f = postfixParts.get(a); // takes first operator
            //if(!firstOne){
               d = stacked.pop(); // takes first number
               //firstOne = true;
               
            //}
            int e = 0;
            if(!(stacked.isEmpty())){ // takes second number if there
               e = stacked.pop();
            }
            d = eval(e,d,f); // evals
            stacked.push(d); //does the calculation and adds the number back in
            a++;// increments a 
            if(!(a<z))
                  ee = false;
         }
      
      
      }
      return d; // returns last value
   }
   public static int eval(int a, int b, String ch)
   {
      int c = 1; // value will get returned
      switch(ch){
         case "+": // if +
            c = a+b;
            break;
         case "-": // if -
            c = a-b;
            break;
         case "*": // if *
            c = a*b;
            break;
         case "/": // if /
            c = a/b;
            break;
         case "^": // if ^
            c = (int)Math.pow(a,b);
            break;
         case "%": // if %
            c = a%b;
            break;
         case "!": // if !
            for(int d = 1; d <= b; d++)
               c = c*d;
            break;
      
      }
      return c; // returns value
   }
   
   public static boolean isOperator(String op)
   {
      String operators = "+-*/^%!"; // string of operators
      if(operators.contains(op)) // if there returned true
         return true;
      else 
         return false; // otherwise returns false
   
   }
}

/**********************************************
Postfix  -->  Evaluate
 3 4 5 * +		23
 3 4 * 5 +		17
 10 20 + -6 6 * +		-6
 3 4 + 5 6 + *		77
 3 4 5 + * 2 - 5 /		5
 8 1 2 * + 9 3 / -		7
 2 3 ^		8
 20 3 %		2
 21 3 %		0
 22 3 %		1
 23 3 %		2
 5 !		120
 1 1 1 1 1 + + + + !		120
 
 
 *************************************/