package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository {

    private Map<Integer, Link> links = new HashMap<>();
    private Integer idCount = 0;
    // private String PASSWORD = "My super secure password";

    public Integer save(Link link) {
        link.setLinkId(idCount);
        links.put(link.getLinkId(), link);
        idCount++;
        return link.getLinkId();
    }

    public Link findById(int id) {
        return links.get(id);
    }

    public Map<Integer, Link> getLinks() {
        return links;
    }

    public void invalidateLink(Integer linkId){
        links.remove(linkId);
    }

    public Optional<Link> findLinkByName(String name){
        return links.values().stream().filter(l -> l.getLink().equals(name)).findFirst();
    }
}
