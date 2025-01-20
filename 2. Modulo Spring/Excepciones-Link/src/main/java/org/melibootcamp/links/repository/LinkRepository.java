package org.melibootcamp.links.repository;

import org.melibootcamp.links.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {
    private Map<Long, Link> mapaLink=new HashMap<>();
    private Long contador= 1L;
    @Override
    public Long guardarLink(Link link) {
        link.setId(contador);
        mapaLink.put(contador,link);
        contador++;
        return link.getId();
    }

    @Override
    public Link recuperarLinkId(Long id) {
        Link link=null;
        link=mapaLink.get(id);
        return link;
    }

    @Override
    public Integer metricas(Long id) {
        return mapaLink.get(id).getContador();
    }

    @Override
    public void borrarId(Long id) {
        mapaLink.remove(id);
    }
}
