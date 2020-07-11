import java.io.*;
import java.util.*;

public class StackDriver {
  public static void main(String[] args) {

		MyStack g = new MyStack();

		System.out.println("Test Empty list print, isEmpty & size:");
		System.out.println(g);
		System.out.println(g.isEmpty());
		System.out.printf("Size: %d\n",g.size());
		
		System.out.println("Test pop Empty list print:");
		try {
			System.out.println(g.pop());
		}
		catch (EmptyStackException e) {
			e.printStackTrace();
		}
		
		System.out.println("Test top Empty list print:");
		try {
			System.out.println(g.top());
		}
		catch (EmptyStackException e) {
			e.printStackTrace();
		}

		System.out.println("\nTest push 3x, isEmpty & size:");
		g.push("good");
		g.push("news");
		g.push("everyone!");
		System.out.println(g);
		System.out.println(g.isEmpty());
		System.out.printf("Size: %d\n",g.size());
		
	   System.out.println("\nTest top");
	   System.out.println(g.top());
	   System.out.printf("Size: %d\n",g.size());

	   System.out.println("\nTest pop");
	   System.out.println(g.pop());
	   System.out.printf("Size: %d\n",g.size());

	  
	   
  }//main
}//LListDriver