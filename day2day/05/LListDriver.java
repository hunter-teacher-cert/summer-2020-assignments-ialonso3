import java.io.*;
import java.util.*;

public class LListDriver {
  public static void main(String[] args) {

		LList g = new LList();
		
		final int FRONT = -10000;
		final int END = -20000;

		System.out.println("Test Empty list print & isEmpty:");
		System.out.println(g);
		System.out.println(g.isEmpty());

		System.out.println("\nTest addFront 3x & isEmpty():");
		g.add("good", FRONT);
		g.add("news", FRONT);
		g.add("everyone!", FRONT);
		System.out.println(g);
		System.out.println(g.isEmpty());

	   System.out.println("\nTest get 0, 1, 5:");
	   System.out.println(g.get(0));
	   System.out.println(g.get(1));
	   try {
		   System.out.println(g.get(5));
	   }
	   catch ( IndexOutOfBoundsException e ) {
		   e.printStackTrace();
		   System.out.println("Did not get(5)");
	   }

	   System.out.println("\nTest set 0, 1, 5:");
	   g.set(0, "me!");
	   g.set(1, "job");
	   try {
		   g.set(2, null);
	   }
	   catch ( IllegalArgumentException e ) {
		   e.printStackTrace();
		   System.out.println("null Not set");
	   }
	   try {
		   g.set(5, "wow");
	   }
	   catch ( IndexOutOfBoundsException e ) {
		   e.printStackTrace();
		   System.out.println("5 is too far");
	   }
	   System.out.println(g);

	   System.out.println("\nTest insert 0, 2, 5, 10:");
	   g.add("woo!",0);
	   g.add("go", 2);
	   g.add("cool", 5);
	   try {
		   g.add("too far", 10);
	   }
	   catch ( IndexOutOfBoundsException e ) {
		   e.printStackTrace();
		   System.out.println("5 is too far");
	   } 
	   System.out.println(g);
	   
	   System.out.println("\nTest append");
	   g.add("EXTRA!", END);
	   System.out.println(g);

	   System.out.println("\nTest search \"woo!\", \"cool\", \"too far\"");
	   System.out.println(g.search("woo!"));
	   System.out.println(g.search("cool"));
	   System.out.println(g.search("too far"));  //OK
	   try {
		   // No longer an exception
		   System.out.println(g.search(null));
	   }
	   catch ( IllegalArgumentException e ) {
		   e.printStackTrace();
		   System.out.println("null Not found");
	   } 
	   
	   System.out.println("\nTest remove 0, 2:");
	   g.remove(0);
	   System.out.println(g);
	   g.remove(2);
	   System.out.println(g);
	   // Try to remove right after the last one
	   try {
		   g.remove( g.length() );
	   }
	   catch ( IndexOutOfBoundsException e ) {
		   e.printStackTrace();
		   System.out.println("Just passed the end!");
	   } 
	   System.out.println(g);
	   
  }//main
}//LListDriver