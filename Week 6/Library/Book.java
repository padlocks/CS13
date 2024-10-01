class Book {

  private String title;
  private String author;
  private int yearPublished;
  private String ISBN;

  public Book(String title, String author, int yearPublished, String ISBN) {
    this.title = title;
    this.author = author;
    this.yearPublished = yearPublished;
    this.ISBN = ISBN;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public String getISBN() {
    return ISBN;
  }

  public String toString() {
    return title + " by " + author + " (" + yearPublished + ") ISBN: " + ISBN;
  }
}
