
public class StackTest {
	
	public static void main(String[] args) {
		System.out.println("**Testing toString**\n");
		Stack<Integer> S = new Stack<Integer>();
		System.out.println("Should print empty line: " + S);
		S.push(10);
		System.out.println("Should print 10: " + S);
		System.out.println("**Testing peek**");
		System.out.println("\nShould print 10: " + S.peek());
		S.push(15);
		System.out.println("\nShould print 15: " + S.peek());
		System.out.println("\n**Testing getLength**");
		System.out.println("\nShould print 2: " + S.getLength() );
		S.pop();
		System.out.println("\nShould print 1: " + S.getLength() );
		System.out.println("\n**Testing isEmpty**");
		System.out.println("\nShould print false: " + S.isEmpty());
		S.pop();
		System.out.println("\nShould print true: " + S.isEmpty());
		System.out.println("\n**Testing equals**");
		S.push(10);
		Stack<Integer> S1 = new Stack<Integer>(S);
		System.out.println("\nShould print true: " + S.equals(S1));
		S1.pop();
		System.out.println("\nShould print false: " + S.equals(S1));
		System.out.println("\n**Testing push**");
		S1.push(20);
		System.out.println("\nShould print 20: " + S1);
		S1.push(30);
		System.out.println("Should print 30 20: " + S1);
		System.out.println("**Testing pop**");
		S1.pop();
		System.out.println("\nShould print 20: " + S1);
		S1.pop();
		System.out.println("Should print an empty line: " + S1);
		System.out.println("**Testing Copy Constructor**");
		Stack<Integer> S2 = new Stack<Integer>(S);
		System.out.println("\nShould print true: " + S.equals(S2));
		S2.pop();
		System.out.println("\nShould print false: " + S.equals(S2));
	}

}

/*
 **Testing toString**

Should print empty line: 

Should print 10: 10 

**Testing peek**

Should print 10: 10

Should print 15: 15

**Testing getLength**

Should print 2: 2

Should print 1: 1

**Testing isEmpty**

Should print false: false

Should print true: true

**Testing equals**

Should print true: true

Should print false: false

**Testing push**

Should print 20: 20 

Should print 30 20: 30 20 

**Testing pop**

Should print 20: 20 

Should print an empty line: 

**Testing Copy Constructor**

Should print true: true

Should print false: false
*/
