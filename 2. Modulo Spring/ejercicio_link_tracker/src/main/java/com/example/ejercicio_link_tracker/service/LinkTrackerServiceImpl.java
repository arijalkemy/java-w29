package com.example.ejercicio_link_tracker.service;

import com.example.ejercicio_link_tracker.dto.*;
import com.example.ejercicio_link_tracker.entity.Link;
import com.example.ejercicio_link_tracker.repository.ILinkTrackerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.InvalidUrlException;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.*;

@RequiredArgsConstructor
@Service
public class LinkTrackerServiceImpl implements ILinkTrackerService {
    private final ILinkTrackerRepository linkTrackerRepository;

    @Override
    public ResponseLinkDTO createLink(RequestLinkDTO newLink) {
        String regex = "^(https?)://[^\\s/$.?#].\\S*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(newLink.getUrl());
        if(!matcher.matches()){
            throw new InvalidUrlException("La URL " + newLink.getUrl() + " no es válida.");
        }
        ObjectMapper om = new ObjectMapper();
        Link link = om.convertValue(newLink, Link.class);
        linkTrackerRepository.addLink(link);
        return new ResponseLinkDTO(link.getId());
    }

    @Override
    public ResponseLinkDTO getById(Integer id) {
        Optional<Link> oLink = linkTrackerRepository.getById(id);
        if(oLink.isEmpty()){
            throw new NoSuchElementException("La url con id " + id + " no es válida.");
        }
        Link link = oLink.get();
        link.setCountAccessed(link.getCountAccessed() + 1);
        return link.getUrl();
    }
}
