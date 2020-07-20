import java.io.*;
import java.util.*;

public class TreeNode {
    private int data;
    private TreeNode left;
	private TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right){
		this.left = left;
		this.right = right;
		this.data = data;
    }
	
	public TreeNode(int data, TreeNode left) {
		this.left = left;
		this.right = null;
		this.data = data;
	}
	
    public TreeNode(int data){
		this.left = null;
		this.right = null;
		this.data = data;
    }
	
    public TreeNode(){
		this.left = null;
		this.right = null;
		this.data = 0;
    }
    
    public void setData(int data){
		this.data = data;
    }
    
    public void setLeft(TreeNode left){
		this.left = left;
    }
	
	public void setRight(TreeNode right){
		this.right = right;
    }
	
    public int getData(){
		return data;
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