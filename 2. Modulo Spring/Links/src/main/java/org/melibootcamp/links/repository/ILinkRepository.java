package org.melibootcamp.links.repository;

import org.melibootcamp.links.entity.Link;

public interface ILinkRepository {
    public Long guardarLink(Link link);
    public Link recuperarLinkId(Long id);
    public Integer metricas(Long id);
    public void borrarId(Long id);
}
