// Name: S4-01
// Date: 2/20/20

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   public void remove(String obj);
   public String min();
   public String max();
   public String display();
   public String toString();
}

/*******************
Copy your BST code.  Implement the remove() method.
Test it with BST_Delete.java
**********************/
public class BST implements BSTinterface
{
   private TreeNode root;
   private int size;
   public BST()
   {
      root = null;
      size = 0;
   }
   public int size()
   {
      return size; // returns size
   }
   public TreeNode getRoot()   //for Grade-It
   {
      return root; // returns root
   }
   /******
   @param s -- one string to be inserted
   ********/
   public void add(String s) 
   {
      add(root,s); // calls the recursive method
      size += 1; // increments size
   }
   private TreeNode add(TreeNode t, String s) 
   {      
      if(root == null){ // if its the first node adds it as the first one
         root = new TreeNode(s,null,null); 
         return root;
      }
      if((t.getLeft() == null) && (t.getRight() == null)){ // if a leaf 
         if(s.compareTo(t.getValue() + "") <= 0){ // cchecks if should be added left
            t.setLeft(new TreeNode(s,null,null));
            return t.getLeft();
         }
         else{
            t.setRight(new TreeNode(s,null,null)); //checks if should be added right
            return t.getRight();
         }
      }
      else{ // if not a leaf 
         if(s.compareTo(t.getValue() + "") <= 0){  // if should go to the left still
            if(t.getLeft() == null){ // if null adds it there
               t.setLeft(new TreeNode(s,null,null));
               return t.getLeft();
            }
            else{
               return(add(t.getLeft(),s)); // otherwise calls recursive method
            
            }
         }
         else{ 
            if(t.getRight() == null){ // if goes right and the right is null
               t.setRight(new TreeNode(s,null,null));
               return t.getRight();
            }
            else 
               return(add(t.getRight(),s)); // otherwise calls recursive method
         }
      }
   
   }
   
   public String display()
   {
      return display(root,0); // calls the recursive method on root
   }
   private String display(TreeNode t, int level)
   {
   // turn your head towards left shoulder visualize tree
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   
   public boolean contains( String obj)
   {
      return contains(root,obj); // calls the recursive method contains
   }
   public boolean contains(TreeNode t, String x)
   {
      if(t == null) // if null returns false
         return false;
      if((t.getValue() + "").equals(x)) // if the node has it returns true
         return true;
      else 
         return (contains(t.getLeft(),x) || contains(t.getRight(),x)); // otherwise returns whether one side has it
   }
   
   public String min()
   {
      return min(root); //calls the recursive method
   }
   private String min(TreeNode t)  //use iteration
   {
      while(t.getLeft() != null) // goes to the left most node
         t = t.getLeft();
      return t.getValue() + ""; // returns null
   }
   
   public String max()
   {
      return max(root); // calls recursive method
   }
   private String max(TreeNode t)  //use recursion
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


   
   public void remove(String target)
   {
      root = remove(root, target);
      size--;
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
         
         
         
      //}
     
   }
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
   
   private boolean isLeaf(TreeNode t){
      return ((t.getLeft() == null) && (t.getRight() == null));
   }
}