package org.example.link_tracker.service;


import org.example.link_tracker.dto.RequestLinkDTO;
import org.example.link_tracker.dto.ResponseLinkDTO;
import org.example.link_tracker.entity.Link;
import org.example.link_tracker.exception.NotFoundException;
import org.example.link_tracker.exception.UnauthorizedException;
import org.example.link_tracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements IService {
    private LinkRepository repository;

    public LinkService() {
        repository = new LinkRepository();
    }

    private static ResponseLinkDTO mapResponseLinkDTO(Link link) {
        return new ResponseLinkDTO(link.getId(), link.getUrl());
    }

    @Override
    public ResponseLinkDTO addLink(RequestLinkDTO linkDTO) {
        Link link = new Link(linkDTO.getUrl());
        repository.save(link);
        return mapResponseLinkDTO(link);
    }

    @Override
    public ResponseLinkDTO redirect(int linkId, int password) {
        Link link = repository.getById(linkId);
        if (link == null) {
            throw new NotFoundException("El link no se encuentra disponible");
        }
        validatePassword(link, password);
        link.sumRedirect();
        repository.save(link);
        return mapResponseLinkDTO(link);
    }

    @Override
    public String getMetrics(int linkId) {
        Link link = repository.getById(linkId);
        if (link == null) {
            throw new NotFoundException("El link no se encuentra disponible");
        }
        return "La cantidad de redirecciones para el link con id: " + link.getId() + " es de " + link.getCountRedirects();
    }

    @Override
    public void invalidateLink(int linkID) {
        repository.remove(linkID);
    }

    @Override
    public void validatePassword(Link link, int code) {
        if (!link.validatePass(code)) {
            throw new UnauthorizedException("No autorizado");
        }
    }
}
