import java.util.ArrayList;

/**
* Hash.java
* @author Ryan Oliveira
* @author Tina Nemati
* CIS 22C, Lab 7
*/

public class Hash<T extends Comparable<T>> {

private int numElements;
private ArrayList<List<T>> Table;

/**
* Constructor for the Hash.java
* class. Initializes the Table to
* be sized according to value passed
* in as a parameter
* Inserts size empty Lists into the
* table. Sets numElements to 0
* @param size the table size
*/
public Hash(int size) {
	Table = new ArrayList<List<T>>(size);
	for(int i = 0;i < size;i++) {
		Table.add(new List<T>());
	}
	numElements = 0;
}

/**Accessors*/

/**
* Returns the hash value in the Table
* for a given key by taking modulus
* of the hashCode value for that key
* and the size of the table
* @param t the key
* @return the index in the Table
*/
private int hash(T t) {
	int code = t.hashCode();
	int index = code % Table.size();
    return index;
}

/**
* Counts the number of keys at this index
* @param index the index in the Table
* @precondition 0 <= index < Table.length
* @return the count of keys at this index
* @throws IndexOutOfBoundsException
*/
public int countBucket(int index) throws IndexOutOfBoundsException{
	if(index < 0 || index > Table.size()) {
		throw new IndexOutOfBoundsException("countBucket():"
				+ "Index is outside of bounds of table.");
	}
    return Table.get(index).getLength();
}

/**
* Returns total number of keys in the Table
* @return total number of keys
*/
public int getNumElements() {
    return numElements;
}

/**
* Searches for a specified key in the Table
* @param t the key to search for
* @return the index in the Table (0 to Table.length - 1)
* or -1 if t is not in the Table
*/
public int search(T t) {
	int hashCode = hash(t);
	if(Table.get(hashCode).linearSearch(t) != -1) {
		return hashCode;
	}
    return -1;
}


/**Manipulation Procedures*/

/**
* Inserts a new key in the Table
* calls the hash method to determine placement
* @param t the key to insert
*/
public void insert(T t) { 
	int bucket = hash(t);
	Table.get(bucket).addLast(t);
	numElements++;
} 


/**
* removes the key t from the Table
* calls the hash method on the key to
* determine correct placement
* has no effect if t is not in
* the Table
* @param t the key to remove
*/
public void remove(T t) {
	int hashCode = hash(t);
	int searchRes = Table.get(hashCode).linearSearch(t);
	if(searchRes != -1) {
		Table.get(hashCode).pointIterator();
		Table.get(hashCode).moveToIndex(searchRes);
		Table.get(hashCode).removeIterator();
	}
	numElements--;
}

/**Additional Methods*/

/**
* Prints all the keys at a specified
* bucket in the Table. Each key displayed
* on its own line, with a blank line 
* separating each key
* Above the keys, prints the message
* "Printing bucket #<bucket>:"
* Note that there is no <> in the output
* @param bucket the index in the Table
*/
public void printBucket(int bucket) {
	System.out.println("Printing bucket #" + bucket + ":\n");
	List<T> curBucket = Table.get(bucket);
	curBucket.pointIterator();
	while(!curBucket.offEnd()){
		System.out.println(curBucket.getIterator().toString() + "\n");
		curBucket.advanceIterator();
	}
	System.out.println();
}

/**
* Prints the first key at each bucket
* along with a count of the total keys
* with the message "+ <count> -1 more 
* at this bucket." Each bucket separated
* with two blank lines. When the bucket is 
* empty, prints the message "This bucket
* is empty." followed by two blank lines
*/
public void printTable(){
	int count = 0;
	for(List<T> bucket: Table) {
		System.out.println("Bucket: " + count);
		if(bucket.isEmpty()) {
			System.out.println("This bucket is empty\n\n");
		}else {
			System.out.println(bucket.getFirst());
			System.out.println("+ " + (bucket.getLength()-1) + " more at this bucket.\n\n");
		}
		count++;
	}
}
}