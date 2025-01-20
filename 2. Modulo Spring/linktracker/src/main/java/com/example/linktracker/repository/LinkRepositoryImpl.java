package com.example.linktracker.repository;


import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{
    private List<Link> links = new ArrayList<>();
    private static Integer contadorId = 1;

    @Override
    public Integer crearLink(Link link) {
        link.setId(contadorId++);
        this.links.add(link);
        return link.getId();
    }

    @Override
    public Optional<Link> getLinkById(Integer linkId) {
        return this.links.stream().filter(l -> l.getId().equals(linkId)).findFirst();
    }

    @Override
    public void incrementarVisitas(Link link) {
        link.setCantidadConsulta(link.getCantidadConsulta()+1);
    }

    @Override
    public void invalidar(Link link) {
        this.links.remove(link);
    }
}