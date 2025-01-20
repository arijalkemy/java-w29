package com.bootcamp.link_tracker.service;

import com.bootcamp.link_tracker.dto.LinkPostResponseDTO;
import com.bootcamp.link_tracker.dto.LinkRequestDTO;
import com.bootcamp.link_tracker.exceptions.InvalidLinkException;
import com.bootcamp.link_tracker.exceptions.InvalidPasswordException;
import com.bootcamp.link_tracker.exceptions.LinkAlreadyExistsException;
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
        Link link = Link.builder().link(linkRequestDTO.getLink()).timesUsed(0).password(linkRequestDTO.getPassword()).build();
        isUrlValid(link);
        if (linkRepository.findLinkByName(link.getLink()).isPresent())
            throw new LinkAlreadyExistsException("Provided link already is present!");
        linkRepository.save(link);
        return LinkPostResponseDTO.builder().linkId(link.getLinkId()).build();
    }

    public Link redirectLink(Integer linkId, String password) throws LinkNotFoundException, MalformedURLException, URISyntaxException {
        Link link = linkRepository.findById(linkId);
        if (link == null)
            throw new LinkNotFoundException("A link with id: " + linkId + " does not exists");
        if (!link.getPassword().equals(password))
            throw new InvalidPasswordException("Invalid password :(");
        link.setTimesUsed(link.getTimesUsed() + 1);
        return link;
    }

    private void isUrlValid(Link link) {
        try {
            new URI(link.getLink()).toURL();
        } catch (MalformedURLException | URISyntaxException e) {
            throw new InvalidLinkException("Provided link is not valid");
        }
    }

    public Integer getMetrics(Integer linkId) throws LinkNotFoundException {
        if (linkRepository.findById(linkId) == null)
            throw new LinkNotFoundException("A link with id: " + linkId + " does not exists");
        Link link = linkRepository.findById(linkId);
        return link.getTimesUsed();
    }

    public void invalidateLink(Integer linkId) {
        if (linkRepository.findById(linkId) == null)
            throw new LinkNotFoundException("A link with id: " + linkId + " does not exists");
        linkRepository.invalidateLink(linkId);
    }

}
