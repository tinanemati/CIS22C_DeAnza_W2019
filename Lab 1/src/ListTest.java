import java.util.NoSuchElementException;

/**
 * Tests a singly-linked list class
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */
public class ListTest {

	public static void main(String[] args) {
		List L = new List();
		System.out.println("Should print nothing (an empty list) : " + L);
		System.out.println("**Testing addFirst**");
		L.addFirst(2); // Testing Edge case: length == 0
		System.out.println("Should print 2: " + L);
		L.addFirst(1); // Testing General case: length >= 1
		System.out.println("Should print 1 2: " + L);

		List T = new List();
		System.out.println("**Testing addLast**");
		T.addLast(19); // Testing Edge case: length == 0
		System.out.println("Should print 19: " + T);
		T.addLast(10); // Testing General case: length >= 1
		System.out.println("Should print 19 10: " + T);

		System.out.println("**Testing removeFirst**");
		L.removeFirst(); // Testing General case: length >1
		System.out.println("Should print 2: " + L);
		L.removeFirst(); // Testing Edge case: length == 1
		System.out.println("Should print an new Line: " + L);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			L.removeFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n**Testing removeLast**");
		T.removeLast(); // Testing General case: length >1
		System.out.println("Should print 19: " + T);
		T.removeLast(); // Testing Edge case: length == 1
		System.out.println("Should print an new Line: " + T);
		System.out.println("Should print an error message for an empty List: ");
		try { // place in a try-catch so program does not end when exception thrown
			T.removeLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n**Testing isEmpty**");
		List L2 = new List();
		System.out.println("Should print true: " + L2.isEmpty());
		List T2 = new List();
		T2.addFirst(0);
		System.out.println("Should print false: " + T2.isEmpty());

		System.out.println("\n**Testing getLength**");
		System.out.println("Should print 0: " + L2.getLength());
		System.out.println("Should print 1: " + T2.getLength());

		System.out.println("\n**Testing getFirst**");
		List L3 = new List();
		System.out.println("Should print an error message for an emty list: ");
		try { // place in a try-catch so program does not end when exception thrown
			L3.getFirst(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		L3.addFirst(20);// Testing general case: length != 0
		System.out.println("Should print 20: " + L3.getFirst());

		System.out.println("\n**Testing getLast**");
		List L4 = new List();
		System.out.println("Should print an error message for an emty list: ");
		try { // place in a try-catch so program does not end when exception thrown
			L4.getLast(); // Testing Precondition: length == 0
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		L4.addLast(5);// Testing general case: length != 0
		System.out.println("Should print 5: " + L4.getFirst());
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
Should print an error message for an emty list: 
getFirst: List is Empty. No data to access!
Should print 20: 20

**Testing getLast**
Should print an error message for an emty list: 
getLast: List is Empty. No data to access!
Should print 5: 5
*/
