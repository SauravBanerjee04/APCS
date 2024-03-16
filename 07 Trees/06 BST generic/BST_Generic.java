// Name: S4-01
// Date: 2/27/20
import java.util.*;

interface BSTinterface<E>
{
   public int size();
   public boolean contains(E element);
   public E add(E element);
   public E addBalanced(E element);
   public E remove(E element);
   public String min();
   public String max();
   public String display();
   public String toString();
   //public ArrayList<E> toList();  //returns an in-order list of E
}

/*******************
  Copy your BST code.  Implement generics.
**********************/
public class BST_Generic<E extends Comparable<E>> implements BSTinterface<E>
{
   private TreeNode<E> root;
   private int size;
   public BST_Generic()
   {
      root = null;
      size = 0;
   }
   public ArrayList<E> toList(){
      ArrayList<E> returned = new ArrayList<E>();
      returned = toList(returned,root);
      return returned;
      
   }
   private ArrayList<E> toList(ArrayList<E> list,TreeNode<E> arg)
   {
      if(arg == null)
         return list;
      else{
      ArrayList<E> list2 = list;
      list2 = toList(list2, arg.getLeft());
      list2.add(arg.getValue());
      list2 = toList(list2, arg.getRight());
      return list2;
      }
   }
   
   public int size()
   {
      return size; // returns size
   }
   public TreeNode<E> getRoot()   //for Grade-It
   {
      return root; // returns root
   }
   /******
   @param s -- one string to be inserted
   ********/
   public E add(E s) 
   {
      add(root,s); // calls the recursive method
      size += 1; // increments size
      return s;
   }
   private void add(TreeNode<E> t, E s) 
   {      
      if(root == null){ // if its the first node adds it as the first one
         root = new TreeNode<E>(s,null,null); 
         return;
      }
      if((t.getLeft() == null) && (t.getRight() == null)){ // if a leaf 
         if(s.toString().compareTo(t.getValue().toString() + "") <= 0){ // cchecks if should be added left
            t.setLeft(new TreeNode<E>(s,null,null));
            return;
         }
         else{
            t.setRight(new TreeNode<E>(s,null,null)); //checks if should be added right
            return;
         }
      }
      else{ // if not a leaf 
         if(s.toString().compareTo(t.getValue().toString() + "") <= 0){  // if should go to the left still
            if(t.getLeft() == null){ // if null adds it there
               t.setLeft(new TreeNode<E>(s,null,null));
               return;
            }
            else{
               add(t.getLeft(),s); // otherwise calls recursive method
            
            }
         }
         else{ 
            if(t.getRight() == null){ // if goes right and the right is null
               t.setRight(new TreeNode<E>(s,null,null));
               return;
            }
            else {
               add(t.getRight(),s); // otherwise calls recursive method
            }
         }
      }
   
   }
   
