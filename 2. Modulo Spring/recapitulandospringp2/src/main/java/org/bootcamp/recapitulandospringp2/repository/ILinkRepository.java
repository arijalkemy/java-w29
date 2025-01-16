package org.bootcamp.recapitulandospringp2.repository;

import org.bootcamp.recapitulandospringp2.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Integer crearLink(Link link);
    Optional<Link> getLinkById(Integer linkId);
    void incrementarVisita(Integer linkId);
    void invalidateLink(Integer linkId);
}
