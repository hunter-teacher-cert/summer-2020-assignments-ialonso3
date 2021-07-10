import java.io.*;
import java.util.*;

public class SuperArray {
    // public static void main(String[] args){
        // SuperArray sArray = new SuperArray();
		// System.out.println(sArray.isEmpty());
		// sArray.add(3);
		// sArray.add(5);
		// System.out.println(sArray);
		// System.out.println(sArray.isEmpty());
		// System.out.println(sArray.get(1));
		// System.out.println(sArray.get(5));
		// sArray.add(1,2);
		// System.out.println(sArray);
		// sArray.remove(0);
		// System.out.println(sArray);
		
		// System.out.println("*************************");
		// SuperArray SA2 = new SuperArray(5);
		// System.out.println(SA2.isEmpty());
		// System.out.println(SA2);
		// for (int i = 0; i < 5; i++)
			// SA2.add(i);
		// System.out.println(SA2.isEmpty());
		// System.out.println(SA2);
		// SA2.add(10); // grows the array
		// System.out.println(SA2);
    // }
	
	private int[] data;
	private int numberElements;
	
	public SuperArray() {
		data = new int[10];
		numberElements = 0;
	}
	
	public SuperArray(int size) {
		data = new int[size];
		numberElements = 0;
	}
	
	public int getNumElements() {
		return numberElements;
	}
	
	public void grow(int inc) {
		int newSize = data.length + inc;
		int[] newData = new int[newSize];
		for (int i = 0; i < numberElements; i++){
			newData[i] = data[i];
		}
		data = newData;
	}
	
	// insert
	public void add(int index, int val) {
		if (index >= data.length)
			return;
		if (numberElements >= data.length)
			grow(1);
		for(int i=numberElements; i>index; i--) {
			data[i] = data[i-1];
		}
		data[index] = val;
		numberElements++;
	}
	
	public void add(int val) {
		if (numberElements >= data.length)
			grow(1);
		data[numberElements] = val;
		numberElements += 1;
	}
	
	public void remove(int index) {
		for (int i = index; i<data.length-1; i++) {
			data[i] = data[i+1];
		}
		numberElements -= 1;
	}
	
	public int get(int index) {
		if (index >= numberElements)
			return -1;
		return data[index];
	}
	
	public boolean isEmpty() {	
		return (numberElements == 0);
	}
	
	public String toString() {
		String str = "SuperArray: ";
		for (int i = 0; i < numberElements-1; i++){
			str += data[i] + ", ";
		}
		if (numberElements > 0) 
			str += data[numberElements-1];
		return str;
	}
}