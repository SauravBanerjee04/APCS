// Name: S4-01
// Date: 2/6/2020

import java.util.*;

public class TreeLab
{
   public static TreeNode root = null;
   public static String s = "XCOMPUTERSCIENCE";
   //public static String s = "XThomasJeffersonHighSchool"; 
   //public static String s = "XAComputerScienceTreeHasItsRootAtTheTop";
   //public static String s = "XA";   //comment out lines 44-46 below
   //public static String s = "XAF";  //comment out lines 44-46 below
   //public static String s = "XAFP";  //comment out lines 44-46 below
   //public static String s = "XDFZM";  //comment out lines 44-46 below 
   
   public static void main(String[] args)
   {
      root = buildTree( root, s );
      System.out.print( display( root, 0) );
   
      System.out.print("\nPreorder: " + preorderTraverse(root));
      System.out.print("\nInorder: " + inorderTraverse(root));
      System.out.print("\nPostorder: " + postorderTraverse(root));
   
      System.out.println("\n\nNodes = " + countNodes(root));
      System.out.println("Leaves = " + countLeaves(root));
      System.out.println("Only children = " + countOnlys(root));
      System.out.println("Grandparents = " + countGrandParents(root));
   
      System.out.println("\nHeight of tree = " + height(root));
      System.out.println("Longest path = " + longestPath(root));
      System.out.println("Min = " + min(root));
      System.out.println("Max = " + max(root));	
   
      System.out.println("\nBy Level: ");
      System.out.println(displayLevelOrder(root));
   }
 
   public static TreeNode buildTree(TreeNode root, String s)
   {
      root = new TreeNode("" + s.charAt(1), null, null);
      for(int pos = 2; pos < s.length(); pos++)
         insert(root, "" + s.charAt(pos), pos, 
            (int)(1 + Math.log(pos) / Math.log(2)));
      insert(root, "A", 17, 5); 
      insert(root, "B", 18, 5); 
      insert(root, "C", 37, 6); //B's right child
      return root;
   }

   public static void insert(TreeNode t, String s, int pos, int level)
   {
      TreeNode p = t;
      for(int k = level - 2; k > 0; k--)
      {
         if((pos & (1 << k)) == 0)
            p = p.getLeft();
         else
            p = p.getRight();
      }
      if((pos & 1) == 0)
         p.setLeft(new TreeNode(s, null, null));
      else
         p.setRight(new TreeNode(s, null, null));
   }
   
   private static String display(TreeNode t, int level)
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
   
   public static String preorderTraverse(TreeNode t)
   { 
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      return toReturn;
   }
   
   public static String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += inorderTraverse(t.getLeft());   //recurse left
      toReturn += t.getValue() + " ";              //inorder visit
      toReturn += inorderTraverse(t.getRight());  //recurse right
      return toReturn;    
      
