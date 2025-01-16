package classes;

public class PDFBook extends Document {
    private String title;
    private String author;
    private String genre;
    private int pages;

    public PDFBook(String title, String author, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "PDF Book - Title: " +
                title +
                ". Author: " +
                author +
                ". Genre: " +
                genre +
                ". Pages: " +
                pages +
                ".";
    }
}
