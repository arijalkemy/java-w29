package org.melibootcamp.links.services;

import org.melibootcamp.links.dto.LinkDTo;
import org.melibootcamp.links.entity.Link;

public interface IServiceLink {
    public String crear(Link link);
    public LinkDTo buscar(Long id);
    public Integer metricas(Long id);
    public void borrar(Long id);
}
