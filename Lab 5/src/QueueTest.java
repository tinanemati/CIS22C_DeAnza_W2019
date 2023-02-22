import java.util.NoSuchElementException;

/**
 * QueueTest.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */

public class QueueTest {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println("**Testing enqueue()**");
        q.enqueue("1");
        System.out.println("Should print 1: " + q);
        q.enqueue("2");
        System.out.println("Should print 1 2: " + q);
        q.enqueue("3");
        System.out.println("Should print 1 2 3: " + q);
        
        System.out.println("**Testing dequeue()**");
        q.dequeue();
        System.out.println("Should print 2 3: " + q);
        q.dequeue();
        System.out.println("Should print 3: " + q);
        q.dequeue();
        System.out.println("Should print nothing (an empty line): " + q);
        System.out.print("Should print an error message for an empty queue: ");
        try {
        	q.dequeue();
        } catch (NoSuchElementException e) {
        	System.out.println("\n" + e.getMessage());
        }
        System.out.println("\n**Testing isEmpty()**");
        Queue q2 = new Queue();
        System.out.println("Should print true: " + q2.isEmpty());
        q2.enqueue("A");
        System.out.println("\nShould print false: " + q2.isEmpty());
        
        System.out.println("\n**Testing append()**");
        q.enqueue("10");
        q.enqueue("20");
        q2.enqueue("B");
        q2.enqueue("C");
        q2.enqueue("D");
        q.append(q2);
        System.out.print("Should print 10 20 A B C D: " + q);
        q2.append(q);
        System.out.println("\nShould print A B C D 10 20 A B C D: " + q2);
        
        System.out.println("**Testing getFront()**");
        System.out.println("Should print A: " + q2.getFront());
        System.out.println("\nShould print 10: " + q.getFront());
        q.dequeue();
        q.dequeue();
        Queue q1 = new Queue();
        System.out.println("\nShould print an error message for an empty queue: ");
        try {
        	q1.getFront();
        } catch (NoSuchElementException e) {
        	System.out.println(e.getMessage());
        }
        System.out.println("\n**Testing getSize()**");
        System.out.println("Should print 4: " + q.getSize());
        System.out.println("\nShould print 10: " + q2.getSize());
        
        System.out.println("\n**Testing equals()**");
        System.out.println("Should print true: " + q2.equals(q2));
        System.out.println("\nShould print false: " + q.equals(q2));
        Queue q3 = new Queue();
        System.out.println("\nShould print false: " + q2.equals(q3));
        
        System.out.println("\n**Testing Copy Constructor**");
        Queue q4 = new Queue(q);
        System.out.print("Should print A B C D: " + q4);
        q4.enqueue("E");
        q4.enqueue("F");
        Queue q5 = new Queue(q4);
        System.out.println("\nShould print A B C D E F: " + q5);
        
        System.out.println("Testing for Deep Copy:");
        System.out.print("Should print A B C D E F: " + q4);
        System.out.println("\nShould print A B C D: " + q);
        
        
    }
}
/*
**Testing enqueue()**
Should print 1: 1

Should print 1 2: 1 2

Should print 1 2 3: 1 2 3

**Testing dequeue()**
Should print 2 3: 2 3

Should print 3: 3

Should print nothing (an empty line): 

Should print an error message for an empty queue: 
dequeue(): Queue is Empty. No data to remove!

**Testing isEmpty()**
Should print true: true

Should print false: false

**Testing append()**
Should print 10 20 A B C D: 10 20 A B C D

Should print A B C D 10 20 A B C D: A B C D 10 20 A B C D

**Testing getFront()**
Should print A: A

Should print 10: 10

Should print an error message for an empty queue: 
getFront(): Queue is empty. No data to return!

**Testing getSize()**
Should print 4: 4

Should print 10: 10

**Testing equals()**
Should print true: true

Should print false: false

Should print false: false

**Testing Copy Constructor**
Should print A B C D: A B C D

Should print A B C D E F: A B C D E F

Testing for Deep Copy:
Should print A B C D E F: A B C D E F

Should print A B C D: A B C D

*/