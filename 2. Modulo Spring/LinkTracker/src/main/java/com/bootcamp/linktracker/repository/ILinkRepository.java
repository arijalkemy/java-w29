package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link saveLink(Link link);

    Optional<Link> findById(String linkId);

    void incrementVisits(String linkId);
}
