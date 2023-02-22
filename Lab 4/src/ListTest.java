/**
 * Test a generic doubly-linked list class
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 4
 */

import java.util.NoSuchElementException;

public class ListTest {
	
	public static void main(String[] args) {
		List<Integer> L = new List<Integer>();
		System.out.println("Should print nothing (an empty list): " + L);
		
		System.out.println("**Testing addFirst**");
		L.addFirst(2); // Testing Edge case: length == 0
		System.out.println("Should print 2: " + L);
		L.addFirst(1); // Testing General case: length >= 1
		System.out.println("Should print 1 2: " + L);

		System.out.println("**Testing print numbered list**");
		System.out.println("Should print: \n1. 1\n2. 2\n-----");
		L.printNumberedList();

		System.out.println("\n**Testing copy constructor**");
		List<Integer> C = new List<Integer>();
		List<Integer> C_copy = new List<Integer>(C);
		System.out.println("Should print nothing (an empty list): " + C_copy); // Testing Edge case: length == 0
		C.addFirst(2);
		System.out.println("Should print false for not equal lists: " + C.equals(C_copy)); // Testing for deep copy
		List<Integer> LCopy = new List<Integer>(L);
		System.out.println("\nShould print 1 2: " + L); // Testing General Case: length >= 1

		List<Integer> T = new List<Integer>();
		System.out.println("**Testing addLast**");
		T.addLast(19); // Testing Edge case: length == 0
		System.out.println("Should print 19: " + T);
		T.addLast(10); // Testing General case: length >= 1
		System.out.println("Should print 19 10: " + T);

		System.out.println("**Testing addIterator**");
		List<Integer> N = new List<Integer>();
		System.out.println("Should print an error message for an off end list: "); 
		try { // place in a try-catch so program does not end when exception thrown
			N.addIterator(9); // Testing Precondition: iterator == null
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		N.addLast(2);
		N.addLast(10);
		N.pointIterator();
		N.advanceIterator();
		N.addIterator(15); // Testing Edge case: iterator == last
		System.out.println("\nShould print 2 10 15: " + N); 
		N.pointIterator();
		N.advanceIterator();
		N.addIterator(20); // Testing General case: iterator != null
		System.out.println("Should print 2 10 20 15: " + N);

		System.out.println("**Testing removeFirst**");
		L.removeFirst(); // Testing General case: length > 1
		System.out.println("Should print 2: " + L);
		L.removeFirst(); // Testing Edge case: length == 1
		System.out.println("Should print a new Line: " + L);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			L.removeFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n**Testing removeLast**");
		T.removeLast(); // Testing General case: length > 1
		System.out.println("Should print 19: " + T);
		T.removeLast(); // Testing Edge case: length == 1
		System.out.println("Should print a new Line: " + T);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			T.removeLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n**Testing removeIterator**");
		List<Integer> N1 = new List<Integer>();
		System.out.println("Should print an error message for iterator being off end: ");
		try { // place in a try-catch so program does not end when exception thrown
			N1.removeIterator(); // Testing Precondition: iterator == null
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		for (int i = 1; i <= 5; i++) {
			N1.addLast(i);
		}
		System.out.println("\nBefore calling removeIterator(): " + "\nShould print 1 2 3 4 5: " + N1);
		N1.pointIterator();
		N1.removeIterator(); // Testing Edge case #1: iterator == first
		System.out.println("After calling remove Iterator() on first node: " + "\nShould print 2 3 4 5: " + N1);
		System.out.println("Before calling removeIterator() on last node: " + "\nShould print 2 3 4 5: " + N1);
		N1.pointIterator();
		for (int i = 0; i < N1.getLength() - 1; i++) {
			N1.advanceIterator();
		}
		N1.removeIterator(); // Testing Edge case #2: iterator == last
		System.out.println("After calling remove Iterator() on last node: " + "\nShould print 2 3 4 : " + N1);
		System.out.println("Before calling removeIterator() on middle node: " + "\nShould print 2 3 4 : " + N1);
		N1.pointIterator();
		N1.advanceIterator();
		N1.removeIterator(); // Testing General case: iterator != null
		System.out.println("After calling remove Iterator() on middle node: " + "\nShould print 2 4 : " + N1);

		System.out.println("**Testing advanceIterator**");
		N1.pointIterator();
		N1.advanceIterator(); // Testing General case: !offEnd()
		System.out.println("Should print 4: " + N1.getIterator());
		System.out.println("\nShould print an error message for iterator being off end:");
		try { // place in a try-catch so program does not end when exception thrown
			N1.advanceIterator();
			N1.advanceIterator(); // Testing Precondition: offEnd()
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n**Testing reverseIterator**");
		N1.pointIterator();
		N1.advanceIterator();
		N1.reverseIterator(); // Testing General case: !offEnd()
		System.out.println("Should print 2: " + N1.getIterator());
		System.out.println("\nShould print an error message for iterator being off end:");
		List<Integer> N2 = new List<Integer>();
		N2.addFirst(8);
		try { // place in a try-catch so program does not end when exception thrown
			N2.pointIterator();
			N2.reverseIterator();
			N2.reverseIterator(); // Testing Precondition: offEnd()
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n**Testing isEmpty**");
		List<Integer> L2 = new List<Integer>();
		System.out.println("Should print true: " + L2.isEmpty());
		List<Integer> T2 = new List<Integer>();
		T2.addFirst(0);
		System.out.println("\nShould print false: " + T2.isEmpty());

		System.out.println("\n**Testing getLength**");
		System.out.println("Should print 0: " + L2.getLength()); 
		System.out.println("\nShould print 1: " + T2.getLength()); 
		
		System.out.println("\n**Testing getFirst**");
		List<Integer> L3 = new List<Integer>();
		System.out.println("Should print an error message for an empty list: ");
		try { // place in a try-catch so program does not end when exception thrown
			L3.getFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		L3.addFirst(20);// Testing General case: length != 0
		System.out.println("\nShould print 20: " + L3.getFirst());

		System.out.println("\n**Testing getLast**");
		List<Integer> L4 = new List<Integer>();
		System.out.println("Should print an error message for an empty list: ");
		try { // place in a try-catch so program does not end when exception thrown
			L4.getLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		L4.addLast(5); // Testing General case: length != 0
		System.out.println("\nShould print 5: " + L4.getFirst());

		System.out.println("\n**Testing pointIterator**");
		List<Integer> L5 = new List<Integer>();
		for (int i = 0; i < 6; i++) {
			L5.addFirst(i);
		}
		L5.pointIterator(); // Testing General case: iterator != null
		System.out.println("Should print 5: " + L5.getIterator());
		List<Integer> L6 = new List<Integer>();
		L6.pointIterator(); // Testing Precondition: iterator == null
		System.out.println("\nShould print an error message for an empty list: ");
		try { // place in a try-catch so program does not end when exception thrown
			L6.getIterator(); // Testing Precondition: iterator == null
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n**Testing getIterator**");
		L5.getIterator(); // Testing General case: iterator != null
		System.out.println("Should print 5: " + L5.getIterator());
		List<Integer> L7 = new List<Integer>();
		System.out.println("\nShould print an error message for iterator being off end: ");
		try { // place in a try-catch so program does not end when exception thrown
			L7.getIterator(); // Testing Precondition: iterator == null
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n**Testing offend**");
		List<Integer> L8 = new List<Integer>();
		System.out.println("Should print true: " + L8.offEnd());
		L8.addFirst(8);
		L8.pointIterator();
		System.out.println("\nShould print false: " + L8.offEnd());

		System.out.println("\n**Testing equals**");
		List<Integer> L9 = new List<Integer>();
		System.out.println("Should print false: " + L9.equals(L8)); 
		L9.addFirst(8);
		System.out.println("\nShould print true: " + L9.equals(L8)); 
		
		System.out.println("\n**Testing printReverse**");
		List<Integer> L10 = new List<Integer>();
		System.out.print("Should print nothing (an empty list): "); 
		L10.printReverse(); // Testing Edge case: length == 0
		for(int i = 1; i < 6; i++) {
			L10.addLast(i);
		}
		System.out.print("\nShould print 5 4 3 2 1: ");
		L10.printReverse(); // Testing General case: length >= 1
		
		System.out.println("\n**Testing isSorted**");
		System.out.println("Should print true: " + L10.isSorted()); 
		L10.addLast(0);
		System.out.println("\nShould print false: " + L10.isSorted()); 
		
		System.out.println("\n**Testing moveToIndex**");
		L10.moveToIndex(6); // Testing Edge case #1: moving to the last index
		System.out.println("Should print 0: " + L10.getIterator());
		L10.moveToIndex(1); // Testing Edge case #2: moving to the first index
		System.out.println("\nShould print 1: " + L10.getIterator());
		L10.moveToIndex(3); // Testing General case: moving to the middle index
		System.out.println("\nShould print 3: " + L10.getIterator());
		System.out.println("\nShould print an error message for index out of bound: ");
		try { // place in a try-catch so program does not end when exception thrown
			L10.moveToIndex(10); // Testing Precondition: index > length 
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		L10.removeIterator();
		System.out.println("\n**Testing getIndex**");
		System.out.println("Should print an error message for an off end iterator: ");
		try { // place in a try-catch so program does not end when exception thrown
			L10.getIndex(); // Testing Precondition: iterator == null
		}catch(NullPointerException e ) {
			System.out.println(e.getMessage());
		}
		L10.pointIterator();
		System.out.println("\nShould print 1: " + L10.getIndex()); // Testing General case: iterator != null
		System.out.println("\n**Testing linearSearch**");
		System.out.println("Should print 1: " + L10.linearSearch(1)); // Testing Edge case #1: Searching for the first value
		System.out.println("\nShould print 5: " + L10.linearSearch(0)); // Testing Edge case #2: Searching for the last value
		System.out.println("\nShould print 3: " + L10.linearSearch(4)); // Testing General case: Searching for a value in the middle
		System.out.println("\nShould print -1: " + L10.linearSearch(10)); // Testing case when value not found
		List<Integer> L11 = new List<Integer>();
		System.out.println("\nShould print -1: " + L11.linearSearch(8)); // Testing case when the list is empty
		
		System.out.println("\n**Testing binarySearch**");
		L11.addFirst(2);
		L11.addLast(3);
		L11.addLast(6);
		System.out.println("Should print 1: " + L11.binarySearch(2)); // Testing Edge case #1: Searching for the first element
		System.out.println("\nShould print 3: " + L11.binarySearch(6)); // Testing Edge case #2: Searching for the last element
		System.out.println("\nShould print 2: " + L11.binarySearch(3)); // Testing General case: isSorted()
		System.out.println("\nShould print -1: " + L11.binarySearch(5)); // Testing case when value not found
		L11.addLast(1);
		System.out.println("\nShould print an error message for an unsorted list: ");
		try { // place in a try-catch so program does not end when exception thrown
			L11.binarySearch(4); // Testing Precondition: !isSorted()
		} catch (IllegalStateException e){
			System.out.print(e.getMessage());
		}
		
	}
}

/*
Should print nothing (an empty list): 

**Testing addFirst**
Should print 2: 2 

Should print 1 2: 1 2 

**Testing print numbered list**
Should print: 
1. 1
2. 2
-----
1. 1
2. 2

**Testing copy constructor**
Should print nothing (an empty list): 

Should print false for not equal lists: false

Should print 1 2: 1 2 

**Testing addLast**
Should print 19: 19 

Should print 19 10: 19 10 

**Testing addIterator**
Should print an error message for an off end list: 
addIterator(): Iterator is off end. Cannot add data!

Should print 2 10 15: 2 10 15 

Should print 2 10 20 15: 2 10 20 15 

**Testing removeFirst**
Should print 2: 2 

Should print a new Line: 

Should print an error message for an empty List: 
removeFirst(): Cannot remove from an empty List!

**Testing removeLast**
Should print 19: 19 

Should print a new Line: 

Should print an error message for an empty List: 
removeLast(): Cannot remove from an empty List!

**Testing removeIterator**
Should print an error message for iterator being off end: 
removeIterator(): Iterator is off end. Cannot remove data!

Before calling removeIterator(): 
Should print 1 2 3 4 5: 1 2 3 4 5 

After calling remove Iterator() on first node: 
Should print 2 3 4 5: 2 3 4 5 

Before calling removeIterator() on last node: 
Should print 2 3 4 5: 2 3 4 5 

After calling remove Iterator() on last node: 
Should print 2 3 4 : 2 3 4 

Before calling removeIterator() on middle node: 
Should print 2 3 4 : 2 3 4 

After calling remove Iterator() on middle node: 
Should print 2 4 : 2 4 

**Testing advanceIterator**
Should print 4: 4

Should print an error message for iterator being off end:
advanceIterator(): Iterator is off end. Cannot advance iterator!

**Testing reverseIterator**
Should print 2: 2

Should print an error message for iterator being off end:
reverseIterator(): Iterator is off end. Cannot reverse iterator!

**Testing isEmpty**
Should print true: true

Should print false: false

**Testing getLength**
Should print 0: 0

Should print 1: 1

**Testing getFirst**
Should print an error message for an empty list: 
getFirst(): List is Empty. No data to return!

Should print 20: 20

**Testing getLast**
Should print an error message for an empty list: 
getLast(): List is Empty. No data to return!

Should print 5: 5

**Testing pointIterator**
Should print 5: 5

Should print an error message for an empty list: 
getIterator(): Iterator is off end. Cannot return the data!

**Testing getIterator**
Should print 5: 5

Should print an error message for iterator being off end: 
getIterator(): Iterator is off end. Cannot return the data!

**Testing offend**
Should print true: true

Should print false: false

**Testing equals**
Should print false: false

Should print true: true

**Testing printReverse**
Should print nothing (an empty list): 

Should print 5 4 3 2 1: 5 4 3 2 1 

**Testing isSorted**
Should print true: true

Should print false: false

**Testing moveToIndex**
Should print 0: 0

Should print 1: 1

Should print 3: 3

Should print an error message for index out of bound: 
moveToIndex(): Index is not in range. Cannot move the iterator to specified index!

**Testing getIndex**
Should print an error message for an off end iterator: 
getIndex(): Iterator is off end. Cannot return the index!

Should print 1: 1

**Testing linearSearch**
Should print 1: 1

Should print 5: 5

Should print 3: 3

Should print -1: -1

Should print -1: -1

**Testing binarySearch**
Should print 1: 1

Should print 3: 3

Should print 2: 2

Should print -1: -1

Should print an error message for an unsorted list: 
binarySearch(): List is not sorted. Cannot begin the search!
*/
