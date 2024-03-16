// Name: S4-01
// Date: 2/9/20

/*  Represents a binary expression tree.
 *  The BXT builds itself from postorder expressions. It can
 *  evaluate and print itself.  Also prints inorder and postorder strings. 
 */
import java.util.*;
class BXT
{
   private TreeNode root;   
   //String operators = "+-/*";
   public BXT()
   {
      root = null;
   }
   public TreeNode getRoot()   //for Grade-It
   {
      return root;
   }
    
   public void buildTree(String str)
   {
      String[] arr = str.split(" ");
      Stack<TreeNode> stack = new Stack<TreeNode>();
      if(arr.length == 1){
      root = new TreeNode(str,null,null);
      return;
      }
      for(String s: arr){
         if(isOperator(s)){ // if an operator makes the operation of the last two in the stack 
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            root = new TreeNode(s,left,right); // set root as the new one
            stack.push(root); // pushes root
            // else{// method is wrong here but i'll fix later
         //                
         //                TreeNode temp = new TreeNode(root.getValue(),root.getLeft(),root.getRight());
         //                root = new TreeNode(s,new TreeNode(stack.pop()),temp);
         //                
         //             }
         }
         else 
            stack.push(new TreeNode(s)); //otherwise pushes number
      }
   }
   
   public double evaluateTree()
   {
      return evaluateNode(root);
   }
   
   private double evaluateNode(TreeNode t)  //recursive
   {
   // first if t is operator
      if((t.getLeft() == null) && (t.getRight() == null)) // if number returns 
         return Double.parseDouble(""+t.getValue());
      else return computeTerm(t.getValue() + "", evaluateNode(t.getLeft()), evaluateNode(t.getRight())); // otherwise computes
   }
   
   private double computeTerm(String s, double a, double b)
   {
      double d = 0; // variable that will be returned
      switch(s){ // switch to do operation
         case ("+"):
            d = (a+b);
            break;
         case ("-"):
            d = (a-b);;
            break;
         case ("*"):
            d =(a*b);
            break;
         case ("/"):
            d=(a/b);
            break;
      } 
      return d;
   }
   
   private boolean isOperator(String s)
   {
      if((s.equals("+")) || (s.equals("-")) || (s.equals("*")) || (s.equals("/"))) // if operator returns true
         return true;
      else 
         return false;
   }
   
   public String display()
   {
      return display(root, 0);
   }
   
   private String display(TreeNode t, int level)
   {
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
    
   public String inorderTraverse()
   {
      return inorderTraverse(root);
   }
   
   private  String inorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null){
         return "";
      }
      else{
      toReturn += inorderTraverse(t.getLeft());   //recurse left
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += inorderTraverse(t.getRight());
      }  //recurse right
      return toReturn;
    
   }
   
   public String preorderTraverse()
   {
      return preorderTraverse(root);
   }
   
   private String preorderTraverse(TreeNode t)
   {
      String toReturn = "";
      if(t == null)
         return "";
      else{
      toReturn += t.getValue() + " ";              //preorder visit
      toReturn += preorderTraverse(t.getLeft());   //recurse left
      toReturn += preorderTraverse(t.getRight());  //recurse right
      }
      return toReturn;
   }
   
  /* extension */
   // public String inorderTraverseWithParentheses()
   // {
      // return inorderTraverseWithParentheses(root);
   // }
//    
   // private String inorderTraverseWithParentheses(TreeNode t)
   // {
      // return "";
   // }
}