package com.meli.linktracker.entity;

public class Link {
    public String link;
    public String password;
    public Integer redirections;

    public Link(String link, String password, Integer redirections) {
        this.link = link;
        this.password = password;
        this.redirections = redirections;
    }
}