      //return null;
   }
   
   public static String postorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      toReturn += postorderTraverse(t.getLeft());   //recurse left
      toReturn += postorderTraverse(t.getRight());  //recurse right
      toReturn += t.getValue() + " ";              //inorder visit
      return toReturn;    
      
   
      //return null;
   }
   
   public static int countNodes(TreeNode t)
   {
      if(t == null) // if end returns o
         return 0;
      else 
         return(1 + countNodes(t.getLeft()) + countNodes(t.getRight())); // recursive call 
   //   return -1;
   }
   
   public static int countLeaves(TreeNode t)
   {
      if(t == null) // if null returns o 
         return 0;
      else{
         if((t.getLeft() == null) && (t.getRight() == null)) // if end returns 1
            return 1;
         else 
            return countLeaves(t.getLeft()) + countLeaves(t.getRight()); // recursive call if not end
      }
      //return -1;
   }
   
   /*  there are clever ways and hard ways to count grandparents  */ 
   public static int countGrandParents(TreeNode t)
   {
      if(t == null)
         return 0;
      if(height(t) < 2) // returns 0 if low enough
         return 0;
      else return 1 + countGrandParents(t.getLeft()) + countGrandParents(t.getRight()); // recursive call
   }
   
   public static int countOnlys(TreeNode t)
   {
      if ((t.getLeft() == null) && (t.getRight() == null)) // if both null return 0
         return 0;
      if((t.getLeft() != null) && (t.getRight() == null))  // goes left
         return 1 + countOnlys(t.getLeft());
      if((t.getLeft() == null) && (t.getRight() != null))  // goes right
         return 1 + countOnlys(t.getRight());
      else 
         return countOnlys(t.getLeft()) + countOnlys(t.getRight()); // both sides
      //return -1;
   }
   
  /* returns the max of the heights to the left and the heights to the right  
     returns -1 in case the tree is null
    */
   public static int height(TreeNode t)
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
   
 /* return the max of the sum of the heights to the left and the heights to the right  
 */
   public static int longestPath(TreeNode t)
   {
      return 2 + height(t.getLeft()) + height(t.getRight()); // returns longest path as a sum of 2 and left and right
      //return -1;
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
   @SuppressWarnings("unchecked")
   public static Object min(TreeNode t)
   {
      if((t.getLeft() == null) && (t.getRight() == null)){ // returns value if at end 
         return t.getValue();
      }
      else if((t.getLeft() == null) && (t.getRight() != null)){  // checks right
         if((t.getValue()+"").compareTo(t.getRight().getValue() + "") < 0)
            return t.getValue();
         else 
            return t.getRight().getValue();
      }
      else if((t.getLeft() != null) && (t.getRight() == null)){ // checks if has a leaf left
         if((t.getValue()+"").compareTo(t.getLeft().getValue() + "") < 0)
            return t.getValue();
         else 
            return t.getLeft().getValue();   
      }
      else{
         Object j = (Comparable)min(t.getRight()); // finals compares if not a leaf
         Object k = (Comparable)min(t.getLeft());
         Object e = (Comparable)t.getValue();
         Object compared;
         if(((Comparable)j).compareTo(k) < 0)
            compared = j;
         else compared = k;
         if(((Comparable)e).compareTo(compared) < 0)
            return e;
         else 
            return compared;
      }
   }
   
   /*  Object must be cast to Comparable in order to call .compareTo  
    */
   @SuppressWarnings("unchecked")
   public static Object max(TreeNode t)
   {
   if((t.getLeft() == null) && (t.getRight() == null)){ // if end returns value
         return t.getValue();
      }
      else if((t.getLeft() == null) && (t.getRight() != null)){ // if has only child
         if((t.getValue()+"").compareTo(t.getRight().getValue() + "") > 0)
            return t.getValue();
         else 
            return t.getRight().getValue();
      }
      else if((t.getLeft() != null) && (t.getRight() == null)){ // if has only child
         if((t.getValue()+"").compareTo(t.getLeft().getValue() + "") > 0)
            return t.getValue();
         else 
            return t.getLeft().getValue();   
      }
      else{ // otherwise checks against child nodes
         Object j = (Comparable)max(t.getRight());
         Object k = (Comparable)max(t.getLeft());
         Object e = (Comparable)t.getValue();
         Object compared;
         if(((Comparable)j).compareTo(k) > 0)
            compared = j;
         else compared = k;
         if(((Comparable)e).compareTo(compared) > 0)
            return e;
         else 
            return compared;
      }      
      //return null;
   }
      
   /* This method is not recursive.  Use a local queue
    * to store the children of the current TreeNode.
    */
   public static String displayLevelOrder(TreeNode t) // instead add one into the queue print it out, and then add it's children while you remove
   {
      String returned = "";
      Queue<TreeNode> temp = new LinkedList<TreeNode>(); // queue for sotring
      temp.add(t); // ads first
      while(!temp.isEmpty()){ // adds children then removes and prints
         if(temp.peek().getLeft() != null)
            temp.add(temp.peek().getLeft());
         if(temp.peek().getRight() != null)
            temp.add(temp.peek().getRight());
         returned += temp.remove().getValue();
      }
      return returned;
   }
}

/***************************************************
    ----jGRASP exec: java TreeLab
 		  	E
 		E
 			C
 	M
 			N
 		T
 			E
 C
 			I
 		U
 			C
 	O
 			S
 					C
 				B
 		P
 				A
 			R
 
 Preorder: C O P R A S B C U C I M T E N E C E 
 Inorder: R A P B C S O C U I C E T N M C E E 
 Postorder: A R C B S P C I U O E N T C E E M C 
 
 Nodes = 18
 Leaves = 8
 Only children = 3
 Grandparents = 5
 
 Height of tree = 5
 Longest path = 8
 Min = A
 Max = U
 
 By Level: 
 COMPUTERSCIENCEABC    
 *******************************************************/
