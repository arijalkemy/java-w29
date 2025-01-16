package com.example.ejercicio_link_tracker.repository;

import com.example.ejercicio_link_tracker.entity.Link;

import java.util.Optional;

public interface ILinkTrackerRepository {
    void addLink(Link link);
    Optional<Link> getById(Integer id);
}
