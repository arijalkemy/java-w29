package com.meli.blog.entity;

import org.springframework.stereotype.Component;

public class EntradaBlog {
    public Long id;
    public String title;
    public String author;
    public String date;

    public EntradaBlog(String author, String date, Long id, String title) {
        this.author = author;
        this.date = date;
        this.id = id;
        this.title = title;
    }
}
