package com.example.links.repositories;

import com.example.links.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {

    private Map<Integer, Link> linkMap= new HashMap<>();

    public Integer addLink(Link link) {
        linkMap.put(link.getId(), link);
        return link.getId();
    }


}
