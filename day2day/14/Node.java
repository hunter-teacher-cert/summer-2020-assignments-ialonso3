import java.io.*;
import java.util.*;

public class Node {
    private int data;
    private Node left;
	private Node right;

    public Node(int data, Node left, Node right){
		this.left = left;
		this.right = right;
		this.data = data;
    }
	
	public Node(int data, Node left) {
		this.left = left;
		this.right = null;
		this.data = data;
	}
	
    public Node(int data){
		this.left = null;
		this.right = null;
		this.data = data;
    }
	
    public Node(){
		this.left = null;
		this.right = null;
		this.data = 0;
    }
    
    public void setData(int data){
		this.data = data;
    }
    
    public void setLeft(Node left){
		this.left = left;
    }
	
	public void setRight(Node right){
		this.right = right;
    }
	
    public int getData(){
		return data;
    }
	
    public Node getLeft(){
		return left;
    }
	
	public Node getRight(){
		return right;
    }

    public String toString(){
		return Integer.toString(this.data);
    }
}