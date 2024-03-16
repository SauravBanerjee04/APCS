// Name: S4-01
// Date: 3/10/20

import java.io.*;
import java.util.*;

public class Dictionary
{
   public static void main(String[] args) 
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File("spanglish.txt"));
         System.setOut(new PrintStream(new FileOutputStream("dictionaryOutput.txt")));
      }
      catch(Exception e)
      {
      }
      
      Map<String, Set<String>> eng2spn = makeDictionary( infile );
      System.out.println("ENGLISH TO SPANISH");
      display(eng2spn);
   
      Map<String, Set<String>> spn2eng = reverse(eng2spn);
      System.out.println("SPANISH TO ENGLISH");
      display(spn2eng);
   }
   
   public static Map<String, Set<String>> makeDictionary(Scanner infile)
   {
      Map<String, Set<String>> t = new TreeMap<String, Set<String>>(); 
      while(infile.hasNextLine()){ // goes through
         String s1 = infile.nextLine();  // reads the word and definition
         String s2 = infile.nextLine();
         if(t.get(s1) == null){ // if not there adds with the definition
            TreeSet<String> e = new TreeSet<String>();
            e.add(s2);
            t.put(s1,e);
         }
         else{
            Set<String> e = t.get(s1); // otherside takes the sets and adds to it
            e.add(s2);
         }
      }
      return t;
   }
   
   public static void add(Map<String, Set<String>> dictionary, String word, String translation)
   { 
      //while(infile.hasNextLine()){
      String s1 = word; 
      String s2 = translation;
      if(dictionary.get(s1) == null){ // if word isn't defined makes a new tree set and adds
         TreeSet<String> e = new TreeSet<String>(); 
         e.add(s2);
         dictionary.put(s1,e);
      }
      else{
         Set<String> e = dictionary.get(s1); // otherwise adds it regularly
         e.add(s2);
      }
      //}
   }
   
   public static void display(Map<String, Set<String>> m)
   {
      for(String a : m.keySet()){ // goes through keyset
         Set<String> l = m.get(a);
         String s = "[";
         for(String e : l){ // adds in values
            s += (e + ", ");
         }
         s = s.substring(0,s.length()-2); // takes out commas on final one
         s+= "]";
         System.out.println("\t"+a + " " + s); // prints the final thing for the line
      }
      System.out.println(); // new line
   }
   
   public static Map<String, Set<String>> reverse(Map<String, Set<String>> dictionary)
   {
      Map<String, Set<String>> t = new TreeMap<String, Set<String>>(); // new map
      for(String s : dictionary.keySet()){ // goes through dictionary keyset
         Set<String> l = dictionary.get(s);
         for(String f: l){ // goes through the definitions
         if(t.get(f) == null){ // if spanish not entered already adds the english as a new
            Set<String> e = new TreeSet<String>();
            e.add(s);
            t.put(f,e);
         }
         else{
            Set<String> e = t.get(f);
            e.add(s);
         }
         }        
         // String s2 = s;
      //          Set<String> l = dictionary.get(s2);
      //          for(String s1: l){
      //             if(t.get(s1) == null){
      //                TreeSet<String> e = new TreeSet<String>();
      //                e.add(s2);
      //                t.put(s1,e);
      //             }
      //             else{
      //                Set<String> e = dictionary.get(s1);
      //                e.add(s2);
      //             }
      }
      return t; // returns the new thing
   }
}




   /********************
	INPUT:
   	holiday
		fiesta
		holiday
		vacaciones
		party
		fiesta
		celebration
		fiesta
     <etc.>
  *********************************** 
	OUTPUT:
		ENGLISH TO SPANISH
			banana [banana]
			celebration [fiesta]
			computer [computadora, ordenador]
			double [doblar, doble, duplicar]
			father [padre]
			feast [fiesta]
			good [bueno]
			hand [mano]
			hello [hola]
			holiday [fiesta, vacaciones]
			party [fiesta]
			plaza [plaza]
			priest [padre]
			program [programa, programar]
			sleep [dormir]
			son [hijo]
			sun [sol]
			vacation [vacaciones]

		SPANISH TO ENGLISH
			banana [banana]
			bueno [good]
			computadora [computer]
			doblar [double]
			doble [double]
			dormir [sleep]
			duplicar [double]
			fiesta [celebration, feast, holiday, party]
			hijo [son]
			hola [hello]
			mano [hand]
			ordenador [computer]
			padre [father, priest]
			plaza [plaza]
			programa [program]
			programar [program]
			sol [sun]
			vacaciones [holiday, vacation]

**********************/