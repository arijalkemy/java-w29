package classes;

public class Report extends Document{
    private String text;
    private int pages;
    private String author;
    private String reviser;

    public Report(String text, int pages, String author, String reviser) {
        this.text = text;
        this.pages = pages;
        this.author = author;
        this.reviser = reviser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    @Override
    public String toString() {
        return "Report - Text: " +
                text +
                ". Author: " +
                author +
                ". Reviser: " +
                reviser +
                ". Pages: " +
                pages +
                ".";
    }
}
