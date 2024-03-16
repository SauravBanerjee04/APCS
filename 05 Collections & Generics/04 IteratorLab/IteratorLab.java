 // Name:      S4-01
 // Date:      12/10/19
 // use for-each loops or iterators, not regular for-loops
import java.io.*;
import java.util.*;
public class IteratorLab
{
   public static void main(String[] args)
   {
      System.out.println("Iterator Lab\n");
      int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
      for(int n : rawNumbers )
         System.out.print(n + " ");    
      ArrayList<Integer> numbers = createNumbers(rawNumbers);
      System.out.println("\nArrayList: "+ numbers);      //Implicit Iterator!
      System.out.println("Count negative numbers: " + countNeg(numbers));
      System.out.println("Average: " + average(numbers));
      System.out.println("Replace negative numbers: " + replaceNeg(numbers));
      System.out.println("Delete zeros: " + deleteZero(numbers));
      String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins", 
               "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
      ArrayList<String> movies = createMovies(rawMovies);
      System.out.println("Movies: " + movies);
      System.out.println("Movies: " +  removeDupes(movies));
   }
      // pre: an array of just int values 
   	// post: return an ArrayList containing all the values
   public static ArrayList<Integer> createNumbers(int[] rawNumbers) 
   {
      ArrayList<Integer> c = new ArrayList<Integer>(); // goes through and adds them into the new ArrayList
      for(int a: rawNumbers){
         c.add(a);
      }
      return c;
      
   }
      // pre: an array of just Strings  
   	// post: return an ArrayList containing all the Strings
   public static ArrayList<String> createMovies(String[] rawWords) 
   {
      ArrayList<String> myList = new ArrayList<String>(); // new array list for movies
      for ( String str : rawWords ) // adds words
         myList.add( str ); 
      return myList;
   }
   
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the number of negative values in the ArrayList a
   public static int countNeg(ArrayList<Integer> a)
   {
      int d = 0; // number of negs
      for(int c : a){
         if(c < 0){ // if neg adds 1
            d++;   
         }
      }   
      return d; // returns
   }
   	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: return the average of all values in the ArrayList a
   public static double average(ArrayList<Integer> a)
   {
      int d = 0; // total amount
      for(int c : a){ // calculates sum
         d += c;
      }   
      return d/(1.00 * a.size()); // returns average
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: replaces all negative values with 0 
   public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
   {
      ListIterator<Integer> j = a.listIterator(); // new iterator going through array
      while(j.hasNext()){ // goes through removes negs and replaces them w 0s
         if(j.next() < 0){
            j.remove();
            j.add(0);
         }
      
      }
      return a;
   }
     	// pre: ArrayList a is not empty and contains only Integer objects
   	// post: deletes all zeros in the ArrayList a
   public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
   {
      ListIterator<Integer> j = a.listIterator(); // makes a iterator
      while(j.hasNext()){ // goes through and removes 0s
         if(j.next() == 0){
            j.remove();
         }
      
      }
      return a;
   }
      // pre: ArrayList a is not empty and contains only String objects
   	// post: return ArrayList without duplicate movie titles
		// strategy: start with an empty array and add movies as needed
   public static ArrayList<String> removeDupes(ArrayList<String> a)
   {
      ArrayList<String> l = new ArrayList<String>(); // makes a new arraylist
      for(String e : a){ // if the string isn't in the new list already it gets added
         if(!(l.contains(e)))
         l.add(e);
      }
      return l;
   }
   
}

