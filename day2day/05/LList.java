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
	// Initialize with data attribute
	// where = FRONT, END or an index
	public void add(String data, int where){
		// if data is NULL, throw an exception
		if(data == null) {
			throw new IllegalArgumentException();
		}
		// check where -> addFronr, append or insert
		if (where == FRONT)
			addFront(data);
		else if (where == END)
			append(data);
		else if (where >= 0)
			insert(where, data);
		else
			// index < 0 and != FRONT or END
			throw new IndexOutOfBoundsException();
    }
	// Overload: add FRONT default
	public void add(String data){
		add(data, FRONT);
	}
 
	// public String toString()
	// 	Returns a String representation of the list.
    public String toString(){
		String s = "SuperArray, length="+String.valueOf(len)+"; ";
		Node tmp = head;
		while (tmp != null){
			s = s + tmp.getData()+"-->";
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
		// int i = 0;
		// Node ptr = head;
		// while ((ptr != null) && (i < index)) {
			// ptr = ptr.getNext();
			// i++;
		// }
		// Handle the IndexOutOfBounds exception
		// if (ptr == null)
			// throw new IndexOutOfBoundsException();
		// return ptr;
		
		// Refactored per JonALf's code
		// More complex thinking but cleaner code
		Node ptr = head;
		while( ptr != null ) {
			if (index == 0) 
				return ptr;
			ptr = ptr.getNext();
			index--;
		}
		throw new IndexOutOfBoundsException();
	}
	
	// public String get(int index)
	// 	Returns the value (not the Node) at index.
	// 	If index is out of bounds, return null. --> Exception
	public String get(int index) {
		Node ptr = nodeAtIndex(index);
		return ptr.getData(); // IndexOutOfBounds handled
	}
	
	// public void set(int index, String value)
	// 	Set the Node at index to contain value
	// 	If index is invalid, do nothing. --> Exception
	public void set(int index, String value){
		Node ptr = nodeAtIndex(index);
		if( value == null) {
			throw new IllegalArgumentException();
		}
		ptr.setData(value);
	}
	
	// public void append(String value)
	// 	Add a node at the end, set data to value
	private void append(String value){
		Node ptr = nodeAtIndex(len-1);
		// IndexOutOfBounds exception handled in nodeAtIndex
		Node newNode = new Node(value);
		ptr.setNext(newNode);	
		len++;
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
			// IndexOutOfBounds exception handled in nodeAtIndex
			newNode.setNext( ptr.getNext() );
			ptr.setNext(newNode);
			len++;
		}
	}
	
	// public int search(String key)
	// 	Returns the index of the first time key occurs in the list.
	// 	Returns -1 if key is not found.
	public int search(String key) {
		// Chose to allow a null key
		//  You may want to know if there is a null in your list
		// if (key == null) {
			// throw new IllegalArgumentException();
		// }
		Node ptr = head;
		// tried an unusual for-loop instead of a while-loop
		for(int i=0; ptr!=null; i++) {
			if (ptr.getData().equals(key) )
				return i;
			ptr = ptr.getNext();
		}
		// Chose to allow searh for an item not on the list
		//  You may want to know if something is missing in your list
		return -1;
		// throw new NoSuchElementException();
	}
	
	// public int length
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
			// IndexOutOfBounds exception handled in nodeAtIndex
			// but the end could be the very next one
			if (ptr.getNext() == null) {
				throw new IndexOutOfBoundsException();
			} else {
				ptr.setNext( ptr.getNext().getNext() );
				len--;
			}
		}
		
	}
}