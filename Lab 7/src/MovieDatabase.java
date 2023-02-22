
/**
* MovieDatabase.java
* @author Ryan Oliveira
* @author Tina Nemati
* CIS 22C, Lab 7
*/
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MovieDatabase {
	private static Hash<Movie> movies = new Hash<Movie>(26);
	private static final String filename = "movies.txt";

	/**
	 * Insert movies from file into the movie hash table
	 * 
	 * @param input the scanner
	 * @precondition file should exist
	 * @throws IOException when precondition is violated
	 */
	public static void populateCatalogue() throws IOException {
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			String title = input.nextLine();
			String director = input.nextLine();
			int year = input.nextInt();
			input.nextLine();
			double grossMillions = input.nextDouble();
			if (input.hasNextLine()) {
				input.nextLine();
				input.nextLine();
			}
			Movie movie = new Movie(title, director, year, grossMillions);
			movies.insert(movie);
		}
		input.close();
	}

	/**
	 * Adds a movie object into the movie hash table
	 * 
	 * @param input the scanner
	 */
	public static void addMovie(Scanner in) {
		System.out.print("Enter the title: ");
		String t = in.nextLine();
		System.out.print("Enter the director: ");
		String d = in.nextLine();
		boolean valid = false;
		int y = 0;
		while (!valid) {
			System.out.print("Enter the year: ");
			try {
				y = in.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Input should only be numbers!");
				in.nextLine();
			}
		}
		valid = false;
		double g = 0.0;
		while (!valid) {
			System.out.print("Enter the gross in millions: $");
			try {
				g = in.nextDouble();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Input should only be numbers!");
				in.nextLine();
			}
		}
		Movie m = new Movie(t, d, y, g);
		movies.insert(m);
		System.out.println("\n" + t + " was added!\n");
	}

	/**
	 * Removes movie from the movie hash table
	 */
	public static void removeMovie() {
		Movie movieToRemove = tempMovie();
		if (movies.search(movieToRemove) != -1) {
			movies.remove(movieToRemove);
			System.out.println("\n" + movieToRemove.getTitle() + " was removed!\n");
		} else {
			System.out.println("\nI cannot find " + movieToRemove.getTitle() + " in the database.\n");
		}
	}

	/**
	 * Searches for movie in movie hash table
	 */
	public static void searchMovie() {
		Movie movieToSearch = tempMovie();
		if (movies.search(movieToSearch) != -1) {
			System.out.println("\n" + movieToSearch.getTitle() + " is in the database!\n");
		} else {
			System.out.println("\n" + movieToSearch.getTitle() + " is not in the database.\n");
		}

	}

	/**
	 * Creates temporary movie object to be used in search or removal
	 */
	public static Movie tempMovie() {
		Scanner choice = new Scanner(System.in);
		System.out.print("Enter the title: ");
		String title = choice.nextLine();
		System.out.print("Enter the director: ");
		String dir = choice.nextLine();
		Movie tempMovie = new Movie(title, dir, 0, 0.0);
		return tempMovie;
	}

	public static void main(String[] args) throws IOException {
		boolean loop = true;
		System.out.println("Welcome to the Bond Movie Database!\n");
		populateCatalogue();
		while (loop) {
			Scanner in = new Scanner(System.in);
			System.out.println("Please select from one of the following options:\n");
			System.out
					.println("A. Add a movie\nD. Display a movie\nR. Remove a movie\nS. Search for a movie\nX. Exit\n");
			System.out.print("Enter your choice: ");
			String choice = in.nextLine();

			if (!choice.matches("(?i)A|D|R|X|S")) {
				System.out.println("\nInvalid Selection!\n");

			} else if (choice.matches("(?i)A")) {
				System.out.println("\nAdding a movie!\n");
				addMovie(in);
			} else if (choice.matches("(?i)D")) {
				System.out.println("Displaying Movie Database:\n");
				for (int i = 0; i < movies.getNumElements() - 1; i++) {
					movies.printBucket(i);
				}
				System.out.println("End of database!\n");
			} else if (choice.matches("(?i)R")) {
				System.out.println("\nRemoving a movie!\n");
				removeMovie();
			} else if (choice.matches("(?i)S")) {
				System.out.println("\nSearching for a movie!\n");
				searchMovie();
			} else if (choice.matches("(?i)X")) {
				loop = false;
				System.out.println("\nGoodbye!");
			}
		}
	}
}
