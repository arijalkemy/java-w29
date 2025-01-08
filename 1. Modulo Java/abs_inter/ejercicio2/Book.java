package ejercicio2;

public class Book extends Document {
  private int pages;
  private String author;
  private String title;
  private String genre;

  public Book(int pages, String author, String title, String genre) {
    this.pages = pages;
    this.author = author;
    this.title = title;
    this.genre = genre;
  }
}
