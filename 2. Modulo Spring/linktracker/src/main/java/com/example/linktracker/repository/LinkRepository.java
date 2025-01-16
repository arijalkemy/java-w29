package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    public static List<Link> linkList = new ArrayList<>();

    @Override
    public List<Link> findAll() {
        return linkList;
    }

    public Link saveLink(Link link){
        link.setId(linkList.size());
        linkList.add(link);
        return link;
    }

    @Override
    public Optional<Link> findLinkById(Integer id) {
        return linkList.stream().filter(link -> link.getId().equals(id)).findFirst();
    }

    @Override
    public void invalidateLink(Link linkToInvalidate) {
        linkList.remove(linkList.indexOf(linkToInvalidate));
    }
}
