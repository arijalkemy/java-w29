package com.example.ejercicio_link_tracker.repository;

import com.example.ejercicio_link_tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkTrackerRepositoryImpl implements ILinkTrackerRepository {
    private Long count = 0L;
    private List<Link> links = new ArrayList<>();

    public void addLink(Link link) {
        link.setId(count);
        count = count+1;
        links.add(link);
    }

    @Override
    public Optional<Link> getById(Integer id) {
        return links.stream().filter(l -> l.getId().equals(id)).findFirst();
    }
}
