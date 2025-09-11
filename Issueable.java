package library;

public interface Issueable {
 boolean issueBook(String bookCode) throws BookNotFoundException;

 boolean returnBook(String bookCode) throws BookNotFoundException;

 boolean isBookAvailable(String bookCode) throws BookNotFoundException;
}