/**
   classwork -- Day 10 | 0b1010 | 0x10
   class: Boogle
   A tester class for code analysis and search exploration.
   USAGE:
   Read through at least once.
   Compile, run.
   Comment/uncomment lines, recompile, run to explore functionality.
   "Lather, rinse, repeat" until comprehension achieved.
   Rename methods to indicate purpose.
   Insert comment preceding each method to summarize functionality.
   T. Mykolyk, F. Dragon
   June 2020
**/

import java.io.*;
import java.util.*;

public class Boogle
{

  //return index of first occurence of target, or -1 if not found
  public static int linSearch( ArrayList al, int target )
  {
    for( int pos=0; pos<al.size(); pos++) {
      if (al.get(pos).equals(target))
        return pos;
    }
    return -1;
  }//end linSearch()
  
  // It checks for repeated elements before inx
  private static int getFirst(ArrayList al, int inx) {
	  for (int i=inx; i>0; i--) {
		  if (al.get(inx).equals(al.get(inx-1))) 
			  inx--;
		  else 
			  return inx;
	  }
	  return inx;
  }
  
  // public static int findSmallest(ArrayList<Integer> al, int lo, int hi) {
	// int min = al.get(lo);
	// int inx = lo;
	// for (i=lo; i<=hi; i++) {
		// if ( al.get(i) < min ) {
			// min = al.get(i);
			// inx = i;
		// }	
	// }
	// if (lo > hi)
		// return -1;
	// return inx;
  // }

  //return index of target, or -1 if not found
  public static int binSearch( ArrayList al, int target, int start, int end )
  {
	// if the number is repeated, it does not nec. find the first one!!!!
	int size = end-start;
	if ((size <= 0 )|| (end >= al.size()))
		return -1;
	if (size<=1) {
		if(al.get(start).equals(target))
			return start;
		if ((size==1) && (al.get(end).equals(target)))
			return end;
		return -1;
	}
	// ArrayList contains integers!!!!!
    int inx = (int)((end-start)/2) + start;
	Integer val = (Integer) al.get(inx);
	if (val == target)
		// return inx;
		return getFirst(al,inx);
	else if (val > target)
		return binSearch(al,target,start,inx);
	else 
		return binSearch(al,target,inx,end);
  }//end binSearch()
  
  //return index of target, or -1 if not found
  public static int binSearch( ArrayList al, int target )
  {
	  // return binSearch(al, target, 0, al.size()-1);
	  // this is really the recursive method inside a while loop
		int start = 0;
		int end = al.size()-1;
		int inx = 0;
		while (end < al.size()) {
			int size = end-start;
			if (size <= 0 )
				return -1;
			if (size<=1) {
				if(al.get(start).equals(target))
					return start;
				if ((size==1) && (al.get(end).equals(target)))
					return end;
				return -1;
			}
			inx = (int)((end-start)/2) + start;
			Integer val = (Integer) al.get(inx);
			if (val == target)
				// return inx;
				return getFirst(al,inx);
			else if (val > target)
				end = inx;
			else 
				start = inx;
		}
		return -1;		
  }//end binSearch()

  // subgoal: recognize target found (and take what action?)
  // subgoal: recognize search space exhausted (and take what action?)
  // subgoal: recognize target in lower portion of range (and do what?)
  // subgoal: recognize target in upper portion of range (and do what?)

