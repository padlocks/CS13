import java.util.Scanner;

public class LibraryManager {

  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
      System.out.println("\nLibrary Manager:");
      System.out.println("1. Add a book");
      System.out.println("2. List all books");
      System.out.println("3. Search for a book by title");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      switch (choice) {
        case 1:
          System.out.print("Enter title: ");
          String title = scanner.nextLine();

          System.out.print("Enter author: ");
          String author = scanner.nextLine();

          System.out.print("Enter year published: ");
          int year = scanner.nextInt();

          scanner.nextLine(); // Consume newline

          System.out.print("Enter ISBN: ");
          String ISBN = scanner.nextLine();

          Book book = new Book(title, author, year, ISBN);
          library.addBook(book);
          
          System.out.println("Book added successfully.");
          break;
        case 2:
          library.listBooks();
          break;
        case 3:
          System.out.print("Enter the title to search: ");
          String searchTitle = scanner.nextLine();
          library.searchByTitle(searchTitle);
          break;
        case 4:
          running = false;
          System.out.println("Exiting Library Manager.");
          break;
        default:
          System.out.println("Invalid choice.");
      }
    }
    scanner.close();
  }
}