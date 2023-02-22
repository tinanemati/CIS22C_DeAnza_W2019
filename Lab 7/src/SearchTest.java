import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * SearchTest.java
 * @author Ryan Oliveira
 * @author Tina Nemati
 * CIS 22C, Lab 7
 */
class SearchTest {

	@Test
	void test() {
		Hash<Movie> t = new Hash<Movie>(20);
        Movie bond1 = new Movie("Dr No", "Terence Young", 1962, 59.5);
        Movie bond2 = new Movie("From Russia with Love", "Terence Young", 1963, 79.0);
        Movie bond3 = new Movie("Goldfinger", "Guy Hamilton", 1964, 125.0);
        t.insert(bond1);
        t.insert(bond2);
        t.insert(bond3);
        assertEquals(15, t.search(bond1));
        t.remove(bond1);
        assertEquals(-1, t.search(bond1));
        assertEquals(14, t.search(bond3));
	}

}
