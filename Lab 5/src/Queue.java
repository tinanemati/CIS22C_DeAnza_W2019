import java.util.NoSuchElementException;

/**
 * Queue.java
 *
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 5
 */

public class Queue {
	private Stack<String> s1;
	private Stack<String> s2;

	/** Constructors **/

	/**
	 * Default constructor for  
	 * the Queue class
	 * 
	 */
	public Queue() {
		s1 = new Stack<String>();
		s2 = new Stack<String>();
	}

	/**
	 * Copy constructor for  
	 * the Queue class
	 * 
	 * @param q the original Queue to copy
	 */
	public Queue(Queue q) {
		if (q.isEmpty()) {
			s1 = new Stack<String>();
			s2 = new Stack<String>();
		} else {
			s1 = new Stack<String>();
			s2 = new Stack<String>(q.s2);
		}
	}

	/** Mutators **/

	/**
     * Inserts a new data to the end 
     * of the Queue
     * 
     * @param data the value to insert
     * @postcondition the new value has 
     * been added to the end of the Queue
     */
	public void enqueue(String data) {
		s2.push(data);
	}

	/**
     * Removes data from the front 
     * element in the Queue
     * 
     * @precondition length != 0
     * @throws NoSuchElementException when
     * the precondition is violated
     * @postcondition the front element has 
     * been removed
     */
	public void dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("dequeue(): " 
					+ "Queue is Empty. No data to remove!");
		} else if (getSize() == 1) {
			s2.pop();
		} else {
			while (!s2.isEmpty()) {
				s1.push(s2.peek());
				s2.pop();
			}
			s1.pop();
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
		}
	}

	/**
	 * Appends the values of a new 
	 * Queue onto the end of this Queue
	 * 
	 * @param q the Queue whose values to append
	 * @postcondition new values has been 
	 * added to the end of the Queue
	 */
	public void append(Queue q) {
		Queue q_copy = new Queue(q);
		while (q_copy.getSize() != 0) {
			s2.push(q_copy.getFront());
			q_copy.dequeue();
		}
	}

	/** Accessors **/

	/**
     * Returns the data at the front
     * of the Queue
     * 
     * @precondition length != 0
     * @return the value at the front 
     * of the queue
     * @throws NoSuchElementException when 
     * the precondition is violated
     */
	public String getFront() {
		if (isEmpty()) {
			throw new NoSuchElementException("getFront(): " 
					+ "Queue is empty. No data to return!");
		} else if (getSize() == 1) {
			return s2.peek();
		} else {
			while (!s2.isEmpty()) {
				s1.push(s2.peek());
				s2.pop();
			}
			String front = s1.peek();
			while (!s1.isEmpty()) {
				s2.push(s1.peek());
				s1.pop();
			}
			return front;
		}
	}

	/**
	 * Returns the current size 
	 * of this Queue
	 * 
	 * @return the current size
	 */
	public int getSize() {
		return s2.getLength();
	}

	/**
	 * Returns whether this Queue is 
	 * currently empty
	 * 
	 * @return whether the Queue is empty
	 */
	public boolean isEmpty() {
		return s2.isEmpty();
	}

	 /**
     * Determines whether two Queues 
     * have the data stored in the same order
     * 
     * @param o the Object to compare to this
     * @return whether o and this are equal
     */
	@Override public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		else if (!(o instanceof Queue)) {
			return false;
		} else {
			Queue q = (Queue) o;
			return q.s2.equals(this.s2) && q.s1.equals(this.s1);
		}
	}

	/** Additional Operations **/

	/**
	 * Creates a String to store the values 
	 * of the Queue, separated with spaces
	 * and ending with a new line character
	 * 
	 * @return a String of Queue values
	 */
	@Override public String toString() {
		String res = "";
		while (!s2.isEmpty()) {
			s1.push(s2.peek());
			s2.pop();
		}
		while (!s1.isEmpty()) {
			if (s1.getLength() > 1) {
				res += s1.peek() + " ";
			} else {
				res += s1.peek();
			}
			s2.push(s1.peek());
			s1.pop();
		}
		return res + "\n";
	}
}