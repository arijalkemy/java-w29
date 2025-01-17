package com.meli.linktracker.repository;

import com.meli.linktracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Integer crearLink(Link link);
    Optional<Link> getLinkById(Integer linkId);
    void incrementarVisitas(Link link);
    void invalidar(Link link);
}
