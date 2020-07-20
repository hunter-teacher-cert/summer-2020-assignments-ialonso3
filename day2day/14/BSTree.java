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
	
	// use the transverse to insert all the nodes
	// in a given orphaned tree
	private void inorderInsert(TreeNode current) {
		if (current == null)
			return;	
		// process left
		inorderTraverse(current.getLeft());	
		//process the current node
		insert(current.getData());
		//process right
		inorderTraverse(current.getRight());	
	}
	
	public void delete(int key) {
		TreeNode front = root;
		TreeNode trailer = null;
		while (front != null){
			int frontVal = front.getData();
			if (frontVal == key){  // found it
				if (trailer != null) {
					// front is to the left
					if(trailer.getLeft().getData()==frontVal) {
						// does front have both left and right?
						if (front.getRight()!=null && front.getLeft()!=null){
							// trailer left points to front's left
							trailer.setLeft(front.getLeft());
							// but front's right side is orphaned
							// Insert all the Nodes on front's right
							this.inorderInsert(front.getRight());				
						} else if (front.getRight() != null) {
						// front has only a right
							// point trailer's left to front's right
							trailer.setLeft(front.getRight());
							return;
						} else if (front.getLeft() != null) {
						// front has only a left
							// point trailer's left to front's left
							trailer.setLeft(front.getLeft());
							return;
						} else {
						// both left and right of front are null
							// just set trailer's left to null
							trailer.setLeft(null);
							return;
						}	
					} else {
					// front is to the right
						// does front have both left and right?
						if (front.getRight()!=null && front.getLeft()!=null){
							// trailer right points to front's right
							trailer.setRight(front.getRight());
							// but front's left side is orphaned
							// Insert all the Nodes on front's left
							this.inorderInsert(front.getLeft());				
						} else if (front.getRight() != null) {
						// front has only a right
							// point trailer's right to front's right
							trailer.setRight(front.getRight());
							return;
						} else if (front.getLeft() != null) {
						// front has only a left
							// point trailer's right to front's left
							trailer.setRight(front.getLeft());
							return;
						} else {
						// both left and right of front are null
							// just set trailer's left to null
							trailer.setRight(null);
							return;
						}
					}
				} else {
				// key is at the root
					front.setLeft(root.getLeft());
					this.inorderInsert(front.getRight());
				}
			} else if (frontVal < key){
				trailer = front;
				front = front.getRight();
			} else {
				trailer = front;
				front = front.getLeft();
			}
		}
		throw new NullPointerException();
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
		//****************************
		if (trailer.getData() < key )
			trailer.setRight(newNode);
		else
			trailer.setLeft(newNode);
	}
	
	// finds the Node with that key &
	// returns the previous one
	// private TreeNode getPrevious(int key)
	// {
		// TreeNode front = root;
		// TreeNode trailer = null;
		// while (front != null){
			// int frontVal = front.getData();
			// if (frontVal == key){
				// return trailer;
			// } else if (frontVal < key){
				// trailer = front;
				// front = front.getRight();
			// } else {
				// trailer = front;
				// front = front.getLeft();
			// }
		// }
		// return trailer;
	// }
	
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