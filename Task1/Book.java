package library;

public class Book {
    private String bookTitle;
    private String bookAuthor;
    private String bookCode;   
    private boolean isIssued;

    public Book(String bookTitle, String bookAuthor, String bookCode) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCode = bookCode;
        this.isIssued = false;
    }

    public String getBookCode() {
        return bookCode;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        this.isIssued = true;
    }

    public void returnBook() {
        this.isIssued = false;
    }

    @Override
    public String toString() {
        return bookTitle + " by " + bookAuthor +
               " (Book Code: " + bookCode + ") - " +
               (isIssued ? "Issued" : "Available");
    }
}
