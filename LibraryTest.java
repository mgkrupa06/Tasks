package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    private Library myLibrary;
    private Book testBook;

    @BeforeEach
    void setup() {
        myLibrary = new Library();
        testBook = new Book("Test Book", "Author Name", "BOOKTEST001");
        myLibrary.addBook(testBook);
    }

    @Test
    void testIssueBook() throws BookNotFoundException {

        assertTrue(myLibrary.issueBook("BOOKTEST001"), "Book should be issued successfully");

        assertFalse(myLibrary.isBookAvailable("BOOKTEST001"), "Book should now be issued");
    }

    @Test
    void testReturnBook() throws BookNotFoundException {
        myLibrary.issueBook("BOOKTEST001");

        assertTrue(myLibrary.returnBook("BOOKTEST001"), "Book should be returned successfully");

        assertTrue(myLibrary.isBookAvailable("BOOKTEST001"), "Book should now be available");
    }

    @Test
    void testIsBookAvailable() throws BookNotFoundException {
        assertTrue(myLibrary.isBookAvailable("BOOKTEST001"), "Book should be available initially");

        myLibrary.issueBook("BOOKTEST001");
        assertFalse(myLibrary.isBookAvailable("BOOKTEST001"), "Book should be issued now");
    }
}