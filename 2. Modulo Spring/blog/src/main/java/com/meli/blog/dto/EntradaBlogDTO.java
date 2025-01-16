package com.meli.blog.dto;

public class EntradaBlogDTO {
    public String title;
    public String author;
    public String date;

    public EntradaBlogDTO(String author, String date, String title) {
        this.author = author;
        this.date = date;
        this.title = title;
    }
}
