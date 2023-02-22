/**
 * Scheduler.java
 * 
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 2
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scheduler {
	
	/**
	 * 
	 * @param Schedule user List schedule
	 * @param input input scanner for user event
	 */
	public static void addEvent(List<String> Schedule, Scanner input) {
		System.out.print("\nPlease Enter an event: ");
		String event = input.nextLine();
		if (Schedule.isEmpty()) {
			Schedule.addFirst(event);
			System.out.println("\nYour Current Schedule: \n");
			Schedule.printNumberedList();
			System.out.println();
		} else {
			System.out.println("\nYou just added the following event to your schedule: " + event);
			Schedule.addFirst(event);
			System.out.println("\nYour Current Schedule: \n");
			Schedule.printNumberedList();
			System.out.println();
			System.out.print("Would you like to move this event up in your schedule (Y/N) : ");
			String mEvent = input.next();
			if (mEvent.equalsIgnoreCase("Y")) {
				moveEvent(Schedule, event, input);
			}
		}
	}

	/**
	 * Shifts user event by user given places
	 * 
	 * @param Schedule user List schedule
	 * @param event  event to shift
	 */
	public static void moveEvent(List<String> Schedule, String event, Scanner input) {
		boolean loop = true;
		while (loop) {
			System.out.print("Enter the number of places: ");
			try {
				int places = input.nextInt();
				Schedule.pointIterator();
				for (int i = 0; i < places; i++) {
					Schedule.advanceIterator();
				}
				Schedule.addIterator(event);
				Schedule.removeFirst();
				System.out.println("\nYour Current Schedule: \n");
				Schedule.printNumberedList();
				System.out.println();
				loop = false;

			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Sorry that input is invalid!\n");
			} catch (NullPointerException e) {
				System.out.println("Sorry that input is invalid!\n");
			}
		}
	}
	
	/**
	 * Removes user event from list
	 * @param Schedule user list schedule
	 * @param input input scanner for user choice
	 */
	
	public static void removeEvent(List<String> Schedule, Scanner input) {
		boolean loop = true;
		while(loop) {
			System.out.print("Enter the number of the event to remove: ");
			try {
				int place = input.nextInt();
				Schedule.pointIterator();
				for(int i=0;i<place-1;i++) {
					Schedule.advanceIterator();
				}
				System.out.println("\nRemoving: " + Schedule.getIterator() + "\n");
				input.nextLine();
				Schedule.removeIterator();
				if(Schedule.getLength() == 0) {
					System.out.println("You have no upcoming events!\n");
				}else {
					System.out.println("Your Current Schedule: \n");
					Schedule.printNumberedList();
					System.out.println();
				}
				loop = false;
			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Sorry that input is invalid!");
			} catch (NullPointerException e) {
				System.out.println("Sorry that input is invalid!");
			}
		}
	}
	
	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		List<String> Schedule = new List<String>();

		System.out.println("Welcome to the Scheduler App!\n");
		System.out.println("You have no upcoming events!\n");
		String choice = "C";
		while (!choice.equalsIgnoreCase("X")) {
			System.out.println("Select from the following options: " 
					+ "\nA: Add an event" 
					+ "\nR: Remove an event"
					+ "\nX: Exit");
			System.out.print("\nEnter your choice: ");
			choice = input.next();
			input.nextLine();
			if (!choice.equalsIgnoreCase("A") && !choice.equalsIgnoreCase("R") && !choice.equalsIgnoreCase("X")) {
				System.out.println("Please Enter a valid choice.\n");
				continue;
			} else if (choice.equalsIgnoreCase("A")) {
				addEvent(Schedule, input);
			} else if(choice.equalsIgnoreCase("R")){
				removeEvent(Schedule, input);
			}
		}
		input.close();
		System.out.println("\nGoodbye!");
	}
}
