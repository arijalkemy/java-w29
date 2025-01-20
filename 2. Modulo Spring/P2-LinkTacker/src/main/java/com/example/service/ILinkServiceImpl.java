package com.example.service;

import com.example.dto.LinkDto;
import com.example.entities.Link;
import com.example.exception.ConflictException;
import com.example.exception.NotFoundException;
import com.example.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ILinkServiceImpl implements ILinkService {

    ILinkRepository linkRepository;
    ObjectMapper objectMapper;
    public ILinkServiceImpl(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public LinkDto agregarLink(LinkDto linkDto) {
        if(linkRepository.existsById(linkDto.getId())) {
            throw new ConflictException("El link ya existe");
        }
        Link link = objectMapper.convertValue(linkDto, Link.class);
        linkRepository.save(link);
        return objectMapper.convertValue(link, LinkDto.class);
    }

    @Override
    public LinkDto getLinkById(Integer id) {
        Link link = linkRepository.findById(id);
        if(link == null) {
            throw new NotFoundException("El link no existe");
        }
        return objectMapper.convertValue(link, LinkDto.class);
    }

    @Override
    public List<LinkDto> getAllLinks() {
        return linkRepository.findAll().stream().map(link -> objectMapper.convertValue(link, LinkDto.class)).toList();
    }

    @Override
    public LinkDto redireccionar(Integer linkId) {
        Link link = linkRepository.findById(linkId);
        if(link == null) {
            throw new NotFoundException("El link no existe");
        }
        link.setContador(link.getContador() + 1);
        return objectMapper.convertValue(link, LinkDto.class);
    }

    @Override
    public LinkDto invalidateLink(Integer linkId) {
        Link link = linkRepository.findById(linkId);
        if(link == null) {
            throw new NotFoundException("El link no existe");
        }
        link.setValid(false);
        return objectMapper.convertValue(link, LinkDto.class);
    }


}