   public String display()
   {
      return display(root,0); // calls the recursive method on root
   }
   private String display(TreeNode<E> t, int level)
   {
   // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue().toString() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   
   public boolean contains(E obj)
   {
      return contains(root,obj); // calls the recursive method contains
   }
   public boolean contains(TreeNode t, E x)
   {
      if(t == null) // if null returns false
         return false;
      if((t.getValue().toString() + "").equals(x)) // if the node has it returns true
         return true;
      else 
         return (contains(t.getLeft(),x) || contains(t.getRight(),x)); // otherwise returns whether one side has it
   }
   
   public String min()
   {
      return min(root); //calls the recursive method
   }
   private String min(TreeNode<E> t)  //use iteration
   {
      while(t.getLeft() != null) // goes to the left most node
         t = t.getLeft();
      return t.getValue().toString() + ""; // returns null
   }
   
   public String max()
   {
      return max(root); // calls recursive method
   }
   private String max(TreeNode<E> t)  //use recursion
   {
      if(/*(t.getLeft() == null) &&*/(t.getRight() == null)) // if at the end returns 
         return t.getValue() + "";
      // else{ // irrelevant code not needed 
   //       String value = t.getValue();
   //       String d;
   //       if(object.compareTo(max(t.getLeft())) < 0){
   //          d = t.getLeft().getValue() + "";
   //       }
   //       else d = value;
   //       if(d.compareTo(max(t.getRight())) < 0){
   //          d = t.getRight().getValue() + "";
   //       }
   //      return d;
      return max(t.getRight()); // otherwise calls the method on t.getRight(0
   }
   
   public String toString()
   {
      return toString(root); //calls recursive method
   }
   private String toString(TreeNode t)  //an in-order traversal
   {
      String toReturn = "";
      if(t == null){
         return "";
      }
      else{
         toReturn += toString(t.getLeft());   //recurse left
         toReturn += t.getValue().toString() + " ";              //preorder visit
         toReturn += toString(t.getRight());
      }  //recurse right
      return toReturn;
   }


   
   public E remove(E target)
   {
      root = remove(root, target.toString());
      size--;
      return target;
   }
   private TreeNode remove(TreeNode current, String target)
   {
      if(current == null)
         return null;
      if(((target).compareTo(current.getValue()+"")) > 0){ // if greater changes right
         return new TreeNode(current.getValue(),current.getLeft(),remove(current.getRight(),target));
      }
      if(((target).compareTo(current.getValue()+"")) < 0){ // if less changes left
         return new TreeNode(current.getValue(), remove(current.getLeft(),target), current.getRight());
      }
   //if((current.getValue() + "").equals(target)){
      if((current.getLeft() != null) && (current.getRight() != null)){ // if has two children
         TreeNode t = current;
         String replacement = max(t.getLeft());
         //String
         current.setValue(replacement);
         remove(current.getLeft(),target);
         return current;
            
            /*return root;*/
      }
      else if(current.getLeft() != null){ // if has only left child
         current.setValue(current.getLeft().getValue()+"");
         current.setRight(current.getLeft().getRight());
         current.setLeft(current.getLeft().getLeft());
         return current;
      }
      else if(current.getRight()!= null){
         current.setValue(current.getRight().getValue()+"");
         current.setLeft(current.getRight().getLeft());
         current.setRight(current.getRight().getRight());
         return current;
      }
      else if((current.getLeft() == null) && (current.getRight() == null))
         return null;
      else{
         return current;
      }
   }
   public E addBalanced(E obj){
      if (root == null){
         root = new TreeNode(obj,null,null);
         size ++;
         return obj;
      }
      else{
         addBalanced(root,obj);
         size ++;
         return obj;
      }
   }
   public void addBalanced(TreeNode t, E obj){
      if(root == null){ // if its the first node addBalanceds it as the first one
         root = new TreeNode(obj,null,null); 
         return;
      }
      
      
      balanceTree(t);
      
      if((t.getLeft() == null) && (t.getRight() == null)){ // if a leaf 
         if(obj.toString().compareTo(t.getValue().toString() + "") <= 0){ // cchecks if should be addBalanceded left
            t.setLeft(new TreeNode<E>(obj,null,null));
            balanceTree(t);
            return;
         }
         else{
            t.setRight(new TreeNode<E>(obj,null,null)); //checks if should be addBalanceded right
            balanceTree(t); // balances tree
            return;
         }
      }
      else{ // if not a leaf 
         if(obj.toString().compareTo(t.getValue().toString() + "") <= 0){  // if should go to the left still
            if(t.getLeft() == null){ // if null addBalanceds it there
               t.setLeft(new TreeNode<E>(obj,null,null));
               balanceTree(t); // balances tree
               return;
            }
            else{
               addBalanced(t.getLeft(),obj); // otherwise calls recursive method
               balanceTree(t);
               return;
            
            }
         }
         else{ 
            if(t.getRight() == null){ // if goes right and the right is null
               t.setRight(new TreeNode<E>(obj,null,null));
               balanceTree(t);
               return;
            }
            else 
               addBalanced(t.getRight(),obj); // otherwise calls recursive method
               balanceTree(t);
               return;
         }
      }
   
   
      
         
         
         
   }
   public void balanceTree(TreeNode<E> t){
      int balance = bal(t);
      if(balance > 1){
         if(bal(t.getRight()) < -1){
            TreeNode<E> f = doubleLeft(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
            
         }
         else{
            TreeNode<E> f = leftRotate(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
            balanceTree(t.getLeft());
            balanceTree(t.getRight());
         }
      }
      else if(balance < -1){
         if(bal(t.getLeft()) > 1){
            TreeNode<E> f = doubleRight(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
            balanceTree(t.getLeft());
            balanceTree(t.getRight());
         }
         else{
            TreeNode<E> f = rightRotate(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
         }
      }
   }
   private int bal(TreeNode<E> t){
      int left = height(t.getLeft());
      int right = height(t.getRight());
      int balance = right - left;
      return balance;
   }
   private TreeNode leftRotate(TreeNode<E> a){
      TreeNode<E> b = a.getRight();
      TreeNode<E> copyA = new TreeNode(a.getValue(),a.getLeft(),b.getLeft());
      b.setLeft(copyA);//
      return b;
      
   }
      
   private TreeNode rightRotate(TreeNode<E> c){
      TreeNode b = c.getLeft();
      TreeNode copyC = new TreeNode<E>(c.getValue(),b.getRight(),c.getLeft());
      b.setRight(copyC);
      return b;
   }
   private TreeNode<E> doubleLeft(TreeNode<E> a){
      a.setRight(rightRotate(a.getRight()));
      a = leftRotate(a);
      return new TreeNode<E>(a.getValue(),a.getLeft(),a.getRight());
   }
   private TreeNode<E> doubleRight(TreeNode<E> a){
      a.setLeft(leftRotate(a.getLeft()));
      a = rightRotate(a);
      return new TreeNode<E>(a.getValue(),a.getLeft(),a.getRight());
   }
      
      
      
   private int height(TreeNode<E> t)
   {
      /*
      if t == null return -1
      return 1 + max(height(left), height(right))
      */
      if(t == null) 
         return -1;
      /*else if((t.getLeft() == null) && (t.getRight() != null)){ // returns right side + 1 if one child
         return 1 + height(t.getRight());  
      }
      else if((t.getLeft() != null) && (t.getRight() == null)){ // if one child
         return 1 + height(t.getLeft());   
      }
      else if((t.getLeft() == null) && (t.getRight() == null))
         return 0;
      else*/
         return 1 + Math.max(height(t.getLeft()), height(t.getRight())); // if has two childs
      
      
      //return -1;
   }
         
         
      //}
     
   // public void clearNulls(TreeNode t){
      // if(t.getLeft().getValue() == null){
         // t.setLeft(null);
      // }
      // if(t.getRight().getValue() == null){
         // t.setRight(null);
      // }
      // if(t.getRight() != null)
         // clearNulls(t.getRight());
      // if(t.getLeft() != null)
         // clearNulls(t.getLeft());
   // }
   
   private boolean isLeaf(TreeNode<E> t){
      return ((t.getLeft() == null) && (t.getRight() == null));
   }



}

/*******************
  Copy your TreeNode code.  Implement generics.
**********************/
class TreeNode<E>
{
      private E value; 
      private TreeNode<E> left, right;
   
       public TreeNode(E initValue)
      { 
         value = initValue; 
         left = null; 
         right = null; 
      }
   
       public TreeNode(E initValue, TreeNode<E> initLeft, TreeNode<E> initRight)
      { 
         value = initValue; 
         left = initLeft; 
         right = initRight; 
      }
   
       public E getValue()
      { 
         return value; 
      }
   
       public TreeNode<E> getLeft() 
      { 
         return left; 
      }
   
       public TreeNode<E> getRight() 
      { 
         return right; 
      }
   
       public void setValue(E theNewValue) 
      { 
         value = theNewValue; 
      }
   
       public void setLeft(TreeNode<E> theNewLeft) 
      { 
         left = theNewLeft;
      }
   
       public void setRight(TreeNode<E> theNewRight)
      { 
         right = theNewRight;
      }

}