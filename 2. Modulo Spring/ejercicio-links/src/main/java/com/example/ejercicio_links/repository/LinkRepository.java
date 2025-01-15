package com.example.ejercicio_links.repository;

import com.example.ejercicio_links.dto.LinkDTO;
import com.example.ejercicio_links.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository {
    private int id;
    private Map<Integer, Link> links;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    public int addLink(Link link){
        int idLink = ++id;
        links.put(idLink,link);
        return idLink;
    }

    public Optional<Link> findByID(int id){
        return Optional.ofNullable(links.get(id));
    }


}
