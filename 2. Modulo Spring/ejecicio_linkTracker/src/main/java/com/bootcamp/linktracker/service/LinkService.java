package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkRequestBody;
import com.bootcamp.linktracker.dto.LinkResponseBody;
import com.bootcamp.linktracker.exception.BadUrlException;
import com.bootcamp.linktracker.exception.LinkNotFoundException;
import com.bootcamp.linktracker.model.Link;
import com.bootcamp.linktracker.repository.LinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public LinkResponseBody saveLink(LinkRequestBody request) {
        checkIfUrlIsValid(request.url());

        Link link = new Link();
        link.setUrl(request.url());
        link.setVisits(0);

        return objectMapper.convertValue(linkRepository.saveLink(link), LinkResponseBody.class);

    }

    private void checkIfUrlIsValid(String url) {
        try {
            URI.create(url);
        } catch (NullPointerException | IllegalArgumentException e) {
            throw new BadUrlException(e.getMessage());
        }

    }

    public String findUrlById(String linkId) {
        return linkRepository
                .findById(linkId)
                .orElseThrow(() -> new LinkNotFoundException("Could not found a link with id: " + linkId))
                .getUrl();
    }

    public void incrementVisits(String linkId) {
        checkIfLinkExists(linkId);
        linkRepository.incrementVisits(linkId);
    }

    private void checkIfLinkExists(String linkId) {
        if (linkRepository.findById(linkId).isEmpty()) {
            throw new LinkNotFoundException("Could not find a link with id: " + linkId);
        }
    }

    public LinkResponseBody getMetrics(String linkId) {
        checkIfLinkExists(linkId);

        return linkRepository
                .findById(linkId)
                .map(v -> objectMapper.convertValue(v, LinkResponseBody.class))
                .get();

    }
}
