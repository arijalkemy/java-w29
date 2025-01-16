package com.bootcamp.linkTracker.repository;

import com.bootcamp.linkTracker.entitiy.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository{

    private Map<Integer, Link> links = new HashMap<>();
    private static Integer id = 0;

    @Override
    public Integer save(Link link) {
        if(link.getId() == null){
            link.setId(++id);
        }
        links.put(link.getId(), link);
        return link.getId();
    }

    @Override
    public Optional<Link> getActiveLink(Integer id) {
        Link link = links.get(id);
        if(link == null || !link.getValid())
            return Optional.empty();

        return Optional.of(link);
    }

    @Override
    public Optional<Link> getLink(Integer id) {
        Link link = links.get(id);
        return link == null ? Optional.empty() : Optional.of(link);
    }
}
