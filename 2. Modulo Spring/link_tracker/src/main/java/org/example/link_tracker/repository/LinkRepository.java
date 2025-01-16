package org.example.link_tracker.repository;


import org.example.link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository
public class LinkRepository implements IRepository {

    private Map<Integer, Link> database;

    public LinkRepository() {
        database = new HashMap<>();
    }

    @Override
    public Link save(Link link) {
        database.put(link.getId(), link);
        return link;
    }

    @Override
    public Link getById(int id) {
        return database.get(id);
    }

    @Override
    public void remove(int id) {
        database.remove(id);
    }
}
