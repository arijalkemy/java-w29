package com.bootcamp.linkTracker.repository;

import com.bootcamp.linkTracker.entitiy.Link;

import java.util.Optional;

public interface ILinkTrackerRepository {
    Integer save(Link link);
    Optional<Link> getActiveLink(Integer id);
    Optional<Link> getLink(Integer id);
}
