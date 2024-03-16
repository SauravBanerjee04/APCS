// Name:
// Date:

import java.io.*;
import java.util.*;

public class SongQueue
{
   private static Scanner keyboard;  //use this global Scanner for this lab only
   private static Queue<String> songQueue;
   
   public static void main(String[] args) throws Exception
   {
      keyboard = new Scanner(System.in);
      songQueue = readPlayList();
     // System.out.println(songQueue);  //not allowed
      System.out.println("Your music queue: " + queueAsString()); 
      
      String prompt = "Add song (A), Play song (P), Delete song (D), Quit (Q):  ";
      String str = "";
      do{      
         System.out.print(prompt);
         str = keyboard.nextLine().toUpperCase();
         processRequest( str );
         System.out.println();
      }while(!str.equals("Q"));
   }
   
   /* reads the file "songs.txt".  Extracts the song's title
      and stores it in a queue.
      @return the queue of songs
      */
   public static Queue<String> readPlayList() throws IOException
   {
      Scanner infile = new Scanner (new File("songs.txt"));  
       
   }
   
   /* processes the character codes A, P, D, Q, a, p, d, q.
      "A" prompts the user to enter the name of the song, 
      adds it to the queue, and displays the whole queue
      after "Your music queue:  " . Do not add the same song twice.

      "P" plays the song, if one exists, by displaying 
      "Now playing: " and its title and then removing it from the queue.
      If there is nothing play, the program displays "Empty queue!"

      "D" displays the queue, prompts the user by showing 
      "Delete which song (exact match)?" and will either delete the 
      song and display the queue or show "Error:  Song not in list."   

      "Q" displays "No more music for you today.  Goodbye!" 
      and ends the program.

      @param str - the character code
      */

   public static void processRequest(String str)
   {
   
   }
   
   /* returns the songs in the queue, separated by commas.
   */
   public static String queueAsString()
   {
            
   }
   
  /*  standard accessor method.
      */
   public static Queue<String> getQueue()
   {
      return songQueue;
   }
}

/*********************************************

 Your music queue: Really Love, Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Really Love
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow 
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  x
 Invalid.  Try again.
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  d
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow 
 Delete which song (exact match)?  xxx
 Error:  Song not in list.
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow 
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  d
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow 
 Delete which song (exact match)?  Alright
 Your music queue: Uptown Funk, Thinking Out Loud, Traveller, Shallow 
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  q
 
 No more music for you today.  Goodbye!
 
**********************************************/