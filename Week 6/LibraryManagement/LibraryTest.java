public class LibraryTest {
  public static void main(String[] args) {
    Library library = new Library();

    System.out.println(library);

    // Create some books
    Book book1 = new Book("The Great Gatsby", "F. Scott", "Fitzgerald", "123456789", "Fiction");
    Book book2 = new Book("1984", "George", "Orwell", "987654321", "Dystopian");
    Book book3 = new Book("To Kill a Mockingbird", "Harper", "Lee", "123987654", "Fiction");
    Book book4 = new Book("The Catcher in the Rye", "J.D.", "Salinger", "456789123", "Fiction");
    Book book5 = new Book("The Hobbit", "J.R.R.", "Tolkien", "789123456", "Fantasy");

    // Create some patrons
    Patron patron1 = new Patron("John", "Doe", "1234567890", "P001");
    Patron patron2 = new Patron("Jane", "Smith", "0987654321", "P002");
    Patron patron3 = new Patron("Alice", "Jones", "4567891234", "P003");

    // Add books and patrons to the library
    library.add(book1);
    library.add(book2);
    library.add(book3);
    library.add(book4);
    library.add(book5);
    library.add(patron1);
    library.add(patron2);
    library.add(patron3);

    // Borrow a book
    patron1.borrowBook(book1);

    // Print patron last names
    library.printLastNames();

    // Search for a book
    Book foundBook = (Book) library.search("1984");
    if (foundBook != null) {
      System.out.println("Book found: " + foundBook);
    } else {
      System.out.println("Book not found");
    }

    // Delete a book
    library.delete(book2);

    System.out.println(library);
  }
}
