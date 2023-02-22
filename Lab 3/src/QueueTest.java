import java.util.NoSuchElementException;

/**
 * QueueTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 3
 */

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		System.out.println("**Testing toString**");
		System.out.println("\nShould print an empty line: " + q.toString());
		q.enqueue(10);
		System.out.println("Should print 10: " + q.toString());
		q.dequeue();
		System.out.println("**Testing isEmpty**");
		System.out.println("\nShould print true: " + q.isEmpty());
		q.enqueue(5);
		System.out.println("\nShould print false: " + q.isEmpty());
		System.out.println("\n**Testing getLength**");
		System.out.println("\nShould print 1: " + q.getLength());
		Queue<Integer> q1 = new Queue<Integer>();
		System.out.println("\nShould print 0: " + q1.getLength());
		System.out.println("\n**Testing Copy Constructor**");
		Queue<Integer> q2 = new Queue<Integer>(q);
		System.out.println("\nShould print true: " + q2.equals(q));
		q2.dequeue();
		System.out.println("\nShould print false: " + q2.equals(q));
		System.out.println("\n**Testing equals**");
		System.out.println("\nShould print false: " + q2.equals(q));
		Queue<Integer> q3 = new Queue<Integer>(q);
		System.out.println("\nShould print true: " + q3.equals(q));
		System.out.println("\n**Testing getFront**");
		System.out.println("\nShould print 5: " + q.getFront());
		System.out.println("\nShould print an error message for an empty list");
		try {
			q1.getFront();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n**Testing enqueue**\n");
		System.out.println("Should print 5: " + q.toString());
		q.enqueue(2);
		System.out.println("Should print 5 2: " + q.toString());
		System.out.println("**Testing dequeue**\n");
		q.dequeue();
		System.out.println("Should print 2: " + q.getFront());
		q.dequeue();
		System.out.println("\nShould print an error message for an empty list.");
		try {
			q.dequeue();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

}
/*
**Testing toString**

Should print an empty line: 

Should print 10: 10 

**Testing isEmpty**

Should print true: true

Should print false: false

**Testing getLength**

Should print 1: 1

Should print 0: 0

**Testing Copy Constructor**

Should print true: true

Should print false: false

**Testing equals**

Should print false: false

Should print true: true

**Testing getFront**

Should print 5: 5

Should print an error message for an empty list
getFront(): List is empty.Cannot access data.

**Testing enqueue**

Should print 5: 5 

Should print 5 2: 5 2 

**Testing dequeue**

Should print 2: 2

Should print an error message for an empty list.
dequeue(): List is empty. No data to remove!

*/
