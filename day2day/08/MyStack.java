import java.io.*;
import java.util.*;

public class MyStack{
      // add your internal data structure here
	  private LinkedList<String> stack;

      public MyStack(){
          // add constructor code
		  stack = new LinkedList<String>();
      }

      public void push(String data){
          // add code to push data on to the stack
		  stack.addFirst(data);
      }

      public String pop(){
          // add code to remove and return the
          // item on the top of the stack
		  String data = this.top();		// get it (exception checked)
		  stack.removeFirst();			// remove it
		  return data;					// return it
      }

      public String top(){
          // add code to return but not remove the
          // item on the top of the stack   
		  try {
			return stack.getFirst();
		  }
		  catch (NoSuchElementException e) {
			  // Modify LinkedList's exception to stack exception
			  throw new EmptyStackException();
		  }
      }

      public boolean isEmpty(){
          // return true if the stack has no data, false otherwise
		  return stack.isEmpty();
      }

      public int size(){
          // add code to return the number of items currently on the stack
		  return stack.size();
	  }
	  
	  public String toString(){
		  String str = ":HEAD:-->";
		  for (String s: stack) {
			  str += s + "-->";
		  }
		  str += ":BOTTOM:";
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
		// System.out.println( g.top() );
	  // }
	  
  }