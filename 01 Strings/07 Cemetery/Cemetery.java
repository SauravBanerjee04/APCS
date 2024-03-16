// Name:
// Date:
import java.util.Scanner;
import java.io.File;
import java.text.DecimalFormat;
//here any additional imports that you may need

public class Cemetery
{
   public static void main (String [] args)
   {
      File file = new File("cemetery.txt");
      int numEntries = countEntries(file);
      Person[] cemetery = readIntoArray(file, numEntries); 
      int min = locateMinAgePerson(cemetery);
      int max = locateMaxAgePerson(cemetery); 
      //for testing only
      for (int i = 0; i < cemetery.length; i++) 
         System.out.println(cemetery[i]);
      System.out.println("In the St. Mary Magdelene Old Fish Cemetery --> ");
      System.out.println("Name of youngest person: " + cemetery[min].getName());
      System.out.println("Age of youngest person: " + cemetery[min].getAge());    
      System.out.println("Name of oldest person: " + cemetery[max].getName());
      System.out.println("Age of oldest person: " + cemetery[max].getAge()); 
      //you may create other testing cases here
      //comment them out when you submt your file to gradeit    
   }
   
   /* Counts and returns the number of entries in File f. 
      Returns 0 if the File f is not valid.
      Uses a try-catch block.   
      @param f -- the file object
   */
   public static int countEntries(File f)
   {
   
   }

   /* Reads the data from file f (you may assume each line has same allignment).
      Fills the array with Person objects. If File f is not valid return an empty array.
      Uses a try-catch block.   
      @param f -- the file object 
      @param num -- the number of lines in the File f  
   */
   public static Person[] readIntoArray (File f, int num)
   {
   
   }
   
   /* A helper method that instantiates one Person object.
      @param entry -- one line of the input file.
      This method is made public for gradeit testing purposes.
      This method should not be used in any other class!!!
   */
   public static Person makeObjects(String entry)
   {
   
   }  
   
   /* Finds and returns the location (the index) of the Person
      who is the youngest. (if the array is empty it returns -1)
      If there is a tie the lowest index is returned.
      @param arr -- an array of Person objects.
   */
   public static int locateMinAgePerson(Person[] arr)
   {
   
   }   
   
   /* Finds and returns the location (the index) of the Person
      who is the oldest. (if the array is empty it returns -1)
      If there is a tie the lowest index is returned.
      @param arr -- an array of Person objects.
   */
   public static int locateMaxAgePerson(Person[] arr)
   {
   
   }        
} 

class Person
{
   //constant that can be used for formatting purpose
   private static final DecimalFormat df = new DecimalFormat("0.0000");
   /* private fields */
   
      
   /* a three-arg constructor  
    @param name, birthdate may have leading or trailing spaces
    It creates a valid Person object in which each field has the leading and trailing
    spaces eliminated*/
   Person(String name, String birthdate, double age)
   {
   
   }
   /* any necessary accessor methods (at least "double getAge()" and "String getName()" )
   make sure your get and/or set methods use the same datat type as the field  */
   
   
   /*handles the inconsistencies regarding age
     @param a = a string containing an age from file. Ex: "12", "12w", "12d"
     returns the age transformed into year with 4 decimals rounding
   */
   public double calculateAge(String a)
   {
   
   }
}