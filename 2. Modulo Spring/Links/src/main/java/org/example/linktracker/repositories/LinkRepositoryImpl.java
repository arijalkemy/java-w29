package org.example.linktracker.repositories;

import org.example.linktracker.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private final List<Link> links = new ArrayList<>();

    @Override
    public Boolean save(Link link) {
        return links.add(link);
    }

    @Override
    public Optional<Link> findById(Long id) {
        return links.stream().filter(link -> link.getId().equals(id)).findFirst();
    }
}
