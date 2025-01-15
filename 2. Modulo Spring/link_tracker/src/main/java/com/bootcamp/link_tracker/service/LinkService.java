package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkPostResponseDTO;
import com.bootcamp.link_tracker.dto.LinkRequestDTO;
import com.bootcamp.link_tracker.exceptions.LinkNotFoundException;
import com.bootcamp.link_tracker.model.Link;
import com.bootcamp.link_tracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class LinkService {
    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public LinkPostResponseDTO save(LinkRequestDTO linkRequestDTO) {
        // ObjectMapper??? no seria un poco over kill????
        Link link = Link.builder().link(linkRequestDTO.getLink()).timesUsed(0).build();
        linkRepository.save(link);
        return LinkPostResponseDTO.builder().linkId(link.getLinkId()).build();
    }

    public Link redirectLink(Integer linkId) throws LinkNotFoundException, MalformedURLException, URISyntaxException {
        Link link = linkRepository.findById(linkId);
        if (link == null || !isUrlValid(link.getLink()))
            throw new LinkNotFoundException("A link with id: " + linkId + " does not exists");
        link.setTimesUsed(link.getTimesUsed() + 1);
        return link;
    }

    private boolean isUrlValid(String url) throws MalformedURLException, URISyntaxException {
        new URI(url).toURL();
        return !url.isEmpty();
    }

    public Integer getMetrics(Integer linkId) throws LinkNotFoundException {
        if (linkRepository.findById(linkId) == null)
            throw new LinkNotFoundException("A link with id: " + linkId + " does not exists");
        Link link = linkRepository.findById(linkId);
        return link.getTimesUsed();
    }

}
