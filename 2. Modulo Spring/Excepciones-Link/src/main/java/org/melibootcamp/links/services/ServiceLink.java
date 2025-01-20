package org.melibootcamp.links.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.melibootcamp.links.dto.LinkDTo;
import org.melibootcamp.links.entity.Link;
import org.melibootcamp.links.exception.NotFound;
import org.melibootcamp.links.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLink implements IServiceLink {

    @Autowired
    ILinkRepository linkRepository;

    @Override
    public String crear(Link link) {
        return linkRepository.guardarLink(link).toString();
    }

    @Override
    public LinkDTo buscar(Long id) {
        Link link= linkRepository.recuperarLinkId(id);
        if (link==null){
            throw new NotFound("No se encontro ningun link");
        }
        return  new LinkDTo(link.getId())
    }

    @Override
    public Integer metricas(Long id) {
        return linkRepository.metricas(id);
    }

    @Override
    public void borrar(Long id) {
        linkRepository.borrarId(id);
    }
}
