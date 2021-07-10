import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) {
		BSTree t = new BSTree();
			
		/*
		t.seed();
		int value;
		value = t.search(10);
		System.out.println(value);
		value = t.search(15);
		System.out.println(value);
		try {
			value = t.search(17);
			System.out.println(value);
		} catch (NullPointerException e) {
			System.out.println("17 not in tree");
		}
		//*/
		
		t.insert(10);
		t.insert(20);
		t.insert(5);
		t.insert(7);
		t.insert(8);
		t.insert(3);
		t.inorderTraverse();
		
		// t.preorderTraverse();
		// t.postorderTraverse();
		// t.inorderTraverse();
		
		System.out.println("*********Delete 5*******");
		t.delete(5);
		t.inorderTraverse();
		System.out.println("*********Insert 25*******");
		t.insert(25);
		t.inorderTraverse();
		System.out.println("*********Delete 7*******");
		t.delete(7);
		t.inorderTraverse();
		System.out.println("*********Delete 90 NOT*******");
		t.delete(90);
		t.inorderTraverse();
		System.out.println("*********Delete 10*******");
		t.delete(10);
		t.inorderTraverse();
		System.out.println("*********Delete 25*******");
		t.delete(25);
		t.inorderTraverse();
		System.out.println("*********Delete 3*******");
		t.delete(3);
		t.inorderTraverse();
		System.out.println("*********Delete 8*******");
		t.delete(8);
		t.inorderTraverse();
		System.out.println("*********Delete 20*******");
		t.delete(20);
		t.inorderTraverse();
		
    }
}