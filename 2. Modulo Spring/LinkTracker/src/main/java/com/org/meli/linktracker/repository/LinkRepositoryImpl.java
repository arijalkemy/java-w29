package com.org.meli.linktracker.repository;

import com.org.meli.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    private final List<Link> linkStorage = new ArrayList<>();

    public Link save(Link link) {
        linkStorage.add(link);
        return link;
    }

    @Override
    public Optional<Link> findById(Long id) {
        return linkStorage.stream()
                .filter(link -> link.getId().equals(id))
                .findFirst();
    }

    @Override
    public Boolean invalidate(Long id) {
        Optional<Link> linkOptional = findById(id);
        linkOptional.ifPresent(link -> link.setValid(false));
        return linkOptional.isPresent();
    }

    @Override
    public List<Link> findAll() {
        return new ArrayList<>(linkStorage);
    }
}
