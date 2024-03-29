// Name: 
// Date: 
import java.util.*;
import java.io.*;
public class PigLatin
{
   public static void main(String[] args) 
   {
      part_1_using_pig();
      //part_2_using_piglatenizeFile();
      
      /*  extension only    */
      // String str = pig("What!?");
      // System.out.print(str + "\t\t" + pigReverse(str));
      // str = pig("{(Hello!)}");
      // System.out.print("\n" + str + "\t\t" + pigReverse(str));
      // str = pig("\"McDonald???\"");
      // System.out.println("\n" + str + "  " + pigReverse(str));
   }

   public static void part_1_using_pig()
   {
      Scanner sc = new Scanner(System.in);
      while(true)
      {
         System.out.print("\nWhat word? ");
         String s = sc.next();
         if(s.equals("-1"))
         {
            System.out.println("Goodbye!"); 
            System.exit(0);
         }
         String p = pig(s);
         System.out.println( p );
      }		
   }

   public static final String punct = ",./;:'\"?<>[]{}|`~!@#$%^&*()";
   public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   public static final String vowels = "AEIOUaeiou";
   public static String pig(String s)
   {
      if(s.length() == 0)
         return "";
   
      //remove and store the beginning punctuation 
           
           
      //remove and store the ending punctuation 
         
         
      //START HERE with the basic case:
      //find the index of the first vowel
      //     y is a vowel if it is not the first letter
      //     qu
      
      
      //if no vowel has been found
      
      
      //is the first letter capitalized?
      
      
      //return the piglatinized word 
      
      
      
   }


   public static void part_2_using_piglatenizeFile() 
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("input filename including .txt: ");
      String fileNameIn = sc.next();
      System.out.print("output filename including .txt: ");
      String fileNameOut = sc.next();
      piglatenizeFile( fileNameIn, fileNameOut );
      System.out.println("Piglatin done!");
   }

/****************************** 
*  piglatinizes each word in each line of the input file
*    precondition:  both fileNames include .txt
*    postcondition:  output a piglatinized .txt file 
******************************/
   public static void piglatenizeFile(String fileNameIn, String fileNameOut) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(fileNameIn));  
      }
      catch(IOException e)
      {
         System.out.println("oops");
         System.exit(0);   
      }
   
      PrintWriter outfile = null;
      try
      {
         outfile = new PrintWriter(new FileWriter(fileNameOut));
      }
      catch(IOException e)
      {
         System.out.println("File not created");
         System.exit(0);
      }
   	//process each word in each line
      
      
      
   
      outfile.close();
      infile.close();
   }
   
   /** EXTENSION: Output each PigLatin word in reverse, preserving before-and-after 
       punctuation.  
   */
   public static String pigReverse(String s)
   {
      if(s.length() == 0)
         return "";
         
         
   }
}
