import java.io.*;
import java.util.*;

// ******************************************************
// This class requires my LList.class & Node.class files
// ******************************************************
public class MyStack{
      // add your internal data structure here
	  private LList stack;

      public MyStack(){
          // add constructor code
		  stack = new LList();
      }

      public void push(String data){
          // add code to push data on to the stack
		  stack.add(data); // defaults to FRONT
      }

      public String pop(){
          // add code to remove and return the
          // item on the top of the stack
		  String data = this.top();
		  stack.remove(0);
		  return data;
      }

      public String top(){
          // add code to return but not remove the
          // item on the top of the stack  
		  try {
			return stack.get(0);
		  }
		  catch (IndexOutOfBoundsException e) {
			  throw new EmptyStackException();
		  }	
      }

      public boolean isEmpty(){
          // return true if the stack has no data, false otherwise
		  return stack.isEmpty();
      }

      public int size(){
          // add code to return the number of items currently on the stack
		  return stack.length();
	  }
	  
	  public String toString(){
          // add code to return the number of items currently on the stack
		  String str = stack.toString();
		  // strip away the NULL at the end
		  str = str.substring(0,str.length()-4);
		  // add HEAD and BOTTOM
		  str = "HEAD-->"+str+"BOTTOM";
		  return str;
	  }
	  
	  // public static void main(String[] args) {
		// MyStack g = new MyStack();
		// System.out.println("\nTest push 3x & isEmpty():");
		// g.push("good");
		// g.push("news");
		// g.push("everyone!");
		// System.out.println(g);
		// System.out.println(g.isEmpty());
	  // }
	  
  }