import java.util.ArrayList;

public class Library implements Inventory {
	private ArrayList<Patron> patrons = new ArrayList<>();
	private ArrayList<Book> books = new ArrayList<>();
	
	public Library() {
		patrons = new ArrayList<>();
		books = new ArrayList<>();
	}

    @Override
	public boolean add(Object o) {
		if (o instanceof Patron) {
			Patron p = (Patron) o;
			if (!patrons.contains(p)) {
				patrons.add(p);
				return true;
			}
		} else if (o instanceof Book) {
			Book b = (Book) o;
			if (!books.contains(b)) {
				books.add(b);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Object search(Object o) {
		if (o instanceof String) {
			String s = (String) o;
			for (Book book : books) {
				if (book.getTitle().equals(s)) {
					return book;
				}
			}
			for (Patron patron : patrons) {
				if (patron.getLastName().equals(s)) {
					return patron;
				}
			}
		}
		return null;		
	}
	
	@Override
	public boolean delete(Object o) {
		if (o instanceof Book) {
			Book b = (Book) o;
			if (books.contains(b)) {
				books.remove(b);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void printLastNames() {
		for (Patron patron : patrons) {
			System.out.println(patron.getLastName());
		}
	}
	
	public String toString() {
		return "Library: " + books;
	}
}