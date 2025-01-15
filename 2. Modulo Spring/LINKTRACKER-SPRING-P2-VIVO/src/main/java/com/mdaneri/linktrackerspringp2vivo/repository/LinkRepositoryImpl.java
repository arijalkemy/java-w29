package com.mdaneri.linktrackerspringp2vivo.repository;

import com.mdaneri.linktrackerspringp2vivo.dto.LinkDto;
import com.mdaneri.linktrackerspringp2vivo.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {

    private Map<String, Link> linksById;

    public LinkRepositoryImpl() {
        this.linksById = new HashMap<>();
    }

    @Override
    public List<Link> findAll() {
        return linksById.values().stream().toList();
    }

    @Override
    public Optional<Link> findById(String id) {
        return Optional.ofNullable(linksById.get(id));
    }

    @Override
    public Link save(Link link) {
        linksById.put(link.getId(), link);
        return link;
    }

    @Override
    public Optional<Link> remove(String id) {
        return Optional.ofNullable(linksById.remove(id));
    }

    @Override
    public void incrementCount(String id) {
        Link link = linksById.get(id);
        link.setCount(link.getCount() + 1);
    }

}
