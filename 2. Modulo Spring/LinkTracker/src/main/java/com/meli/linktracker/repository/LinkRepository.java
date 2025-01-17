package com.meli.linktracker.repository;

import com.meli.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository {
    public List<Link> linkList;

    public LinkRepository() {
        linkList = new ArrayList<>();
        linkList.add(new Link("https://www.youtube.com/?app=desktop&hl=es", "youtube", 0));
        linkList.add(new Link("https://www.google.com", "google", 0));
        linkList.add(new Link("https://www.github.com", "github", 0));
        linkList.add(new Link("https://www.stackoverflow.com", "stackoverflow", 0));
        linkList.add(new Link("https://www.reddit.com", "reddit", 0));
        linkList.add(new Link("https://www.medium.com", "medium", 0));
        linkList.add(new Link("https://www.twitter.com", "twitter", 0));
        linkList.add(new Link("https://www.facebook.com", "facebook", 0));
        linkList.add(new Link("https://www.linkedin.com", "linkedin", 0));
        linkList.add(new Link("https://www.instagram.com", "instagram", 0));
    }

}