package meli.linktacker.repository;

import meli.linktacker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {

    Integer addLink(Link link);
    Optional<Link> getLink(Integer linkId);
    Integer metricsForLink (Integer linkId);
    void invalidateLink(Integer linkId);
}
