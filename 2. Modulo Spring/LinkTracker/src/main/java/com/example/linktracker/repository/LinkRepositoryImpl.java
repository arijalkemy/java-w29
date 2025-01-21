package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository<Link> {
    private List<Link> links = new ArrayList<>();

    @Override
    public Link save(Link entity) {
        entity.setId(++Link.classId);
        links.add(entity);
        return entity;
    }

    @Override
    public Link findById(Integer id) {
        return links.stream().filter(link -> link.getId().equals(id)).findFirst().orElse(null);
    }
}
