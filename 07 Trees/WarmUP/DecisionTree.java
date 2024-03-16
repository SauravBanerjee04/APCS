import java.io.*;
import java.util.*;
public class DecisionTree{
   private TreeNode <Rule> root;
   public DecisionTree(File f) throws Exception{
   // fill a list with tre nodes and rules
   // make a list with all the left children
   // rule, treshold, left child, right child
      ArrayList<TreeNode<Rule>> l1 = new ArrayList<TreeNode<Rule>>();
      List<Integer> l2 = new ArrayList<Integer>();
      List<Integer> l3 = new ArrayList<Integer>();
      Scanner sc = new Scanner(f);
      while(sc.hasNextLine()){
         String[] line = sc.nextLine().split(",");
      
         l1.add(new TreeNode(new Rule(Double.parseDoubleline(line[1])) ) );
         if(line[2].equals("null"))
            l2.add(null);
         else l2.add(new Integer(Integer.parseInt(line[2])));
      
         if(line[3].equals("null"))
            l3.add(null);
         else l3.add(new Integer(Integer.parseInt(line[3])));
      
      
      //setLeft and setRight
         for(int i = 0; i < l1.size(); i++){
            TreeNode t = l1.get(i); // the parent
         
            ThreeNode L = null; // Children
            TreeNode R = null;
            if(l2.get(i) != null){
               int l_index = l2.get(i).intValue();
               L = l1.get(l_index);
            }
            t.setLeft(L);
            if(l3.get(i) != null){
               int l_index = l3.get(i).intValue();
               R = l1.get(l_index);
            }
            t.setLeft(R);
            
         }
         root = l1.get(0);
      }
   
   }
}