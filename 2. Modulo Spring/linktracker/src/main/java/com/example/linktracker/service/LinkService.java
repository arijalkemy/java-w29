package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.entity.Link;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.repository.LinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements  ILinkService{

    @Autowired
    private LinkRepository linkRepository;


    @Override
    public LinkDto saveLink(LinkDto linkDto) {
        ObjectMapper mapper = new ObjectMapper();
        Link newLink = mapper.convertValue(linkDto, Link.class);
        linkRepository.saveLink(newLink);
        return mapper.convertValue(newLink, LinkDto.class);
    }

    public Integer getMetrics(Integer id){
        Optional<Link> linkOptional = linkRepository.findLinkById(id);
        if (linkOptional.isEmpty()){
            throw new LinkNotFoundException("No se encontró el link con ID: "+id);
        }
        return linkOptional.get().getVisits();
    }

    @Override
    public LinkDto findById(Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Link> linkOptional = linkRepository.findLinkById(id);
        if (linkOptional.isEmpty()){
            throw new LinkNotFoundException("No se encontró el link con ID: "+id);
        }
        return mapper.convertValue(linkOptional.get(), LinkDto.class);
    }

    @Override
    public Boolean invalidateLink(Integer id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Link> linkOptional = linkRepository.findLinkById(id);
        if (linkOptional.isEmpty()){
            throw new LinkNotFoundException("No se encontró el link con ID: "+id);
        }
        linkRepository.invalidateLink(mapper.convertValue(linkOptional.get(), Link.class));
        return true;
    }


}
