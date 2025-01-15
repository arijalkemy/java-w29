package com.thiagoschreck.local.link_tracker.service;

import com.thiagoschreck.local.link_tracker.dto.request.NewLinkRequestDTO;
import com.thiagoschreck.local.link_tracker.dto.response.LinkMetricsResponseDTO;
import com.thiagoschreck.local.link_tracker.dto.response.NewLinkResponseDTO;
import com.thiagoschreck.local.link_tracker.entity.Link;
import com.thiagoschreck.local.link_tracker.exception.DisabledLinkException;
import com.thiagoschreck.local.link_tracker.exception.InvalidLinkException;
import com.thiagoschreck.local.link_tracker.exception.InvalidPasswordException;
import com.thiagoschreck.local.link_tracker.exception.LinkIdNotFoundException;
import com.thiagoschreck.local.link_tracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService {
    private final ILinkRepository repository;

    @Autowired
    public LinkTrackerServiceImpl(ILinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public NewLinkResponseDTO addLink(NewLinkRequestDTO newLink) {
        Link savedLink = repository.save(map(newLink));
        return map(savedLink);
    }

    private Link map(NewLinkRequestDTO newLink) {
        return new Link(newLink.value(), newLink.password());
    }

    @Override
    public HttpHeaders redirectTo(int linkId, String password) {
        Link link = repository.findById(linkId);
        if (link == null) {
            throw new LinkIdNotFoundException(linkId);
        }
        if (link.isDisabled()) {
            throw new DisabledLinkException(linkId);
        }
        if (link.getPassword() != null && !link.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(getURI(link.getUrl()));
        link.visit();
        return httpHeaders;
    }

    private URI getURI(String url) {
        try {
            new URL(url);
            return new URI(url);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidLinkException(e.getMessage());
        }
    }


    @Override
    public LinkMetricsResponseDTO getMetrics(Integer linkId) {
        Link link = repository.findById(linkId);
        if (link == null) {
            throw new LinkIdNotFoundException(linkId);
        }
        return new LinkMetricsResponseDTO(link.getUrl(), link.getAmountOfRedirects());
    }

    @Override
    public Void invalidateLink(Integer linkId) {
        Link link = repository.findById(linkId);
        if (link == null) {
            throw new LinkIdNotFoundException(linkId);
        }
        link.setDisabled(true);
        repository.update(linkId, link);
        return null;
    }

    private NewLinkResponseDTO map(Link savedLink) {
        return new NewLinkResponseDTO(savedLink.getId());
    }
}
