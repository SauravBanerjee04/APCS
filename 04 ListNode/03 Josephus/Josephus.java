// Name: S4-01
// Date: 11/21/19

import java.util.*;
import java.io.*;

public class Josephus
{
   private static String WINNER = "Josephus";
   
   public static void main(String[] args) throws FileNotFoundException
   {
      // ListNode head, p;
//       head = p = new ListNode("A", null);
//       p.setNext(head);
//       p = insert(p, "B");
//       p = insert(p, "C");
//       p = insert(p, "D");
//       print(p);
        
      /* run numberCircle first with J_numbers.txt  */
      Scanner sc = new Scanner(System.in);
      System.out.print("How many names (2-20)? ");
      int n = Integer.parseInt(sc.next());
      System.out.print("How many names to count off each time?"  );
      int countOff = Integer.parseInt(sc.next());
      ListNode winningPos = numberCircle(n, countOff, "J_numbers.txt");
      System.out.println(winningPos.getValue() + " wins!");  
     
      /* run josephusCircle next with J_names.txt  */
      System.out.println("\n ****  Now start all over. **** \n");
      System.out.print("Where should "+WINNER+" stand?  ");
      int winPos = Integer.parseInt(sc.next());        
      ListNode theWinner = josephusCircle(n, countOff, "J_names.txt", winPos);
      System.out.println(theWinner.getValue() + " wins!");  
   }
   
   public static ListNode numberCircle(int n, int countOff, String filename) throws FileNotFoundException
   {
      ListNode p = null;
      p = readNLinesOfFile(n, new File(filename));
      p = countingOff(p, countOff, n);
      return p;
   }
   
   public static ListNode josephusCircle(int n, int countOff, String filename, int winPos) throws FileNotFoundException
   {
      ListNode p = null;
      p = readNLinesOfFile(n, new File(filename));
      replaceAt(p, WINNER, winPos);
      p = countingOff(p, countOff, n);
      return p;
   }

   /* reads the names, calls insert(), builds the linked list.
	 */
   public static ListNode readNLinesOfFile(int n, File f) throws FileNotFoundException
   {
   Scanner sc = new Scanner(f); // creates scanner going through f
   ListNode e = new ListNode(sc.next(),null); // makes a listNode with the first argument
   e.setNext(e); // makes the ListNode circular
   for(int a = 1; a < n; a ++){
      String s = sc.next(); //reads the next value
      e = insert(e,s); // inserts it into the 
   }
   sc.close();
   return e;
      
   }
   
   /* helper method to build the list.  Creates the node, then
    * inserts it in the circular linked list.
	 */
   public static ListNode insert(ListNode p, Object obj)
   {
   ListNode e = new ListNode(obj,p.getNext()); // creates a new listNode
   p.setNext(e); // adds e into the array
   p = p.getNext(); // rotates the listNode // note this is still kinda rotated but we take acct for that in print and counting off
   return p;
   }
   
   /* Runs a Josephus game, counting off and removing each name. Prints after each removal.
      Ends with one remaining name, who is the winner. 
	 */
   public static ListNode countingOff(ListNode p, int count, int n)
   {
   if(n == 1){
   print(p);  // pritns
   return p;// if only one then returns
   }
   print(p); // prints
   p = remove(p,count); // removes it
   return countingOff(p,count,n-1); // calls recursive method
   }
   
   /* removes the node after counting off count-1 nodes.
	 */
   public static ListNode remove(ListNode p, int count)
   {
   ListNode d = p; // listnode that is basically the same as p
   for(int a = 1; a < count; a++)
      d = d.getNext(); // goes through nodes
   d.setNext(d.getNext().getNext()); // removes the node
   return d/*.getNext()*/; // returns the node
   }
   
   /* prints the circular linked list.
	 */
   public static void print(ListNode p)
   {
   ListNode l = p.getNext(); // node was rotated
   while(l != p){ // prints values to the end
      System.out.print(l.getValue() + " ");
      l = l.getNext();
   }
   System.out.print(l.getValue() + " "); // prints final value
   System.out.println(""); // makes new line
   }
	
   /* replaces the value (the string) at the winning node.
	 */
   public static void replaceAt(ListNode p, Object obj, int pos)
   {
   ListNode l = new ListNode(p.getValue(),p.getNext()); // listNode that is basically p
   for(int a = 0; a < pos; a++){ // goes thorugh array
      l = l.getNext();
   }
   l.setValue(obj); // sets post to josephus
   }
}

