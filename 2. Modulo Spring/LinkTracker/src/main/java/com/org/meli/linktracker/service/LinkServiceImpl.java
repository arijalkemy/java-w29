package com.org.meli.linktracker.service;

import com.org.meli.linktracker.dto.LinkDto;
import com.org.meli.linktracker.exception.InvalidPasswordException;
import com.org.meli.linktracker.exception.LinkAlreadyInvalidException;
import com.org.meli.linktracker.exception.ResourceNotFoundException;
import com.org.meli.linktracker.model.Link;
import com.org.meli.linktracker.repository.ILinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LinkServiceImpl implements ILinkService{
    private final ILinkRepository linkRepository;
    private Long idGenerator = 0L;

    public LinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDto createLink(String url, String password) {
        idGenerator++;
        Link link = new Link(idGenerator,url,0,true,password);
        linkRepository.save(link);
        return new LinkDto(link.getId(),link.getOriginalUrl(), link.getRedirectCount());
    }

    @Override
    public String getRedirectUrlResponse(Long id, String password) {
        Link link = linkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Enlace no encontrado"));
        if(!link.getValid()) {
            throw new LinkAlreadyInvalidException("El enlace ya ha sido invalidado");
        }
        if (!link.getPassword().equals(password)) {
            throw new InvalidPasswordException("Contraseña incorrecta");
        }
        link.setRedirectCount(link.getRedirectCount() + 1);
        linkRepository.save(link);
        return link.getOriginalUrl();
    }

    @Override
    public LinkDto getMetricsResponse(Long id) {
        Link link = linkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existen metricas para el enlace"));
        return new LinkDto(link.getId(),link.getOriginalUrl(), link.getRedirectCount());
    }

    @Override
    public String invalidateLinkResponse(Long id) {
        Link link = linkRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El enlace no existe"));
        if(!link.getValid()) {
            throw new LinkAlreadyInvalidException("El enlace ya ha sido invalidado");
        }
        link.setValid(false);
        linkRepository.save(link);
        return "El enlace ha sido invalidado";
    }

    @Override
    public List<LinkDto> getAllLinks() {
        List<LinkDto> linkDtos = linkRepository.findAll().stream()
                .map(link -> new LinkDto(link.getId(),link.getOriginalUrl(), link.getRedirectCount()))
                .collect(Collectors.toList());
        if (linkDtos.isEmpty()) {
            throw new ResourceNotFoundException("No se encontraron enlaces");
        }
        return linkDtos;
    }
}
