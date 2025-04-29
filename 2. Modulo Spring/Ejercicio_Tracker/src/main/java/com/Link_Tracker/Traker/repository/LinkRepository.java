package com.Link_Tracker.Traker.repository;

import com.Link_Tracker.Traker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    HashMap<Integer, Link> listaLinks = new HashMap<>();
    private Integer idCounter = 1;


    public Link addLink(Link link){
      return listaLinks.put(link.getId(),link);
    }

    @Override
    public Optional<Link> getLinkById(Integer id) {
       return Optional.ofNullable(listaLinks.get(id));
    }

    @Override
    public void invalidateLink(Integer id) {
        Link link = listaLinks.get(id);
        if (link != null) {
            link.setValido(false);
        }
    }

    public Integer getNextId() {
        return idCounter++;
    }
}
