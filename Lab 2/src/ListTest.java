/**
 * Test the a generic doubly-linked list class
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 2
 */
import java.util.NoSuchElementException;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> L = new List<Integer>();
		System.out.println("Should print nothing (an empty list) : " + L);
		System.out.println("**Testing addFirst**");
		L.addFirst(2); // Testing Edge case: length == 0
		System.out.println("Should print 2: " + L);
		L.addFirst(1); // Testing General case: length >= 1
		System.out.println("Should print 1 2: " + L);
		
		System.out.println("**Testing print numbered list**");
		System.out.println("Should print: \n1. 1\n2. 2\n-----");
		L.printNumberedList();
		
		
		System.out.println("**Testing copy constructor**");
		List<Integer> LCopy = new List<Integer>(L);
		System.out.println("Should print true for being equal: " + L.equals(LCopy));
		LCopy.removeLast();
		System.out.println("Should print false for not being equal: " + L.equals(LCopy));
		
//		List<Integer> T = new List<Integer>();
//		System.out.println("**Testing addLast**");
//		T.addLast(19); // Testing Edge case: length == 0
//		System.out.println("Should print 19: " + T);
//		T.addLast(10); // Testing General case: length >= 1
//		System.out.println("Should print 19 10: " + T); 
		
		System.out.println("**Testing addIterator**");
		List<Integer> N = new List<Integer>();
		System.out.println("Should print an error message for an off end list: ");
		try {
			N.addIterator(9);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		N.addLast(2);
		N.addLast(10);
		N.pointIterator();
		N.advanceIterator();
		N.addIterator(15);
		System.out.println("Should print 2 10 15: " + N);
		N.pointIterator();
		N.advanceIterator();
		N.addIterator(20);
		System.out.println("Should print 2 10 20 15: " + N);
		
//		System.out.println("**Testing removeFirst**");
//		L.removeFirst(); // Testing General case: length >1
//		System.out.println("Should print 2: " + L);
//		L.removeFirst(); // Testing Edge case: length == 1
//		System.out.println("Should print an new Line: " + L);
//		System.out.println("Should print an error message for an empty List: ");
//		try { // place in a try-catch so program does not end when exception thrown
//			L.removeFirst(); // Testing Precondition: length == 0
//		} catch (NoSuchElementException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("\n**Testing removeLast**");
//		T.removeLast(); // Testing General case: length >1
//		System.out.println("Should print 19: " + T);
//		T.removeLast(); // Testing Edge case: length == 1
//		System.out.println("Should print an new Line: " + T);
//		System.out.println("Should print an error message for an empty List: ");
//		try { // place in a try-catch so program does not end when exception thrown
//			T.removeLast(); // Testing Precondition: length == 0
//		} catch (NoSuchElementException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("**Testing removeIterator**");
		List<Integer> N1 = new List<Integer>();
		System.out.println("Should print an error message for an off end list: ");
		try {
			N1.removeIterator();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} 
		for(int i=1;i<=5;i++) {
			N1.addLast(i);
		}
		System.out.println("Before calling removeIterator(): "
				+ "\nShould print 1 2 3 4 5: " + N1);
		N1.pointIterator();
		N1.removeIterator();
		System.out.println("After calling remove Iterator() on first node: "
				+ "\nShould print 2 3 4 5: " + N1 );
		System.out.println("Before calling removeIterator() on last node: "
				+ "\nShould print 2 3 4 5: " + N1);
		N1.pointIterator();
		for(int i=0;i<N1.getLength()-1;i++) {
			N1.advanceIterator();
		}
		N1.removeIterator();
		System.out.println("After calling remove Iterator() on last node: "
				+ "\nShould print 2 3 4 : " + N1 );
		System.out.println("Before calling removeIterator() on middle node: "
				+ "\nShould print 2 3 4 : " + N1);
		N1.pointIterator();
		N1.advanceIterator();
		N1.removeIterator();
		System.out.println("After calling remove Iterator() on middle node: "
				+ "\nShould print 2 4 : " + N1 );
		
		System.out.println("**Testing advanceIterator**");
		N1.pointIterator();
		N1.advanceIterator();
		System.out.println("Should print 4: " + N1.getIterator());
		System.out.println("Should print an error message for iterator being offEnd.");
		try {
			N1.advanceIterator();
			N1.advanceIterator();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("**Testing reverseIterator**");
		N1.pointIterator();
		N1.advanceIterator();
		N1.reverseIterator();
		System.out.println("Should print 2: " + N1.getIterator());
		System.out.println("Should print an error message for iterator being offEnd.");
		List<Integer> N2 = new List<Integer>();
		N2.addFirst(8);
		try {
			N2.pointIterator();
			N2.reverseIterator();
			N2.reverseIterator();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
//		System.out.println("\n**Testing isEmpty**");
//		List<Integer> L2 = new List<Integer>();
//		System.out.println("Should print true: " + L2.isEmpty());
//		List<Integer> T2 = new List<Integer>();
//		T2.addFirst(0);
//		System.out.println("Should print false: " + T2.isEmpty());
//
//		System.out.println("\n**Testing getLength**");
//		System.out.println("Should print 0: " + L2.getLength());
//		System.out.println("Should print 1: " + T2.getLength());
//
//		System.out.println("\n**Testing getFirst**");
//		List<Integer> L3 = new List<Integer>();
//		System.out.println("Should print an error message for an emty list: ");
//		try { // place in a try-catch so program does not end when exception thrown
//			L3.getFirst(); // Testing Precondition: length == 0
//		} catch (NoSuchElementException e) {
//			System.out.println(e.getMessage());
//		}
//		L3.addFirst(20);// Testing general case: length != 0
//		System.out.println("Should print 20: " + L3.getFirst());
//
//		System.out.println("\n**Testing getLast**");
//		List<Integer> L4 = new List<Integer>();
//		System.out.println("Should print an error message for an empty list: ");
//		try { // place in a try-catch so program does not end when exception thrown
//			L4.getLast(); // Testing Precondition: length == 0
//		} catch (NoSuchElementException e) {
//			System.out.println(e.getMessage());
//		}
//		L4.addLast(5);// Testing general case: length != 0
//		System.out.println("Should print 5: " + L4.getFirst());
		
		System.out.println("**Testing pointIterator**");
		List<Integer> L5 = new List<Integer>();
		for(int i=0;i<6;i++) {
			L5.addFirst(i);
		}
		L5.pointIterator();
		System.out.println("Should print 5: " + L5.getIterator());
		List<Integer> L6 = new List<Integer>();
		L6.pointIterator();
		System.out.println("Should print an error message for an empty list: ");
		try {
			L6.getIterator();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("**Testing getIterator**");
		L5.getIterator(); //Testing general case: iterator != null
		System.out.println("Should print 5: " + L5.getIterator());
		List<Integer> L7 = new List<Integer>();
		System.out.println("Should print an error message for an off end iterator: ");
			try {  // place in a try-catch so program does not end when exception thrown
				L7.getIterator(); //Testing precondition: iterator == null
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("**Testing offend()**");
			List<Integer> L8 = new List<Integer>();
			System.out.println("Should print true: " + L8.offEnd());
			L8.addFirst(8);
			L8.pointIterator();
			System.out.println("Should print false: " + L8.offEnd());
			
			System.out.println("**Testing equals**");
			List<Integer> L9 = new List<Integer>();
			System.out.println("Should print false: " + L9.equals(L8));
			L9.addFirst(8);
			System.out.println("Should print true: " + L9.equals(L8));		
	}
}

/*
Should print nothing (an empty list) : 

**Testing addFirst**
Should print 2: 2 

Should print 1 2: 1 2 

**Testing addLast**
Should print 19: 19 

Should print 19 10: 19 10 

**Testing removeFirst**
Should print 2: 2 

Should print an new Line: 

Should print an error message for an empty List: 
removeFirst(): Cannot remove from an empty List!

**Testing removeLast**
Should print 19: 19 

Should print an new Line: 

Should print an error message for an empty List: 
removeLast(): Cannot remove from an empty List!

**Testing isEmpty**
Should print true: true
Should print false: false

**Testing getLength**
Should print 0: 0
Should print 1: 1

**Testing getFirst**
Should print an error message for an empty list: 
getFirst: List is Empty. No data to access!
Should print 20: 20

**Testing getLast**
Should print an error message for an empty list: 
getLast: List is Empty. No data to access!
Should print 5: 5
*/

