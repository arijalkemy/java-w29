package com.example.links.services;

import com.example.links.DTOs.LinkCreateDTO;
import com.example.links.DTOs.LinkDTO;
import com.example.links.entity.Link;
import com.example.links.repositories.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    LinkRepository linkRepository;

    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Integer createLink(LinkCreateDTO linkDTO) {
        linkRepository.addLink(new Link(linkDTO.getId(),linkDTO.getUrl(),0,linkDTO.getPassword()));
        return linkDTO.getId();
    }

    @Override
    public LinkDTO getLink(Integer id) {
        return null;
    }

    @Override
    public void incrementCount(Integer linkId) {

    }


}
