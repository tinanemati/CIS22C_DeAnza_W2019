import java.util.NoSuchElementException;

/**
 * Defines the a singly-linked list class
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 1
 */

public class List {
	private class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private int length;
	private Node first;
	private Node last;

	/**** CONSTRUCTOR ****/

	/**
	 * Instantiates a new List with default values
	 * 
	 * @postcondition New list with default values is created
	 */
	public List() {
		first = null;
		last = null;
		length = 0;
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition List is not empty
	 * @return the integer value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public int getFirst() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("getFirst: List is Empty. No data to access!");
		}
		return first.data;
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition List is not empty
	 * @return the integer value stored in the node last
	 * @throws NoSuchElementException when precondition is violated
	 */
	public int getLast() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("getLast: List is Empty. No data to access!");
		}
		return last.data;
	}

	/**
	 * Returns the current length of the list
	 * 
	 * @return the length of the list from 0 to n
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Returns whether the list is currently empty
	 * 
	 * @return whether the list is empty
	 */
	public boolean isEmpty() {
		return length == 0;
	}

	/**** MUTATORS ****/

	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the list
	 * @postcondition Value is added at the beginning of the list
	 */
	public void addFirst(int data) {
		Node p = new Node(data);
		if (length == 0) {
			first = last = p;
		} else {
			p.next = first;
			first = p;
		}
		length++;
	}

	/**
	 * Creates a new last element
	 * 
	 * @param data the data to insert at the end of the list
	 * @postcondition Value is added at end of the list
	 */
	public void addLast(int data) {
		Node p = new Node(data);
		if (this.isEmpty()) {
			first = last = p;
		} else {
			p.next = null;
			last.next = p;
			last = p;
		}
		length++;
	}

	/**
	 * removes the element at the front of the list
	 * 
	 * @precondition List is not empty
	 * @postcondition First value is removed from the list
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeFirst() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} else {
			first = first.next;
		}
		length--;
	}

	/**
	 * removes the element at the end of the list
	 * 
	 * @precondition List is not empty
	 * @postcondition Last value is removed from the list
	 * @throws NoSuchElementException when precondition is violated
	 */
	public void removeLast() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
		} else if (length == 1) {
			first = last = null;
		} else {
			Node p = first;
			while (p.next.next != null) {
				p = p.next;
			}
			last = p;
			p.next = null;
		
		}
		
		length --;
	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * List with each value separated by a blank space At the end of the List a new
	 * line
	 * 
	 * @return the List as a String for display
	 */
	@Override
	public String toString() {
		String res = "";
		Node p = first;
		while (p != null) {
			res += p.data + " ";
			p = p.next;
		}
		res += "\n";
		return res;
	}

}
