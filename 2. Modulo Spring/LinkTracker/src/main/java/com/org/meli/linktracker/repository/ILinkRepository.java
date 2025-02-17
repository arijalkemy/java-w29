package com.org.meli.linktracker.repository;

import com.org.meli.linktracker.model.Link;

import java.util.List;
import java.util.Optional;

public interface ILinkRepository {
    Link save(Link link);
    Optional<Link> findById(Long id);
    Boolean invalidate(Long id);
    List<Link> findAll();
}
