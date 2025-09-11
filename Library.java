package library;

import java.util.HashMap;
import java.util.Map;

public class Library implements Issueable {

    private Map<String, Book> bookCollection;

    public Library() {
        bookCollection = new HashMap<>();
    }

    public void addBook(Book book) {
        bookCollection.put(book.getBookCode(), book);
    }

    @Override
    public boolean issueBook(String bookCode) throws BookNotFoundException {
        Book book = bookCollection.get(bookCode);
        if (book == null) {
            throw new BookNotFoundException("Book not found: " + bookCode);
        }
        if (book.isIssued()) {
            return false; 
        }
        book.issueBook();
        return true;
    }

    @Override
    public boolean returnBook(String bookCode) throws BookNotFoundException {
        Book book = bookCollection.get(bookCode);
        if (book == null) {
            throw new BookNotFoundException("Book not found: " + bookCode);
        }
        if (!book.isIssued()) {
            return false; 
        }
        book.returnBook();
        return true;
    }

    @Override
    public boolean isBookAvailable(String bookCode) throws BookNotFoundException {
        Book book = bookCollection.get(bookCode);
        if (book == null) {
            throw new BookNotFoundException("Book not found: " + bookCode);
        }
        return !book.isIssued();
    }
}