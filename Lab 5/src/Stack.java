import java.util.NoSuchElementException;

/**
 * Stack.java
 * 
 * @author Tina Nemati
 * @author Ryan Oliveira
 * CIS 22C, Lab 5
 */

public class Stack<T> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node top;

	/**** CONSTRUCTORS ****/

	/**
	 * Default constructor for the Stack class
	 * 
	 * @postcondition a new Stack object with 
	 * all fields assigned default values
	 */
	public Stack() {
		top = null;
		length = 0;
	}

	/**
	 * Copy constructor for the Stack class
	 * 
	 * @param original the Stack to copy
	 * @postcondition a new Stack object which 
	 * is an identical, but distinct,
	 * copy of original
	 */
	public Stack(Stack<T> original) {
		if(original.length == 0) {
			top = null;
			length = 0;
		}else {
			length = original.length;
			Node temp1 = original.top;
			this.top = new Node(temp1.data);
			Node temp2 = this.top;
			while(temp1.next != null) {
				temp1 = temp1.next;
				temp2.next = new Node(temp1.data);
				temp2 = temp2.next;
			}
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored at the top of the Stack
	 * 
	 * @return the value at the top of the Stack
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when the 
	 * precondition is violated
	 */
	public T peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("peek(): " + "Stack is empty, no data to return!");
		}
		return top.data;
	}

	/**
	 * Returns the length of the Stack
	 * 
	 * @return the length from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Determines whether a Stack is empty
	 * 
	 * @return whether the Stack is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**
	 * Determines whether two Stacks contain 
	 * the same values in the same order
	 * 
	 * @param o the Stack to compare to this
	 * @return whether o and this are equal
	 */
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		else if(!(o instanceof Stack)) {
			return false;
		}
		else {
			Stack<T> S = (Stack<T>) o;
			if(S.length != this.length) {
				return false;
			}
			Node temp1 = this.top;
			Node temp2 = S.top;
			while(temp1 != null) {
				if(!temp1.data.equals(temp2.data)) {
					return false;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			return true;
		}
	}

	/**** MUTATORS ****/

	/**
	 * Inserts a new value at the top of the Stack
	 * 
	 * @param data the new data to insert
	 * @postcondition a new node at the end of the Stack
	 */
	public void push(T data) {
		if (isEmpty()) {
			top = new Node(data);
		} else {
			Node N = new Node(data);
			N.next = top;
			top = N;
		}
		length++;
	}

	/**
	 * Removes the top element of the Stack
	 * 
	 * @precondition !isEmpty()
	 * @throws NoSuchElementException when 
	 * the precondition is violated
	 * @postcondition the top element has been removed
	 */
	public void pop() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("pop(): "
					+ "Stack is empty, no data to remove!");
		}
		top = top.next;
		length--;
	}

	/**** ADDITONAL OPERATIONS ****/

	/**
	 * Returns the values stored in the Stack 
	 * as a String, separated by a blank
	 * space with a new line character at the end
	 * 
	 * @return a String of Stack values
	 */
	public String toString() {
		String result = "";
		Node temp = top;
		while(temp != null) {
			result += temp.data + " ";
			temp = temp.next;
		}
		result += "\n";
		return result;
	}

}
