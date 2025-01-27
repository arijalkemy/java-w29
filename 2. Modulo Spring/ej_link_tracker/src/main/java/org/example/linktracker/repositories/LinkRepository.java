package org.example.linktracker.repositories;

import org.example.linktracker.entities.Link;

import java.util.Optional;

public interface LinkRepository {

    Boolean save(Link link);

    Optional<Link> findById(Long id);

}
