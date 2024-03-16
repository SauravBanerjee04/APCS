// Name:     S4-01
// Date:     11/11/19
import java.util.*;
public class ListLab1
{
   public static void main(String[] args)
   {
      ListNode head = new ListNode("hello", null);
      head = new ListNode("foo", head);
      head = new ListNode("boo", head);
      head = new ListNode("nonsense", head);
      head = new ListNode("computer",
         	new ListNode("science",
         		new ListNode("java",
         			new ListNode("coffee", head)
         		)
         	)
         );
      print(head);
      print(head);
      
      /**** uncomment the code below for ListLab1 Assignment  ****/
      //
      ListNode a = copyNode(head);
      System.out.println("The head has a value \"" + head.getValue() + "\" at "+ head);
      System.out.println("The copy of head has a value of \"" + a.getValue() + "\" at "+ a);
   
      System.out.print("Copy the list: ");
      ListNode copy = copyList(head);
      print(copy);
   
      System.out.print("The rest of the list: ");
      ListNode theRest = rest(copy);
      print(theRest);
   
      System.out.println("First of the rest = " + first(theRest));
      System.out.println("Second of the rest = " + second(theRest));
      ListNode p = pointerToLast(theRest);
      System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);
      ListNode c = copyOfLast(theRest);
      System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);
   
      Scanner in = new Scanner(System.in);
      System.out.print("Insert what? ");
      String x = in.next();
      theRest = insertFirst(theRest, x);
      theRest = insertLast(theRest, x);
      print(theRest); //
   }
   public static void print(ListNode head)
   {
      System.out.print("[");
      while(head != null)
      {
         System.out.print(head.getValue());
         head = head.getNext();
         if(head != null)
            System.out.print(", ");
      }
      System.out.println("]");
   }
   
   /* enter your code here */
   public static ListNode copyNode(ListNode arg){
      return new ListNode(arg.getValue(),arg.getNext()); // returns a new list node with same arguments
   }
   public static ListNode copyList(ListNode arg){
      if(arg.getNext() == null)
         return copyNode(arg); // if at the end returns the arg
      else return new ListNode(copyNode(arg).getValue(),copyList(arg.getNext())); // returns the chain of listNodes
   }
   public static ListNode rest(ListNode h){
       if(h.getNext() == null)
         return null; // if at end returns
       else return new ListNode(copyNode(h.getNext()).getValue(),rest(copyNode(h.getNext()))); // else returns the next listNode
   }
   public static Object first(ListNode head){
      return copyNode(head).getValue(); // returns the first value
   }
   public static Object second(ListNode head){
      return rest(head).getValue(); // returns the second value
   }
   public static ListNode pointerToLast(ListNode head){
      if(rest(head) == null)
         return head; // if last returns
      else return pointerToLast(head.getNext()); // goes down list
   }
   public static ListNode copyOfLast(ListNode head){
      if(rest(head) == null)
         return copyNode(head); // if last returns
      else return copyOfLast(rest(head)); // else goes down
      
   }
   public static ListNode insertFirst(ListNode head, Object arg){
      head = new ListNode(arg,head); // adds arg at beginning
      return head; // returns head
   }
   public static ListNode insertLast(ListNode head, Object arg){
      ListNode p = pointerToLast(head); // finds the last one
      p.setNext(new ListNode(arg,null)); // adds the new pointer
      return head; // returns head
   }
   
   
      
}

/*****************************************
 
 [computer, science, java, coffee, nonsense, boo, foo, hello]
 [computer, science, java, coffee, nonsense, boo, foo, hello]
 The head has a value "computer" at ListNode@15db9742
 The copy of head has a value of "computer" at ListNode@6d06d69c
 Copy the list: [computer, science, java, coffee, nonsense, boo, foo, hello]
 The rest of the list: [science, java, coffee, nonsense, boo, foo, hello]
 First of the rest = science
 Second of the rest = java
 Pointer to Last = hello at ListNode@7852e922
 Copy of Last =    hello at ListNode@4e25154f
 Insert what? p
 [p, science, java, coffee, nonsense, boo, foo, hello, p]
    
  **********************************************/
