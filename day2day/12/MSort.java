/**
**/

import java.io.*;
import java.util.*;

public class MSort
{
  //return ArrayList of random ints on range [lo,lo+hi)
  public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi)
  {
    ArrayList<Integer> retArr = new ArrayList<Integer>();

    for(int i=0; i<numItems; i++) {
      retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
    }
    return retArr;
  }//end prestoArrayListo()

  // find and return the index of the smallest value in the
  // ArrayList al from index lo to index hi inclusive
  public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
    int maxIndexSoFar = lo;
    for (int i = lo; i <=hi; i++) {
      if (al.get(i) < al.get(maxIndexSoFar)){
        maxIndexSoFar = i;
      }
    }
    return maxIndexSoFar;
  }

  public static void selectionSort(ArrayList<Integer> al) {

    int lo = 0;
    int temp;

    for (int i=0; i < al.size() - 1; i++) {
      lo = findSmallest(al, i, al.size()-1);
      temp = al.get(i);
      al.set(i, al.get(lo));
      al.set(lo, temp);
    }

  }//selectionSort

  //returns a sublist of al containing the elements at indices in the range [lo, hi)
  public static ArrayList<Integer> slice(ArrayList<Integer> al, int lo, int hi) {

    ArrayList<Integer> sub = new ArrayList<Integer>();
    for (; lo < hi; lo++) {
      sub.add( al.get(lo) );
    }//copy
    return sub;
  }//slice


  //Input: 2 SORTED ArrayLists
  //  returns 1 new SORTED ArrayList containing all the elements from lists a and b
  public static ArrayList<Integer> merge(ArrayList<Integer> m1,
                                         ArrayList<Integer> m2) {
    // make a new ArrayList
	ArrayList<Integer> merged = new ArrayList<Integer>();
    // indices for each input
	int i1 = 0;
	int i2 = 0;
	// Saving a bit of time by using a tiny bit more space
	int sizem1 = m1.size();
	int sizem2 = m2.size();
    //while both indices are less than their respective lengths
	while (i1<sizem1 && i2<sizem2) {
		//compare current, add smaller to merged & update index
		if ( m1.get(i1) < m2.get(i2) ) {
			merged.add( m1.get(i1) );
			i1++;
		} else {
			merged.add( m2.get(i2) );
			i2++;
		}
	}
    //loop ends: one index is past the end of the list
	//copy the values from the reamining list over
	while(i1<sizem1) {
		merged.add(m1.get(i1));
		i1++;
	}
	while(i2<sizem2) {
		merged.add(m2.get(i2));
		i2++;
	}
	// Allow empty arrays as input? YES
	// if ( merged.isEmpty() )
		// throw new IllegalArgumentException();
    return merged;
  }//merge

  public static void main( String[] args )
  {
    ArrayList<Integer> rando = prestoArrayListo(10, 0, 100);
    ArrayList<Integer> calrissian = prestoArrayListo(10, 0, 100);
	ArrayList<Integer> empty1 = new ArrayList<Integer>();
	ArrayList<Integer> empty2 = new ArrayList<Integer>();

    selectionSort(rando);
    selectionSort(calrissian);
	
    System.out.printf("rando: %s\n", rando);
    System.out.printf("calrissian: %s\n", calrissian);

    ArrayList<Integer> randoCalrissian = merge(rando, calrissian);
    System.out.printf("randoCalrissian: %s\n", randoCalrissian);
	
	selectionSort(empty1);
    System.out.printf("SSort empty1: %s\n", empty1);
	
	ArrayList<Integer> emptyMerged = merge(empty1,empty2);
	System.out.printf("emptyMerged: %s\n", emptyMerged);

  }//end main

}//end class