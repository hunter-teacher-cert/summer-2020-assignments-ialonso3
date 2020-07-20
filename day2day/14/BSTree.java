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
		// front points to null
		// trailer points to previous
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