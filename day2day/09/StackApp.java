import java.io.*;
import java.util.*;

public class StackApp {
	
	public static String reverse(String s){
			Stack<Character> w = new Stack<Character>();
			String str = "";
			for (int i=0; i<s.length(); i++) {
				w.push(s.charAt(i));
			}
			for (int i=0; i<s.length(); i++) {
				str += Character.toString( w.pop() );
			}
			return str;
	}
	
	public static boolean isPalindrome(String s) {
		return s.equals( reverse(s) );
	}
	
	public static boolean parenCheck(String s) {
		Stack<Character> w = new Stack<Character>();
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) == '(') {
				w.push(s.charAt(i));
			} else if (s.charAt(i) == ')') {
				if ( w.isEmpty() )
					return false;
				w.pop();
			}
		}
		if ( ! w.isEmpty() )
			return false;
		return true;
	}
	
	public static void main(String[] args){
		String str = "";
		str = "I am what I am";
		System.out.println("Reverse: "+str);
		System.out.println(reverse(str));
		str = "racecar";
		System.out.println("Palindrome: "+str);
		System.out.println( isPalindrome(str));
		str = "banana";
		System.out.println("Not Palindrome: "+str);
		System.out.println( isPalindrome(str));
		str = "5(3+(5-1)(5))";
		System.out.println("Correct stmt: "+str);
		System.out.println(parenCheck(str));
		str = "5(3+(5-1(5))";
		System.out.println("Incorrect stmt: "+str);
		System.out.println(parenCheck(str));
    }
	

}