  //nota bene: A helper method could be very useful.
  // Q: Why?
  // Q: What would the parameters be for such a method?

  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    for(int i=0; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    }
    return retArr;
  }//end prestoArrayListo()


  //return ArrayList of random ints, sorted in ascending order
  public static ArrayList prestoSortedArrayListo(int numItems,
                                                 int lo, int hi)
  {
    ArrayList retArr = new ArrayList();

    //if requested, return empty ArrayList
    if ( numItems<1 )
      return retArr;

    //populate index 0
    retArr.add( (int)(lo * Math.random()) );

    //populate rest of indices, each one greater than last
    for(int i=1; i<numItems; i++) {
      //System.out.println(i);  //diagnostic under-the-hood view
      //retArr.add( Math.random() ); // [0,1)
      //retArr.add( (int)Math.random() ); // 0
      //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
      //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
      //System.out.println(retArr.get(i-1));
      retArr.add( (int)retArr.get(i-1)
                  + lo + (int)(hi * Math.random()) ); // ["left neighbour",hi)
    }

    return retArr;
  }//end prestoSortedArrayListo()


  public static void main( String[] args )
  {
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"al000"+":");
    ArrayList al000 = prestoArrayListo(0,0,0);
    System.out.println(al000);
    System.out.println(linSearch(al000,3));
    System.out.println("\n"+"al01"+":");
    ArrayList al01 = prestoArrayListo(5,0,100);
    System.out.println(al01);
    System.out.println(linSearch(al01,3));
    System.out.println("\n"+"al02"+":");
    ArrayList al02 = prestoArrayListo(5,3,10);
    System.out.println(al02);
    System.out.println(linSearch(al02,3));
    System.out.println("\n"+"al05"+":");
    ArrayList al05 = prestoArrayListo(20,1,5);
    System.out.println(al05);
    System.out.println(linSearch(al05,3));
      ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/


    // test battery using sorted ArrayLists as search space
    /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
    System.out.println("\n"+"sal000"+":");
    ArrayList sal000 = prestoSortedArrayListo(0,0,0);
    System.out.println(sal000);
    System.out.println(linSearch(sal000,3));
    System.out.println(binSearch(sal000,3));
    System.out.println("\n"+"sal00"+":");
    ArrayList sal00 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal00);
    System.out.println(linSearch(sal00,3));
    System.out.println(binSearch(sal00,3));
    System.out.println("\n"+"sal01"+":");
    ArrayList sal01 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal01);
    System.out.println(linSearch(sal01,3));
    System.out.println(binSearch(sal01,3));
    System.out.println("\n"+"sal02"+":");
    ArrayList sal02 = prestoSortedArrayListo(5,3,100);
    System.out.println(sal02);
    System.out.println(linSearch(sal02,3));
    System.out.println(binSearch(sal02,3));
    System.out.println("\n"+"sal03"+":");
    ArrayList sal03 = prestoSortedArrayListo(5,0,100);
    System.out.println(sal03);
    System.out.println(linSearch(sal03,3));
    System.out.println(binSearch(sal03,3));
    System.out.println("\n"+"sal04"+":");
    ArrayList sal04 = prestoSortedArrayListo(20,0,3);
    System.out.println(sal04);
    System.out.println(linSearch(sal04,3));
    System.out.println(binSearch(sal04,3));
    System.out.println("\n"+"sal05"+":");
    ArrayList sal05 = prestoSortedArrayListo(20,1,5);
    System.out.println(sal05);
    System.out.println(linSearch(sal05,3));
    System.out.println(binSearch(sal05,3));
    // ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

    //batch of commands for easier test case generation:
    /*
    System.out.println("\n"+"al"+":");
    ArrayList al = new ArrayList();
	al.add(1);
	al.add(2);
	al.add(3);
	al.add(4);
	al.add(5);
    System.out.println(al);

	System.out.println("********** 1 ***********");
	System.out.println(linSearch(al,1));
    System.out.println(binSearch(al,1));

	System.out.println("********** 2 ***********");
	System.out.println(linSearch(al,2));
    System.out.println(binSearch(al,2));
	
	System.out.println("********** 3 ***********");
    System.out.println(linSearch(al,3));
    System.out.println(binSearch(al,3));
	System.out.println("********** 4 ***********");
    System.out.println(linSearch(al,4));
    System.out.println(binSearch(al,4));
	System.out.println("********** 5 ***********");
    System.out.println(linSearch(al,5));
    System.out.println(binSearch(al,5));
	System.out.println("********** 15 ***********");
    System.out.println(linSearch(al,15));
    System.out.println(binSearch(al,15));
    //*/
	
	/**
       ~~~ The RSPB Special Trace-athon ~~~
       YOUR MISSION:
       Form a Dynamic Duo of Destiny or a Trio of Triump. Conjure team name portending greatness (TNPG).
       Copypasta this into main method of your java sourcecode file containing methods linSearch and binSearch
         (Boogle.java for almost all of you)
       Verify it works. 
          (If any test calls do not yield expected outputs, there is some tuning to be done... 
           Probably best to just grab a working version for now.)
       On KtS, with at least 1 tracing buddy, trace out each binSearch() call.
       NOTA BENE: The second batch of test calls are identical to the first, 
                  except that the search space has grown by 1 element...
     **/
    
    ArrayList salamander = new ArrayList();

    //explicitly fill arraylist with intent to search for
    // present and nonpresent values...
    // generate an arraylist with an odd num of elems...
    salamander.add(4);
    salamander.add(8);
    salamander.add(15);
    salamander.add(16);
    salamander.add(23);
    System.out.println(salamander);

    //search for target in the list
    System.out.println(binSearch(salamander, 8));  // 1
    System.out.println(binSearch(salamander, 15)); // 2
    System.out.println(binSearch(salamander, 16)); // 3

    //search for target not in the list
    System.out.println(binSearch(salamander, 3)); // -1
    System.out.println(binSearch(salamander, 9)); // -1

    //add another element, for an even num of elems
    salamander.add(42);
    System.out.println(salamander);
    //search for target in the list
    System.out.println(binSearch(salamander, 8));  // 1
    System.out.println(binSearch(salamander, 15)); // 2
    System.out.println(binSearch(salamander, 16)); // 3

    //search for target not in the list
    System.out.println(binSearch(salamander, 3)); // -1
    System.out.println(binSearch(salamander, 9)); // -1
  }//end main

}//end class