package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LinkRepository implements ILinkRepository{

    private final List<Link> links = new ArrayList<>();

    @Override
    public Link saveLink(Link link) {
        link.setId(UUID.randomUUID().toString());
        links.add(link);
        return link;
    }

    @Override
    public Optional<Link> findById(String linkId) {
        return links
                .stream()
                .filter(link -> link.getId().equals(linkId))
                .findFirst();
    }

    @Override
    public void incrementVisits(String linkId) {
        links
                .stream()
                .filter(link -> link.getId().equals(linkId))
                .forEach(link -> link.setVisits(link.getVisits() + 1));
    }
}
