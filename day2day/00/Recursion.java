import java.io.*;
import java.util.*;

public class Recursion {
    public static void main(String[] args){
		System.out.println("***factorial***");
        System.out.println( factorial(4) );
		System.out.println("***fibonacci***");
		System.out.println( fibonacci(4) );
		System.out.println("***Ackerman***");
		System.out.println(ack(2,2));
    }
	
	public static int factorial(int n) {
		if ((n == 0) || (n == 1)) {
			return 1;
		}
		return (n * factorial(n-1));	
	}
	
	public static int fibonacci(int n) {
		if ((n == 1) || (n == 2)){
			return 1;
		}
		return (n-1 + fibonacci(n -2));
	}
	
	// Exercise 8 - Assumes non-negative inputs n & m
	private static int ack(int m, int n){
		if (m == 0){
			return n + 1;
		} 
		else if (n == 0){
			return ack(m-1,1);
		} 
		else {
			return ack(m-1, ack(m, n-1));
		}
		
	}
}