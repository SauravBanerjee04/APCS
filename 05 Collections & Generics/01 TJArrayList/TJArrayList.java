// Name: S4-01
// Date: 12/4/19

/**
 * Implements the cheat sheet's List interface.  Implements generics.
 * The backing array is an array of (E[]) new Object[10];
 * @override toString()
 */ 
public class TJArrayList<E>
{
   private int size;							//stores the number of objects
   private E[] myArray;
   public TJArrayList()                //default constructor makes 10 cells
   {
      myArray = (E[]) new Object[10];
      size = 0;
   }
   public int size()
   {
    if(myArray == null) // returns 0 if null
      return 0;
    else{
    int a = 0; // variable for length
    while((a < myArray.length) && (myArray[a] != null)){ // goes through till null
    a++;
    }
    return a; // returns length
    }
        
   }
 	/* appends obj to end of list; increases size;
      must be an O(1) operation when size < array.length, 
         and O(n) when it doubles the length of the array.
	  @return true  */
   public boolean add(E obj)
   {
   if(size < myArray.length){
   myArray[size] = obj; // adds object into array
   size = size(); // increments size
   return true; // treturns
   }
   else{
   E[] temp = myArray; // copies myArray
   myArray = (E[]) new Object[myArray.length * 2]; // doubles length 
   for(int a = 0; a < temp.length; a++) // copies values
      myArray[a] = temp[a];
   size = size();
   myArray[size] = obj; // adds in the new object
   size = size(); // increments size
   return true;
   }
      
   
   }
   /* inserts obj at position index.  increments size. 
		*/
   public void add(int index, E obj) throws IndexOutOfBoundsException  //this the way the real ArrayList is coded
   {
      if(index > size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      if(size == index){ // if at end just adds object
      add(obj);
      return;
      }
      int b = myArray.length; //takes length
      if((size + 1) == myArray.length){ // if next one is end doubles the size
      b = b*2;
      }
      E[] temp = (E[]) new Object[b]; // temp that  will be myArray
      for(int a = 0; a<index; a++){ // stores values
         temp[a] = myArray[a];
      }
      temp[index] = obj; // adds in temp
      for(int a = index; a < size; a ++){
         temp[a+1] = myArray[a]; // adds in values after temp
      }
      myArray =temp; // makes new temp myArray
      size = size(); // increments size
   
   }

   /* return obj at position index.  
		*/
   public E get(int index) throws IndexOutOfBoundsException
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
     return myArray[index]; // returns myArray's value at the index
   
   }
   /**
    * Replaces obj at position index. 
    * @return the object is being replaced.
    */  
   public E set(int index, E obj) throws IndexOutOfBoundsException  
   { 
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      E f = myArray[index]; // takes original object
      myArray[index] = obj; // changes value
      return f; // returns new object
      
   }
 /*  removes the node from position index. shifts elements 
     to the left.   Decrements size.
	  @return the object at position index.
	 */
   public E remove(int index) throws IndexOutOfBoundsException  
   {
      if(index >= size || index < 0)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
     E f = myArray[index]; // takes the value
     myArray[index] = null; // nullifies the value
     for(int a = index; a < (size - 1); a++){
         myArray[a] = myArray[a + 1]; // shifts them over
     }
     myArray[size -1] = null; // fixes the last one
     size = size(); // increments size
     return f; // returns original value
   }
	   /*
		   This method compares objects.
         Must use .equals(), not ==
     	*/
   public boolean contains(E obj)
   {
   for(int a = 0;a < size; a ++){ // goes through and checks if there
      if(myArray[a].equals(obj))
         return true;
   }
   return false; // if not there then returns false
   
   }
	 /*returns a String of E objects in the array with 
       square brackets and commas.
     	*/
   public String toString()
   {
   String s = "["; // new string to be returned
   for(int a = 0; a < size - 1; a ++){ // adds elements
      s += (myArray[a] + ", ");
   }
   s += (myArray[size - 1]); //adds last element
   s += "]"; // closing the thing
   return s; // returns the new string
   }
}