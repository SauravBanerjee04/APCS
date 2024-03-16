// Name:S4-01
// Date:11/26/19

//  implements some of the List and LinkedList interfaces: 
//	 	  size(), add(i, o), remove(i);  addFirst(o), addLast(o); 
//  This class also overrides toString().
//  the list is zero-indexed.
//  Uses DLNode.

public class DLL        //DoubleLinkedList
{
   private int size;
   private DLNode head = new DLNode(); //dummy node--very useful--simplifies the code
   
   public int size()
   {
      DLNode m = head; // makes a new node
      if(m == null) // if head was null returns 0
         return 0;
      int a = 0; // variable for length
      while(m != null){
         a ++; // as there are more terms the things increase
         m = m.getNext(); // goes through
      }
      return a; // returns length
   }
   
   /* appends obj to end of list; increases size;
   	  @return true  */
   public boolean add(Object obj)
   {
      addLast(obj);
      return true;   
   }
   
   /* inserts obj at position index.  increments size. 	*/
   public void add(int index, Object obj) throws IndexOutOfBoundsException  //this the way the real LinkedList is coded
   {
      if( index > size || index < 0 )
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
     //  if(index >= size || index < 0)
      else
      {
      if(index == 0){  // if index is 0 
      addFirst(obj);
      return;
      }
      
      DLNode l =  head; // new node 
      for(int k = 0; k < index -1; k++){
         l = l.getNext(); // goes through 
         
      }
      DLNode temp = l.getNext(); // stores value
      l.setNext(new DLNode(obj,l,temp)); // adds thing
      size = size(); // size changes
      }
                    
                    
   }
   
   /* return obj at position index. 	*/
   public Object get(int index)
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode l =  head;  // new node
      for(int k = 0; k < index; k++){
         l = l.getNext(); // goes through list
      }
      return l.getValue(); // returns value
      
   }
   
   /* replaces obj at position index. 
        returns the obj that was replaced*/
   public Object set(int index, Object obj)
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode l =  head;  // new node
      for(int k = 0; k < index; k++){
         l = l.getNext(); // goes through
      }
      Object d = l.getValue(); // holds value
      l.setValue(obj); // sets value
      size = size(); // changes size not sure why i need it? but it doesnt work otherwise
      return d; // returns replaced value
   }
   
   /*  removes the node from position index (zero-indexed).  decrements size.
       @return the object of the node that was removed.    */
   public Object remove(int index)
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      /* enter your code below  */
      DLNode l =  head; // new node
      for(int k = 0; k < index - 1; k++){
         l = l.getNext(); // goes through
      }
      DLNode j = l.getNext(); // node that will be removed
      l.setNext(l.getNext().getNext()); //removes the value
      size = size(); // decrements size 
      return j.getValue(); // returns 
   }
   
   /* inserts obj at front of list, increases size   */
   public void addFirst(Object obj)
   {
      DLNode node = new DLNode(obj,null, head); // new node
      head.setPrev(node); // adds nodes into
      head = node; // makes head as node
      size = size(); // increases size
   }
   
   /* appends obj to end of list, increases size    */
   public void addLast(Object obj)
   {
      
      if(head.getValue() == null){ // if empty instantiates head
         head = new DLNode(obj,null,null);
         return;
      }
      DLNode node = head; // new node
      while(node.getNext() != null)
         node = node.getNext(); // goes to end
      node.setNext(new DLNode(obj,node,null)); // adds new end
      size = size(); // increments size
   
   }
   
   /* returns the first element in this list  */
   public Object getFirst()
   {
      return head.getValue();
   }
   
   /* returns the last element in this list  */
   public Object getLast()
   {
      DLNode node = head; // copy
      while(node.getNext() != null) //goes to end
         node = node.getNext();
      return node.getValue(); // returns last element
   }
   
   /* returns and removes the first element in this list, or
       returns null if the list is empty  */
   public Object removeFirst()
   {
      if(head == null) // if empty returns null
         return null;
      else{
         Object j = head.getValue(); // otherwise removes the first and changes size
         head = head.getNext();
         head.setPrev(null);
         size = size();
         return j;
      }
   }
   
   /* returns and removes the last element in this list, or
       returns null if the list is empty  */
   public Object removeLast()
   {
      if(head == null){ // returns null if empty
      return null;
      }
      DLNode node = head;
      while(node.getNext().getNext() != null)
         node = node.getNext();
      Object j = node.getNext().getValue();
      node.setNext(null);
      size = size();
      return j;
   }
   
   /*  returns a String with the values in the list in a 
       friendly format, for example   [Apple, Banana, Cucumber]
       The values are enclosed in [], separated by one comma and one space.
    */
   public String toString()
   {
      DLNode node = head; // new node
      String s = ""; // starts string
      s += ("["); // open brackets
      while(node != null){ // adds values
         if(node.getNext() == null){
            s += (node.getValue());
            node = node.getNext();
         }
         else{
         s += (node.getValue() + ", ");
         node = node.getNext();
         }
      }
      s +=("]"); // closes
      return s; // returns
   }
}