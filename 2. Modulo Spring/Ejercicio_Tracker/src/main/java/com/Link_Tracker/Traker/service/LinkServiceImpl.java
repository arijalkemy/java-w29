package com.Link_Tracker.Traker.service;

import com.Link_Tracker.Traker.dto.request.LinkDto;
import com.Link_Tracker.Traker.dto.response.LinkResponseDto;
import com.Link_Tracker.Traker.entity.Link;
import com.Link_Tracker.Traker.exception.NotFoundException;
import com.Link_Tracker.Traker.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{
    private ILinkRepository repository;
    private ObjectMapper objMaper;
    private  Integer id = 0;

    public LinkServiceImpl(ILinkRepository repository, ObjectMapper objMapper){
        this.repository=repository;
        this.objMaper = objMapper;
    }

    public LinkResponseDto createLink(LinkDto linkDto){
        Link link = objMaper.convertValue(linkDto, Link.class);
        link.setId(repository.getNextId());
        link.setEnmascarado("http://localhost:8080/link/" + link.getId()); // Enmascarar URL
        link.setValido(true);

        repository.addLink(link); // Agregar al repositorio
        return objMaper.convertValue(link, LinkResponseDto.class);
    }

    @Override
    public LinkResponseDto getLinkById(Integer id) {
        Optional<Link> response = repository.getLinkById(id);
        if (response.isEmpty()){
            throw new NotFoundException("No existe la URL");
        }
        Link link = response.get();
        link.setContador(link.getContador() + 1);
        return objMaper.convertValue(link, LinkResponseDto.class);
    }

    public void invalidateLink(Integer id) {
        repository.invalidateLink(id);
    }

}
