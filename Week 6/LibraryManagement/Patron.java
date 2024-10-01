import java.util.ArrayList;

public class Patron extends Person {
	private String libraryCardNumber;
	private ArrayList<Book> borrowedBooks = new ArrayList<>();
	
	public Patron(String firstName, String lastName, String phoneNumber, String libraryCardNumber) {
		super(firstName, lastName, phoneNumber);
		this.libraryCardNumber = libraryCardNumber;
	}
	
	public String getLibraryCardNumber() {
		return libraryCardNumber;
	}
	
	public void setLibraryCardNumber(String libraryCardNumber) {
		this.libraryCardNumber = libraryCardNumber;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void borrowBook(Book book) {
		borrowedBooks.add(book);
	}

	public void returnBook(Book book) {
		borrowedBooks.remove(book);
	}
	
	public String toString() {
		return super.toString() + " " + libraryCardNumber + " " + borrowedBooks;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Patron) {
			Patron p = (Patron) obj;
			return super.equals(p) && libraryCardNumber.equals(p.libraryCardNumber);
		}
		return false;
	}
}