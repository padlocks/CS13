public class Book {
	private String title;
	private String authorFirstName;
	private String authorLastName;
	private String isbn;
	private String genre;
	private boolean checkedOut;
	
	public Book(String title, String authorFirstName, String authorLastName, String isbn, String genre) {
		this.title = title;
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.isbn = isbn;
		this.genre = genre;
		this.checkedOut = false;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return authorFirstName + " " + authorLastName;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public String getGenre() {
		return genre;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	public String toString() {
		return title + " " + authorFirstName + " " + authorLastName + " " + isbn + " " + genre + " " + 
			(checkedOut ? "checked out" : "not checked out");
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Book) {
			Book b = (Book) obj;
			return title.equals(b.title) && authorFirstName.equals(b.authorFirstName) && authorLastName.equals(b.authorLastName) && isbn.equals(b.isbn) && genre.equals(b.genre);
		}
		return false;
	}
}