package com.example.LinkTracker.repository;

import com.example.LinkTracker.model.Link;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    private List<Link> linksList;

    public LinkRepository(){
        linksList = new ArrayList<>();
        linksList.add(new Link("https://www.google.com"));
        linksList.add(new Link("https://www.google.com"));

    }
    @Override
    public Integer createLink(Link link) {
        linksList.add(link);
        return link.getLinkId();
    }

    @Override
    public Optional<Link> getLinkById(Integer linkId) {
        return linksList.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst();
    }

    @Override
    public Optional<Link> getLinkByUrl(String url) {
        return linksList.stream()
                .filter(link -> link.getUrl().equals(url))
                .findFirst();
    }

    @Override
    public String redirect(Integer linkId) {
        return linksList.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst()
                .get().getUrl();
    }

    @Override
    public Integer stats(Integer linkId) {
        return  linksList.stream()
                .filter(link -> link.getLinkId().equals(linkId))
                .findFirst()
                .get().getVisitCounter();
    }

    @Override
    public Link invalidate(Integer linkId) {
        Link link = linksList.stream()
                    .filter(l -> l.getLinkId().equals(linkId))
                    .findFirst()
                    .get();
        link.setIsValid(false);
        return link;
    }
}
