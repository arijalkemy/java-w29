package com.meli.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.linktracker.dto.response.LinkDto;
import com.meli.linktracker.dto.response.LinkMetricsDto;
import com.meli.linktracker.entity.Link;
import com.meli.linktracker.exception.NotFoundException;
import com.meli.linktracker.exception.UnauthorizedException;
import com.meli.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{
    private ILinkRepository repository;
    private ObjectMapper om;
    private final String linkPassword;

    @Autowired
    public LinkServiceImpl(ILinkRepository repository) {
        this.repository = repository;
			  this.linkPassword = "PASSWORD";
			  this.om = new ObjectMapper();
    }

    @Override
    public LinkDto crearLink(com.meli.linktracker.dto.request.LinkDto linkDto, String password) {
        if (!password.equals(this.linkPassword)) throw new UnauthorizedException("Password doesn't match");
        Link linkToCreate = new Link(linkDto.getUrl(), 0);
        Integer linkId = this.repository.crearLink(linkToCreate);
        return new LinkDto(linkId);
    }

    @Override
    public String redireccionar(Integer linkId) {
        Optional<Link> oLink = this.repository.getLinkById(linkId);
        if (oLink.isEmpty())
            throw new NotFoundException("Link not found with id: " + linkId);
        this.repository.incrementarVisitas(oLink.get());
        return oLink.get().getUrl();
    }

    @Override
    public LinkMetricsDto obtenerMetricas(Integer linkId) {
        Optional<Link> oLink = this.repository.getLinkById(linkId);
        if (oLink.isEmpty())
            throw new NotFoundException("Link not found with id: " + linkId);
        return new LinkMetricsDto(oLink.get().getCantidadConsulta());
    }

    @Override
    public void invalidar(Integer linkId) {
        Optional<Link> oLink = this.repository.getLinkById(linkId);
        if (oLink.isEmpty())
            throw new NotFoundException("Link not found with id: " + linkId);
        this.repository.invalidar(oLink.get());
    }
}
