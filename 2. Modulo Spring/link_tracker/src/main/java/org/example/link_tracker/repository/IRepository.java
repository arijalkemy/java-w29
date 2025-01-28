package org.example.link_tracker.repository;

import org.example.link_tracker.entity.Link;


public interface IRepository {
    Link save(Link link);
    Link getById(int id);
    void remove(int id);
}
