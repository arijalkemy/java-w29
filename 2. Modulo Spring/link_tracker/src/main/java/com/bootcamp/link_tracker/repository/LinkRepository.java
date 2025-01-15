package com.bootcamp.link_tracker.repository;

import com.bootcamp.link_tracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository {

    private Map<Integer, Link> links = new HashMap<>();

    public Integer save(Link link) {
        link.setLinkId(links.size());
        links.put(link.getLinkId(), link);
        return link.getLinkId();
    }

    public Link findById(int id) {
        return links.get(id);
    }

    public Map<Integer, Link> getLinks() {
        return links;
    }
}
