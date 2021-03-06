import java.io.*;
import java.util.*;

public class BSTree {
    private TreeNode root;

    public BSTree(){
		root = null;
    }

	private void preorderTraverse(TreeNode current) {
		if (current == null)
			return;
		
		//process the current node
		System.out.print(current.getData()+", ");
		
		// process left
		preorderTraverse(current.getLeft());
		
		//process right
		preorderTraverse(current.getRight());
		
	}
	public void preorderTraverse() {
		preorderTraverse(root);
		System.out.println();
	}
	
	private void postorderTraverse(TreeNode current) {
		if (current == null)
			return;
		
		// process left
		postorderTraverse(current.getLeft());
		
		//process right
		postorderTraverse(current.getRight());
		
		//process the current node
		System.out.print(current.getData()+", ");
		
	}
	public void postorderTraverse() {
		postorderTraverse(root);
		System.out.println();
	}
	
	private void inorderTraverse(TreeNode current) {
		if (current == null)
			return;
		
		// process left
		inorderTraverse(current.getLeft());
		
		//process the current node
		System.out.print(current.getData()+", ");
		
		//process right
		inorderTraverse(current.getRight());
		
	}
	public void inorderTraverse() {
		inorderTraverse(root);
		System.out.println();
	}
	
	private int getMax(TreeNode curr) {
		int max = -1;
		while (curr != null) {
			max = curr.getData();
			curr = curr.getRight();
		}
		return max;
	}
	
	private int getMin(TreeNode curr) {
		int min = -1;
		while (curr != null) {
			min = curr.getData();
			curr = curr.getLeft();
		}
		return min;
	}

	// ************* DELETE **************8
	// Z's delete skeleton
	public void delete(int key){
		
		TreeNode front = root;
		TreeNode trailer = root;
		while (front != null && front.getData()!=key ){
			trailer = front;
			if (front.getData() < key){
				front = front.getRight();
			} else {
				front = front.getLeft();
			}
		}
		// if front == key, then front==trailer==root
		
		// if the key wasn't in the tree
		// or the tree is empty
		if (front == null){
			return;
		}

		// if we get here
		// front points to the node we want
		// and trailer points to the one above it
		
		if (front.getLeft()!= null) {
		// find the node with the largest value
		// on front's left subtree & replace front with it.
			int maxVal = getMax(front.getLeft());
			delete(maxVal);
			front.setValue(maxVal);
		} else if (front.getRight() != null) {
		// find the node with the smallest value
		// on front's right subtree & replace front with it.
			int minVal = getMin(front.getRight());
			delete(minVal);
			front.setValue(minVal);
		} else {
		// front has no children
			if (front==trailer){
					// root is the key 
					root = null;
			} else {
				if (trailer.getLeft()!=null && trailer.getLeft().getData()==front.getData())
					// front is a left child
					trailer.setLeft(null);
				else
					// front is a right child
					trailer.setRight(null);
			}
		}
		/***********other cases***************
		else {
			// front has one or no children	
			TreeNode setNode = null;
			if (front.getRight() != null){
				// repoint front's parent to front's right
				setNode = front.getRight();
			} else if (front.getLeft() != null){
				// repoint front's parent to front's left
				setNode = front.getLeft();
			}// otherwise no children, e.g., null
			if (front==trailer){
					// root is the key
					root = setNode;
			} else {
				if (isLeft)
					// front is a left child
					trailer.setLeft(setNode);
				else
					// front is a right child
					trailer.setRight(setNode);
			}
		}
		//***************************************/
	}
	
	public void insert(int key) {
		TreeNode newNode = new TreeNode(key);
		if (root==null) {
			root = newNode;
			return;
		}
		TreeNode front = root;
		TreeNode trailer = null;
		while (front != null){
			int frontVal = front.getData();
			if (frontVal == key){
				return;
			} else if (frontVal < key){
				trailer = front;
				front = front.getRight();
			} else {
				trailer = front;
				front = front.getLeft();
			}
		}
		//front points to null
		//trailer points to previous
		if (trailer.getData() < key )
			trailer.setRight(newNode);
		else
			trailer.setLeft(newNode);
	}
	
	public int search(int key){
		TreeNode curr = root;
		while (curr != null){
			int currVal = curr.getData();
			if (currVal == key){
				return currVal;
			} else if (currVal < key){
				curr = curr.getRight();
			} else {
				curr = curr.getLeft();
			}
		}
		throw new NullPointerException();
		// return -1;
    }

    public void seed(){
		TreeNode t;

		t = new TreeNode(10);
		root = t;
		t = new TreeNode(5);
		root.setLeft(t);
		t = new TreeNode(20);
		root.setRight(t);

		root.getLeft().setRight( new TreeNode(8));

		t = new TreeNode(15);
		root.getRight().setLeft(t);

		t = new TreeNode(22);
		root.getRight().setRight(t);
	
	}
}