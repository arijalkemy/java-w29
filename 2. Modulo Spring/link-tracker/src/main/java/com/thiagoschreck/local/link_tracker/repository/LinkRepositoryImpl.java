package com.thiagoschreck.local.link_tracker.repository;

import com.thiagoschreck.local.link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private final Map<Integer, Link> links;
    private int identity;

    public LinkRepositoryImpl() {
        this.links = new HashMap<>();
        identity = 0;
    }

    @Override
    public Link save(Link link) {
        link.setId(identity++);
        links.put(link.getId(), link);
        return link;
    }

    @Override
    public Link findById(int linkId) {
        return links.get(linkId);
    }

    @Override
    public Link update(Integer linkId, Link link) {
        links.put(linkId, link);
        return link;
    }
}
