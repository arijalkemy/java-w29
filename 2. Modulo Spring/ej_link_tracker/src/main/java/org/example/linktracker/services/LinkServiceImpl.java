package org.example.linktracker.services;

import lombok.RequiredArgsConstructor;
import org.example.linktracker.dtos.LinkUrlDto;
import org.example.linktracker.dtos.LinkIdDto;
import org.example.linktracker.entities.Link;
import org.example.linktracker.exceptions.NotFoundException;
import org.example.linktracker.exceptions.NotValidLinkException;
import org.example.linktracker.repositories.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository repo;

    private Long maxId = 1L;

    @Override
    public LinkIdDto createLink(LinkUrlDto linkDtoRequest, String password) {
        Link nuevo = Link.builder()
                .id(maxId++)
                .url(linkDtoRequest.url())
                .password(password)
                .build();
        repo.save(nuevo);
        return LinkIdDto.toDto(nuevo);
    }

    @Override
    public String redirect(Long linkId) {
        Link link = getLink(linkId);

        if (!link.isValid()) throw new NotValidLinkException("Link inválido");

        link.redireccionar();
        return link.getUrl();
    }

    @Override
    public Integer getMetrics(Long linkId) {
        Link link = getLink(linkId);
        return link.getCantidadRedirecciones();
    }


    @Override
    public Void invalidate(Long linkId) {
        Link link = getLink(linkId);
        link.setValid(false);
        return null;
    }

    private Link getLink(Long linkId) {
        return repo.findById(linkId).orElseThrow(() -> new NotFoundException("Link no encontrado"));
    }

}
