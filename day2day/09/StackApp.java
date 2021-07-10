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
	
	public static String reverseWord(String s){
			Stack<String> w = new Stack<String>();
			String str = "";
			int inx = 0;
			int i = 0;
			while(i < s.length()) {
				inx = s.indexOf(' ',i);
				if (inx > -1) {
					if (i==0)
						// do not add the space
						w.push(s.substring(i,inx));
					else
						w.push(s.substring(i,inx)+" ");
					i = inx + 1;
				} else {
					w.push( s.substring(i,s.length())+" ");
					i = s.length();
				}
			}
			while (! w.isEmpty() ) {
				str += w.pop();
			}
			return str;
	}
	
	public static boolean isPalindrome(String s) {
		return s.equals( reverse(s) );
	}
	
	public static boolean isWordPalindrome(String s) {
		return s.equals( reverseWord(s) );
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
		System.out.println("***************************");
		str = "I am what I am";
		System.out.println("Reverse: "+str);
		System.out.println(reverse(str));
		System.out.println("***************************");
		System.out.println("Word reverse: "+str);
		System.out.println(reverseWord(str));
		System.out.println("***************************");
		str = "racecar";
		System.out.println("Palindrome: "+str);
		System.out.println( isPalindrome(str));
		System.out.println("***************************");
		str = "banana";
		System.out.println("Not Palindrome: "+str);
		System.out.println( isPalindrome(str));
		System.out.println("***************************");
		str = "I am what am I";
		System.out.println("Word Palindrome: "+str);
		System.out.println( isWordPalindrome(str));
		System.out.println("***************************");
		str = "I am not what am I not";
		System.out.println("Not Word Palindrome: "+str);
		System.out.println( isWordPalindrome(str));
		System.out.println("***************************");
		str = "5(3+(5-1)(5))";
		System.out.println("Correct stmt: "+str);
		System.out.println(parenCheck(str));
		System.out.println("***************************");
		str = "5(3+(5-1(5))";
		System.out.println("Incorrect stmt: "+str);
		System.out.println(parenCheck(str));
		System.out.println("***************************");
		str = "53)+(5-1)(5)(";
		System.out.println("Incorrect stmt: "+str);
		System.out.println(parenCheck(str));
		System.out.println("***************************");
    }
	

}

