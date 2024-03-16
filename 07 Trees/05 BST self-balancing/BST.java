// Name: S4-01
// Date: 2/25/19

interface BSTinterface
{
   public int size();
   public boolean contains(String obj);
   public void add(String obj);
   public void addBalanced(String obj);
   public void remove(String obj);
   public String min();
   public String max();
   public String display();
   public String toString();
}

/*******************
Copy your BST code.  Implement the addBalanced() method.
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
   private void add(TreeNode t, String s) 
   {      
      if(root == null){ // if its the first node adds it as the first one
         root = new TreeNode(s,null,null); 
         return;
      }
      if((t.getLeft() == null) && (t.getRight() == null)){ // if a leaf 
         if(s.compareTo(t.getValue() + "") <= 0){ // cchecks if should be added left
            t.setLeft(new TreeNode(s,null,null));
            return;
         }
         else{
            t.setRight(new TreeNode(s,null,null)); //checks if should be added right
            balanceTree(t);
            return;
         }
      }
      else{ // if not a leaf 
         if(s.compareTo(t.getValue() + "") <= 0){  // if should go to the left still
            if(t.getLeft() == null){ // if null adds it there
               t.setLeft(new TreeNode(s,null,null));
               balanceTree(t);
               return;
            }
            else{
               add(t.getLeft(),s); // otherwise calls recursive method
               balanceTree(t);
            
            }
         }
         else{ 
            if(t.getRight() == null){ // if goes right and the right is null
               t.setRight(new TreeNode(s,null,null));
               balanceTree(t);
               return;
            }
            else {
               add(t.getRight(),s); // otherwise calls recursive method
               balanceTree(t);
            }
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
   }
   public void addBalanced(String obj){
      if (root == null){
         root = new TreeNode(obj,null,null);
         size ++;
         return;
      }
      else{
         addBalanced(root,obj);
         size ++;
      }
   }
   public void addBalanced(TreeNode t, String obj){
      if(root == null){ // if its the first node addBalanceds it as the first one
         root = new TreeNode(obj,null,null); 
         return;
      }
      
      
      balanceTree(t);
      
      if((t.getLeft() == null) && (t.getRight() == null)){ // if a leaf 
         if(obj.compareTo(t.getValue() + "") <= 0){ // cchecks if should be addBalanceded left
            t.setLeft(new TreeNode(obj,null,null));
            balanceTree(t);
            return;
         }
         else{
            t.setRight(new TreeNode(obj,null,null)); //checks if should be addBalanceded right
            balanceTree(t); // balances tree
            return;
         }
      }
      else{ // if not a leaf 
         if(obj.compareTo(t.getValue() + "") <= 0){  // if should go to the left still
            if(t.getLeft() == null){ // if null addBalanceds it there
               t.setLeft(new TreeNode(obj,null,null));
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
               t.setRight(new TreeNode(obj,null,null));
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
   public void balanceTree(TreeNode t){
      int balance = bal(t); // checks both sides
      if(balance > 1){  // if right is too heavy then shifts
         if(bal(t.getRight()) < -1){
            TreeNode f = doubleLeft(t); 
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
            
         }
         else{
            TreeNode f = leftRotate(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
            balanceTree(t.getLeft());
            balanceTree(t.getRight());
         }
      }
      else if(balance < -1){  // if left tree is heavy then shifts
         if(bal(t.getLeft()) > 1){
            TreeNode f = doubleRight(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
            balanceTree(t.getLeft());
            balanceTree(t.getRight());
         }
         else{
            TreeNode f = rightRotate(t);
            t.setValue(f.getValue());
            t.setLeft(f.getLeft());
            t.setRight(f.getRight());
         }
      }
   }
   private int bal(TreeNode t){
      int left = height(t.getLeft());  // finds balance by using height of right - height of left
      int right = height(t.getRight());
      int balance = right - left;
      return balance;
   }
   private TreeNode leftRotate(TreeNode a){  // roates tree to the left
      TreeNode b = a.getRight();
      TreeNode copyA = new TreeNode(a.getValue(),a.getLeft(),b.getLeft());
      b.setLeft(copyA);//
      return b;
      
   }
      
   private TreeNode rightRotate(TreeNode c){  // rotates tree to the right
      TreeNode b = c.getLeft();
      TreeNode copyC = new TreeNode(c.getValue(),b.getRight(),c.getLeft());
      b.setRight(copyC);
      return b;
   }
   private TreeNode doubleLeft(TreeNode a){  // double left
      a.setRight(rightRotate(a.getRight()));
      a = leftRotate(a);
      return new TreeNode(a.getValue(),a.getLeft(),a.getRight());
   }
   private TreeNode doubleRight(TreeNode a){  // double right rotation from avl document
      a.setLeft(leftRotate(a.getLeft()));
      a = rightRotate(a);
      return new TreeNode(a.getValue(),a.getLeft(),a.getRight());
   }
      
      
      
   private int height(TreeNode t)
   {
      if(t == null) 
         return -1;
      else if((t.getLeft() == null) && (t.getRight() != null)){ // returns right side + 1 if one child
         return 1 + height(t.getRight());  
      }
      else if((t.getLeft() != null) && (t.getRight() == null)){ // if one child
         return 1 + height(t.getLeft());   
      }
      else
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
   
   private boolean isLeaf(TreeNode t){
      return ((t.getLeft() == null) && (t.getRight() == null));
   }



   

}