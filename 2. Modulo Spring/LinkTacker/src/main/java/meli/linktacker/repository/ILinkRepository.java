package meli.linktacker.repository;

import meli.linktacker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {

    Integer addLink(Link link);
    Optional<Link> getLink(Integer linkId);

    void updateViews(Link link, Integer views);
    void removeLink(Link link);
}
