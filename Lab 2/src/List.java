
/**
 * Defines the a generic doubly-linked list class
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 2
 */

import java.util.NoSuchElementException;

public class List<T> {
	private class Node {
		private T data;
		private Node next;
		private Node prev;

		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	private int length;
	private Node first;
	private Node last;
	private Node iterator;
	

	/**** CONSTRUCTOR ****/

	/**
	 * Instantiates a new List with default values
	 * 
	 * @postcondition New list with default values is created
	 */
	public List() {
		first = null;
		last = null;
		iterator = null;
		length = 0;
	}
	
	/**
	 * Instantiates a new List by copying another List
	 * @param original the List to make a copy of
	 * @postcondition a new List object, which is an identical
	 * but separate copy of the List original
	 */
	
	public List(List original) {
		if (original.length == 0) {
			length = 0;
			first = null;
			last = null;
			iterator = null;
		}else {
			Node temp = original.first;
			while (temp != null) {
				addLast(temp.data);
				temp = temp.next;
			}
			iterator = null;
		}
	}

	/**** ACCESSORS ****/

	/**
	 * Returns the value stored in the first node
	 * 
	 * @precondition List is not empty
	 * @return the integer value stored at node first
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getFirst() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException("getFirst: List is Empty. No data to access!");
		}
		return first.data;
	}
	/**
	 * Return the element currently pointed 
	 * at by the iterator
	 * @precondition Iterator is not null
	 * @return the element pointed by the iterator
	 * @throws NullPointerException if the precondition is violated
	 */
	public T getIterator() throws NullPointerException {
		if (iterator == null) {
			throw new NullPointerException("getIterator(): "
					+ "iterator is off end. Cannot access data.");
		} else {
			return iterator.data;
		}
	}

	/**
	 * Returns the value stored in the last node
	 * 
	 * @precondition List is not empty
	 * @return the integer value stored in the node last
	 * @throws NoSuchElementException when precondition is violated
	 */
	public T getLast() throws NoSuchElementException {
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
	
	/**
	 * returns whether the iterator is off the end of the list
	 * @return whether iterator is null
	 */
	public boolean offEnd() {
		return iterator == null;
	}
	/**
	 * Returns whether the Lists have the same data
	 * in the same order
	 * @param L the List to compare to this List
	 * @return whether the two lists are equals
	 */
	@Override public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof List)) {
			return false;
		} else {
			List L = (List) o;
			if (this.length != L.length) {
				return false;
			} else {
			Node temp1 = this.first;
			Node temp2 = L.first;
			while (temp1 != null) {
				if (temp1.data != temp2.data) {
					return false;
				}
				temp1 = temp1.next;
				temp2 = temp2.next;
			}
			return true;
		}
		}
	}

	/**** MUTATORS ****/

	/**
	 * Creates a new first element
	 * 
	 * @param data the data to insert at the front of the list
	 * @postcondition Value is added at the beginning of the list
	 */
	public void addFirst(T data) {
		Node p = new Node(data);
		if (length == 0) {
			first = last = p;
		} else {
			p.next = first;
			first.prev = p;
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
	public void addLast(T data) {
		Node p = new Node(data);
		if (this.isEmpty()) {
			first = last = p;
		} else {
			p.next = null;
			last.next = p;
			p.prev = last;
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
			first.prev = null;
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
			last = last.prev;
			last.next = null;
		
		}
		
		length --;
	}
	
	/**
	 * Moves iterator to beginning of list
	 * @postcondition iterator points to beginning of list
	 */
	public void pointIterator() {
		iterator = first;
	}
	
	/**
	 * inserts element after the node currently pointed 
	 * to by iterator
	 * @param data Element to be added to list by iterator
	 * @precondition iterator != null
	 * @postcondition element is inserted after element 
	 * pointed to by iterator
	 * @throws NullPointerException if precondition is violated
	 */
	public void addIterator(T data) {
		if(offEnd()) {
			throw new NullPointerException("addIterator():"
					+ "Iterator is offEnd, cannot add data.");
		}
		else if(iterator == last){
			addLast(data);
		}
		else {
			Node N = new Node(data);
			N.next = iterator.next;
			N.prev = iterator.prev;
			iterator.next = N;
			length++;
		}
		
	}
	
	/**
	 * Removes the node pointed to by the
	 * iterator
	 * @precondition iterator != null
	 * @postcondition iterator == null
	 * @throws NullPointerException if precondition is violated
	 */
	public void removeIterator() throws NullPointerException {
		if(iterator == null) {
			throw new NullPointerException("removeIterator(): "
					+ "Iterator is offEnd, no data to remove.");
		}
		else if (iterator == first){
			removeFirst();
		}
		else if(iterator == last) {
			removeLast();
		}
		else {
			iterator.prev.next = iterator.next;
			iterator.next.prev = iterator.prev;
			length--;
		}
		iterator = null;
	}
	/**
	 * Moves the iterator up by one node
	 * @precondition iterator != null
	 * @postcondition iterator is moved up by one node
	 * @throws NullPointerException when the precondition is violated
	 */
	public void advanceIterator() throws NullPointerException {
		if (offEnd()) {
			throw new NullPointerException ("advanceIterator(): "
					+ "iterator is off end. Cannot access data.");
		} else {
			iterator = iterator.next;
		}
	}
	/**
	 * Moves the iterator down by one node
	 * @precondition iterator != null
	 * @postcondition iterator is moved down by one node
	 * @throws NullPointerException when the precondition is violated
	 */
	public void reverseIterator() throws NullPointerException {
		if (offEnd()) {
			throw new NullPointerException ("reverseIterator(): "
					+ "iterator is off end. Cannot access data.");
		} else {
			iterator = iterator.prev;
		}
	}

	/**** ADDITIONAL OPERATIONS ****/

	/**
	 * List with each value separated by a blank space 
	 *  At the end of the List a new line
	 * 
	 * @return the List as a String for display
	 */
	@Override public String toString() {
		String res = "";
		pointIterator();
		while (!offEnd()) {
			res += iterator.data + " ";
			advanceIterator();
		}
		res += "\n";
		return res;
	}
	/**
	 * Prints the contents of the linked list to the screen
	 * in the formatted #. <element> followed by a new line
	 * 
	 */
	public void printNumberedList() {
		pointIterator();
		int i = 1;
		while (!offEnd()) {
			System.out.println(i + ". " + iterator.data );
			advanceIterator();
			i++;
		}
	}

}
