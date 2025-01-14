package ejercicio2;

public class Resume extends Document {
  private String text;
  private int pages;
  private String author;
  private String editor;

  public Resume(String text, int pages, String author, String editor) {
    this.text = text;
    this.pages = pages;
    this.author = author;
    this.editor = editor;
  }
}