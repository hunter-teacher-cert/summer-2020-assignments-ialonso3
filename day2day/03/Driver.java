import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
		Time t = new Time();
		Time time = new Time(11, 59, 59.9);
		
		t.setHour(13);
		t.setMinute(59);
		t.setSecond(59.9);
		
		System.out.println();
		System.out.println(t.toString());
		System.out.println(time.toString());
		
		System.out.println( t.add(time).toString() );
		
		Time t1 = new Time(9, 30, 0.0);
		Time t2 = t1;
		Time t3 = new Time(9, 30, 0.0);
		
		if (t1 == t2) 
			System.out.println("t1 == t2");
		else
			System.out.println("t1 != t2");
		if (t2 == t3) 
			System.out.println("t2 == t3");
		else
			System.out.println("t2 != t2");
		if (t1 == t3) 
			System.out.println("t1 == t3");
		else
			System.out.println("t1 != t2");
		System.out.println();
		
		if (t1.equals(t2)) 
			System.out.println("t1 equals t2");
		else
			System.out.println("t1 not equal t2");
		if (t2.equals(t3)) 
			System.out.println("t2 equals t3");
		else
			System.out.println("t2 not equal t2");
		if (t1.equals(t3)) 
			System.out.println("t1 equals t3");
		else
			System.out.println("t1 not equal t2");
    }
}