package com.example.linktracker.repository;


import com.example.linktracker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Integer crearLink(Link link);
    Optional<Link> getLinkById(Integer linkId);
    void incrementarVisitas(Link link);
    void invalidar(Link link);
}
