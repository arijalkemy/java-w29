package com.example.repository;

import com.example.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private List<Link> links = new ArrayList<>();

    @Override
    public void save(Link link) {
        links.add(link);
    }

    @Override
    public Link findById(Integer id) {
        return links.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Link> findAll() {
        return links;
    }

    @Override
    public Boolean existsById(Integer id) {
        return links.stream().anyMatch(x -> x.getId().equals(id));
    }
}
