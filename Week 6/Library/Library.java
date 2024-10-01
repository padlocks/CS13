import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public void listBook() {
		for (Book book : books) {
			System.out.println(book);
		}
	}

	public void searchByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {

				System.out.println(book);

				return;

			}
    	}
    	System.out.println("Book not found.");
	}
}