import java.io.*;
import java.util.*;

public class Phonebook {
	/**********************************
	If well implemented this routines should be O(1),
		i.e. calculate the hashcode, map it to an index, and get the item
	if many collisions exist, specially if using ArrayList,
		addition, deletions, finds and traversing could get expensive
	//********************************/
	public class Person {
	  private String lastName = null;
	  private String firstName = null;
	  private String phoneNumber = null;  
	  // other members not shown
	}
	// use an array for the hastable, the index is some form of the hashcode
	// use a list for collisions (ArrayList, LinkedList, or just a List)
	private LinkedList<Person>[] phonebook = new LinkedList[1000];
	
	public Phonebook(){
		// empty phonebook
		// I do not see that anything is needed here
	}
	
	public void add(Person p){
		// calculate hash for Person
		//	use simple first character hash (many collisions)
		//  use the typical string hash algorithm, for a STring of size n
		// 		hash(s)=s[0]+s[1]⋅p+s[2]⋅p^2+...+s[n−1]⋅p^(n−1) mod m
		//		were p is 31 for lowercase, or 53 for both (Caps too)
		//		m is a large prime which we can use to control array size
		//  use Java's String hashCode(); int range[MIN_VALUE, MAX_VALUE]
		
		// create a new List for the position and
		//	fill the new position with a new Person
		// if a collision happens, add a new person to the list in that position
		
		// place the Person
	}
	
	public Person find(Person p){
		// calculate hash code
		// search through List if more than one
		// return Person
		return null;
	}
	
	public void remove(Person p){
		// calculate hash code
		// search through List if more than one
		// remove the item from the list if in a list
		// clear the entry if it is the only one
	}
	
	public void printList(Person p){
		// Since implementation is an array
		// simply traverse and print it
		// however, every inside List needs to be printed as well
	}

    public static void main(String[] args){

    }
}