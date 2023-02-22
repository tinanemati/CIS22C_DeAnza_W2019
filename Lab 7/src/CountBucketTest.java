import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * CountBucketTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 7
 */
class CountBucketTest {

	@Test
	void test() {
		 Hash<Movie> t = new Hash<Movie>(20);
         Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
         Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
         Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);
         Movie bond4 = new Movie("Thunderball", "Kevin McClory", 1965, 141.2);
         Movie bond5 = new Movie("Casino Royale", "Ken Hughes", 1967, 41.7);
         Movie bond6 = new Movie("You Only Live Twice", "Lewis Gilbert", 1967, 111.6);
         Movie bond7 = new Movie("On Her Majesty's Secret Service", "Peter R. Hunt", 1969, 82.0);
         Movie bond8 = new Movie("Diamonds are Forever", "Guy Hamilton", 1971, 116.0);
         Movie bond9 = new Movie("Live and Let Die", "Guy Hamilton", 1973, 161.8);
         Movie bond10 = new Movie("The Man with the Golden Gun", "Guy Hamilton", 1974, 97.6);
         t.insert(bond1);
         t.insert(bond2);
         t.insert(bond3);
         t.insert(bond4);
         t.insert(bond5);
         t.insert(bond6);
         t.insert(bond7);
         t.insert(bond8);
         t.insert(bond9);
         t.insert(bond10);
         assertEquals(2, t.countBucket(19));
         assertEquals(1, t.countBucket(0));
         assertEquals(0, t.countBucket(3));

	}

}
