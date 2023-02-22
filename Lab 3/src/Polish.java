import java.util.Scanner;

/**
 * Polish.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati 
 * CIS 22C, Lab 3
 */

public class Polish {
	/**
	 * Evaluate the value of an arithmetic expression 
	 * in Polish Notation
	 * 
	 * @param equation the user's input equation
	 * @return the integer value of the expression
	 */
	public static int evaluate(String[] equation) {
		Stack<String> s = new Stack<String>();
		int res = 0;

		for (int i = equation.length - 1; i > -1; i--) {
			String curVal = equation[i];
			if (!"+-*/".contains(curVal)) {
				s.push(curVal);
			} else {
				int a = Integer.parseInt(s.peek());
				s.pop();
				int b = Integer.parseInt(s.peek());
				s.pop();
				switch (curVal) {
				case "+":
					s.push(String.valueOf(a + b));
					break;
				case "-":
					s.push(String.valueOf(a - b));
					break;
				case "*":
					s.push(String.valueOf(a * b));
					break;
				case "/":
					s.push(String.valueOf(a / b));
					break;
				}
			}
		}
		res = Integer.parseInt(s.peek());
		return res;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome!");
		boolean flag = true;
		while (flag) {
			System.out.print("\nPlease enter an equation in Polish Notation or \"q\" to quit: ");
			String[] equation = input.nextLine().split(" ");
			if (equation[0].matches("(?i)Q")) {
				flag = false;
				System.out.print("\nGoodbye!");
			} else {
				System.out.println("The answer is: " + evaluate(equation));
			}
		}
		input.close();
	}
}
