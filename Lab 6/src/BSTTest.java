import java.util.NoSuchElementException;

/**
 * BSTTest.java
 * 
 * @author parrishj
 * CIS 22C, Lab 6
 */
public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> intBst = new BST<Integer>();
        BST<Double> doubleBst = new BST<Double>();
        BST<Character> charBst = new BST<Character>();
       

        System.out.println("**Integer BST Tests**\n");
        System.out.println("Should be empty (true): " + intBst.isEmpty());
        System.out.println("Size of an empty tree (0): " + intBst.getSize());
        System.out.println("Height of an empty tree, i.e. root is null (-1): " + intBst.getHeight());
        intBst.insert(10);
        System.out.println("Inserting 10. 10 should be root: " + intBst.getRoot());
        System.out.println("Inserting 22, 12, 41, 17, 68...");
        intBst.insert(22);
        intBst.insert(12);
        intBst.insert(41);
        intBst.insert(17);
        intBst.insert(68);
        System.out.println("InOrderPrint: Should print out 10 12 17 22 41 68:");
        intBst.inOrderPrint();
        System.out.println("PreOrderPrint: Should print out 10 22 12 17 41 68:");
        intBst.preOrderPrint();
        System.out.println("PostOrderPrint: Should print out 17 12 68 41 22 10:");
        intBst.postOrderPrint();
       
        System.out.println("Should not be empty (false); " + intBst.isEmpty());
        System.out.println("10 should still be root: " + intBst.getRoot());
        System.out.println("Minimum should be 10: " + intBst.findMin());
        System.out.println("Maximum should be 68: " + intBst.findMax());
        System.out.println("Size should be 6: " + intBst.getSize());
        System.out.println("Height should be 3: " + intBst.getHeight());
        System.out.println("Searching for 20 (false): " + intBst.search(20));
        System.out.println("Searching for 17 (true): " + intBst.search(17));
        System.out.println("Removing 17...");
        intBst.remove(17);
        intBst.inOrderPrint();
        System.out.println("Searching for 17 (false): " + intBst.search(17));
        System.out.println("InOrderPrint: Should print out 10 12 22 41 68:");
        intBst.inOrderPrint();
       
        System.out.println( "Copying the tree...");
        BST<Integer> intBstCopy = new BST<Integer>(intBst); //copying intBst
        System.out.println("InOrderPrint: Copy should print out 10 12 22 41 68:");
        intBstCopy.inOrderPrint();
        System.out.println("Two copies are equal (true): " + intBstCopy.equals(intBst));
        System.out.println("Testing for deep copy...Removing 10 from copy...");
        intBstCopy.remove(10);
        System.out.println("InOrderPrint: Copy should print out 12 22 41 68:");
        intBstCopy.inOrderPrint();
        System.out.println("InOrderPrint: Original should print out 10 12 22 41 68:");
        intBst.inOrderPrint();
        System.out.println("Copy size (4): " + intBstCopy.getSize());
        System.out.println("Original size (5): " + intBst.getSize());
        System.out.println("Two copies are equal (false): " + intBstCopy.equals(intBst));
       
        System.out.println("\n\n**Character BST Tests**\n");
        System.out.println("Inserting D, A, C, S, B, P...");
        charBst.insert('D');
        charBst.insert('A');
        charBst.insert('C');
        charBst.insert('S');
        charBst.insert('B');
        charBst.insert('P');
        charBst.insert('Z');
       
        System.out.println("InOrderPrint: Should print out A B C D P S Z:");
        charBst.inOrderPrint();
        System.out.println("PreOrderPrint: Should print out D A C B S P Z:");
        charBst.preOrderPrint();
        System.out.println("PostOrderPrint: Should print out B C A P Z S D:");
        charBst.postOrderPrint();
        System.out.println("Should not be empty (false); " + charBst.isEmpty());
        System.out.println("Root should be D: " + charBst.getRoot());
        System.out.println("Minimum should be A: " + charBst.findMin());
        System.out.println("Maximum should be Z: " + charBst.findMax());
        System.out.println("Size should be 7: " + charBst.getSize());
        System.out.println("Height should be 3: " + charBst.getHeight());
        System.out.println("Searching for Z (true): " + charBst.search('Z'));
        System.out.println("Searching for D (true): " + charBst.search('D'));
        System.out.println("Searching for Q (false): " + charBst.search('Q'));
        System.out.println("Checking 3 cases of remove....");
        System.out.print("Removing Z (easy case): ");
        charBst.remove('Z');
        charBst.inOrderPrint();
        System.out.print("Removing C (medium case): ");
        charBst.remove('C');
        charBst.inOrderPrint();
        System.out.print("Removing D (hard case): ");
        charBst.remove('D');
        charBst.inOrderPrint();
       
        System.out.println( "Copying the tree...");
        BST<Character> charBstCopy = new BST<Character>(charBst); //copying intBst
        System.out.println("InOrderPrint: Copy should print out A B P S:");
        charBstCopy.inOrderPrint();
        System.out.println("Testing for deep copy...Inserting Q in the copy...");
        charBstCopy.insert('Q');
        System.out.println("InOrderPrint: Copy should print out A B P Q S:");
        charBstCopy.inOrderPrint();
        System.out.println("InOrderPrint: Original should print out A B P S:");
        charBst.inOrderPrint();
        System.out.println("Copy size (5): " + charBstCopy.getSize());
        System.out.println("Original size (4): " + charBst.getSize());
       
        System.out.println("\n\n**Testing error messages**\n");
       
        try {
            System.out.println("Error for getRoot. Tree is empty.");
            doubleBst.getRoot();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
        try {
            System.out.println("Error for remove. Element not found.");
            charBstCopy.remove('Z');
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
        try {
            System.out.println("Error for remove. Tree is empty.");
            doubleBst.remove(3.5);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
        try {
            System.out.println("Error for findMin. Tree is empty.");
            doubleBst.findMin();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
        try {
            System.out.println("Error for findMax. Tree is empty.");
            doubleBst.findMax();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
       
    }

}