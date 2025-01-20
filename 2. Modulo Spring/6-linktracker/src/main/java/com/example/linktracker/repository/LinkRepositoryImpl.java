package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    private List<Link> links;

    public LinkRepositoryImpl(){
        this.links = new ArrayList<>();
    }

    @Override
    public Optional<List<Link>> findAll() {
        return Optional.ofNullable(this.links);
    }

    @Override
    public Optional<Link> findByUrl(String url) {
        return this.links.stream()
                .filter(v -> v.getUrl().equalsIgnoreCase(url))
                .findFirst();
    }

    @Override
    public Optional<Integer> saveUrl(Link link) {
        this.links.add(link);
        return Optional.ofNullable(link.getId());
    }

    @Override
    public Optional<Link> findById(Integer linkId) {
        return this.links.stream()
                .filter(v -> Objects.equals(v.getId(), linkId))
                .findFirst();
    }

    @Override
    public Boolean updateVisitCounter(Link linkupdate) {
        if(this.findById(linkupdate.getId()).isEmpty()){
            return false;
        }
        this.links.stream()
                .filter(v -> v.getId().equals(linkupdate.getId()))
                .findFirst()
                .ifPresent(v -> v.setVisitCounter(linkupdate.getVisitCounter()));
        return true;
    }

    @Override
    public Boolean updateValid(Link linkupdate) {
        if(this.findById(linkupdate.getId()).isEmpty()){
            return false;
        }
        this.links.stream()
                .filter(v -> v.getId().equals(linkupdate.getId()))
                .findFirst()
                .ifPresent(v -> v.setValid(linkupdate.getValid()));
        return true;
    }
}
