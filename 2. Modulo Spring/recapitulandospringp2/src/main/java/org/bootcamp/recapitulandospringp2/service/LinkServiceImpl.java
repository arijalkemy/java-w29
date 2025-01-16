package org.bootcamp.recapitulandospringp2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bootcamp.recapitulandospringp2.dto.request.LinkDto;
import org.bootcamp.recapitulandospringp2.dto.response.LinkResponseDto;
import org.bootcamp.recapitulandospringp2.entity.Link;
import org.bootcamp.recapitulandospringp2.exception.IncorrectPasswordException;
import org.bootcamp.recapitulandospringp2.exception.LinkInvalidatedException;
import org.bootcamp.recapitulandospringp2.exception.NotFoundException;
import org.bootcamp.recapitulandospringp2.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{
    private ILinkRepository repository;
    private ObjectMapper om;
    private final String LINK_PASS = "MELI";

    @Autowired
    public LinkServiceImpl(ILinkRepository repository) {
        this.repository = repository;
        this.om = new ObjectMapper();
    }

    @Override
    public LinkResponseDto crearLink(LinkDto linkDto) {
        Link linkToCreate = new Link(linkDto.getUrl());
        Integer linkId = this.repository.crearLink(linkToCreate);
        return new LinkResponseDto(linkId);
    }

    @Override
    public String redireccionar(Integer linkId) {
        Link link = getById(linkId);
        if(!link.isValid()){
            throw new LinkInvalidatedException("Link invalidated");
        }
        repository.incrementarVisita(linkId);
        return getById(linkId).getUrl();
    }

    @Override
    public Integer getCantidadVisitas(Integer linkId){
        return getById(linkId).getCantidadConsulta();
    }

    @Override
    public void invalidateLink(Integer linkId) {
        Link linkFound = getById(linkId);
        repository.invalidateLink(linkFound.getId());
    }

    private Link getById(Integer linkId){
        Optional<Link> oLink = this.repository.getLinkById(linkId);
        if (oLink.isEmpty())
            throw new NotFoundException("Link not found with id: " + linkId);
        return oLink.get();
    }

    @Override
    public void validatePassword(String password){
        if(!LINK_PASS.equals(password)){
            throw new IncorrectPasswordException("Password incorrect");
        }
    }
}
