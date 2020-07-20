import java.io.*;
import java.util.*;

public class TreeNode {
    private int value;
    private TreeNode left;
	private TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right){
		this.left = left;
		this.right = right;
		this.value = value;
    }
	
	public TreeNode(int value, TreeNode left) {
		this.left = left;
		this.right = null;
		this.value = value;
	}
	
    public TreeNode(int value){
		this.left = null;
		this.right = null;
		this.value = value;
    }
	
    public TreeNode(){
		this.left = null;
		this.right = null;
		this.value = 0;
    }
    
    public void setValue(int value){
		this.value = value;
    }
    
    public void setLeft(TreeNode left){
		this.left = left;
    }
	
	public void setRight(TreeNode right){
		this.right = right;
    }
	
    public int getValue(){
		return value;
    }
	
    public TreeNode getLeft(){
		return left;
    }
	
	public TreeNode getRight(){
		return right;
    }

    public String toString(){
		return Integer.toString(this.data);
    }
}