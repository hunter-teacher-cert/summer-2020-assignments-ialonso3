import java.io.*;
import java.util.*;

public class LList{
    private Node head;
	private int len = 0;
	
	private static final int FRONT = -10000;
	private static final int END = -20000;

	// Default constructor
	// 	Initializes an empty linked list.
    public LList(){
		head = null;
    }

	// public void addFront(String value)
	// 	Add a new Node containing value to the front of the list.
    private void addFront(String data){
		
		Node newnode = new Node(data);

		// first point the new node to the beginning
		newnode.setNext(head);

		// point head to the new node
		head = newnode;
		len++;
    }
	
	// Add anywhere
	public void add(String data, int where){
		
		if(data == null) {
			throw new IllegalArgumentException();
		}
		
		if (where == FRONT)
			addFront(data);
		else if (where == END)
			append(data);
		else if (where >= 0)
			insert(where, data);
		else
			throw new IndexOutOfBoundsException();
    }
	// Overload: add FRONT default
	public void add(String data){
		add(data, FRONT);
	}
 
	// public String toString()
	// 	Returns a String representation of the list.
    public String toString(){
		String s = "";
		Node tmp;
		tmp = head;
		while (tmp != null){
			s = s + tmp.getData()+"-->";
			// how can we now move tmp to the next node
			// this is the magic linked list idiom!!!!
			// this moves a pointer to the next node!!!
			// It's analagous to i=i+1 for an array (for loop)
			tmp = tmp.getNext();
		}
		s = s + "null";
		return s;
    } 
	
	// public boolean isEmpty()
	// 	Returns true if the list is empty, false otherwise.
	public boolean isEmpty() {
		return head == null;
	}
	
	// public Node nodeAtIndex(int index)
	// 	Returns the Node at index.
	// 	If index is out of bounds, return null
	// Assumes starting at 0, i.e. head points to ZERO index Node
	private Node nodeAtIndex(int index) {
		int i = 0;
		Node ptr = head;
		while ((ptr != null) && (i < index)) {
			ptr = ptr.getNext();
			i++;
		}
		if (ptr == null)
			throw new IndexOutOfBoundsException();
		return ptr;
	}
	
	// public String get(int index)
	// 	Returns the value (not the Node) at index.
	// 	If index is out of bounds, return null. --> Exception
	public String get(int index) {
		Node ptr = nodeAtIndex(index);
		// if (ptr != null) 
			return ptr.getData(); // exception for IndexOutOfBounds
		// return null;
	}
	
	// public void set(int index, String value)
	// 	Set the Node at index to contain value
	// 	If index is invalid, do nothing. --> Exception
	public void set(int index, String value){
		Node ptr = nodeAtIndex(index);
		// if ( ptr != null )
			//ptr.setData(value);	// exception for IndexOutOfBounds
		if( value == null) {
			throw new IllegalArgumentException();
		}
		ptr.setData(value);
		
	}
	
	// public void append(String value)
	// 	Add a node at the end, set data to value
	private void append(String value){
		Node ptr = nodeAtIndex(len-1);
		// if (ptr != null){
			// exception for IndexOutOfBounds
			Node newNode = new Node(value);
			ptr.setNext(newNode);	
			len++;
		//}
	}
	
	// public void insert(int index, String value)
	// 	Insert a new Node containing value at index.
	// 	If index is invalid, do nothing
	private void insert(int index, String value){	
		if (index == 0) {
			addFront(value);
		} else {
			Node ptr = nodeAtIndex(index-1);
			Node newNode = new Node(value);
			// if (ptr != null){
				// exception for IndexOutOfBounds
				newNode.setNext( ptr.getNext() );
				ptr.setNext(newNode);
				len++;
			//}
		}
	}
	
	// public int search(String key)
	// 	Returns the index of the first time key occurs in the list.
	// 	Returns -1 if key is not found.
	public int search(String key) {
		if (key == null) {
			throw new IllegalArgumentException();
		}
		Node ptr = head;
		for(int i=0; ptr!=null; i++) {
			if (ptr.getData().equals(key) )
				return i;
			ptr = ptr.getNext();
		}
		return -1;
		// throw new NoSuchElementException();
	}
	
	// public int lebgth
	// 	Returns the length of the list.
	public int length() {
		return len;
	}
	
	// public void remove(int index)
	// 	Removes the Node at index from the list.
	// 	If index is invalid, do nothing.
	public void remove(int index){
		if (index == 0) {
			if (head != null) {
				head = head.getNext();
				len--;
			}
			else 
				throw new IndexOutOfBoundsException();
		} else {
			Node ptr = nodeAtIndex(index-1);
			//if ( ptr != null ){
				// exception for IndexOutOfBounds
				ptr.setNext( ptr.getNext().getNext() );
				len--;
			//}
		}
		
	}
}