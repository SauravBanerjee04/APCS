// Name:  
// Date: 

public class Modes
{
    public static void main(String[] args)
    {
        int[] tally = {0,0,10,5,10,0,7,1,0,6,0,10,3,0,0,1};
        display(tally);
        int[] modes = calculateModes(tally);
        display(modes);
        int sum = 0;
        for(int k = 0; k < tally.length; k++)
            sum += tally[k];
        System.out.println("kth \tindex"); 
        for(int k = 1; k <= sum; k++)
            System.out.println(k + "\t\t" + kthDataValue(tally, k));
}
      
   /**
    * precondition: tally.length > 0
    * postcondition: returns an int array that contains the modes(s);
    *                the array's length equals the number of modes.
    */
    public static int[] calculateModes(int[] tally)
    {
        // Your code goes here.
        return new int[] {-1,-1,-1};
    }
      
   /**  
    * precondition:  tally.length > 0
    * 	             0 < k <= total number of values in data collection
    * postcondition: returns the kth value in the data collection
    *                represented by tally
    */
    public static int kthDataValue(int[] tally, int k)
    {
        // Your code goes here.
        return -1;
    }
      
   /**
    * precondition:  nums.length > 0
    * postcondition: returns the maximal value in nums
    */
    public static int findMax(int[] nums)
    {
        int pos = 0;
        for(int k = 1; k < nums.length; k++)
            if(nums[k] > nums[pos])
                pos = k;
            return nums[pos];
    }
    
    public static void display(int[] args)
    {
        for(int k = 0; k < args.length; k++)
            System.out.print(args[k] + " ");
        System.out.println();
        System.out.println();
    }
}
