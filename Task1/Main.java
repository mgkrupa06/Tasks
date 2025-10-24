package library;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        myLibrary.addBook(new Book("Java Basics", "Herbert Schildt", "BOOK001"));
        myLibrary.addBook(new Book("Effective Java", "Joshua Bloch", "BOOK002"));

        try {

            System.out.println("Is BOOK001 available? " + myLibrary.isBookAvailable("BOOK001"));

            if (myLibrary.issueBook("BOOK001")) {
                System.out.println("Successfully issued BOOK001.");
            } else {
                System.out.println("BOOK001 is already issued.");
            }

            System.out.println("Is BOOK001 available now? " + myLibrary.isBookAvailable("BOOK001"));

            if (myLibrary.returnBook("BOOK001")) {
                System.out.println("Successfully returned BOOK001.");
            } else {
                System.out.println("BOOK001 was not issued.");
            }

            System.out.println("Is BOOK001 available now? " + myLibrary.isBookAvailable("BOOK001"));

        } catch (BookNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
