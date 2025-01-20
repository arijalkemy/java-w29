package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;

import javax.sql.RowSet;
import java.util.List;
import java.util.Optional;

public interface ILinkRepository {
    Optional<List<Link>> findAll();
    Optional<Link> findByUrl(String url);
    Optional<Integer> saveUrl(Link link);
    Optional<Link> findById(Integer linkId);

    Boolean updateVisitCounter(Link linkupdate);
    Boolean updateValid(Link linkupdate);
}
