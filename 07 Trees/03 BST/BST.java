//Name: S4-01
//Date: 2/11/20

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   //public void addBalanced(String obj);
   //public boolean remove(String obj);
   public String min();
   public String max();
   public String toString();
}

/*******************
Represents a binary search tree holding Strings. 
Implements (most of) BSTinterface, above. 
The recursive methods all have a public method calling a private helper method. 
Copy the display() method from TreeLab. 
**********************/
class BST implements BSTinterface
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
}
