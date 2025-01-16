package com.api.linkTraker.repository;


import com.api.linkTraker.entity.Link;

import java.util.List;
import java.util.Optional;

public interface ILinkRepository {

    List<Link> findAll();
    Optional<Link> findById(String id);
    Link save(Link link);
    Optional<Link> remove(String id);

    void incrementCount(String id);

}