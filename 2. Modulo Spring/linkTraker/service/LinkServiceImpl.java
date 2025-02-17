package com.api.linkTraker.service;


import com.api.linkTraker.dto.LinkDto;
import com.api.linkTraker.entity.Link;
import com.api.linkTraker.exception.EntityNotFoundException;
import com.api.linkTraker.repository.ILinkRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService {

    private final ILinkRepository lr;

    public LinkServiceImpl(ILinkRepository lr) {
        this.lr = lr;
    }

    private void incrementCount(String linkId) {
        lr.incrementCount(linkId);
    }

    public List<LinkDto> findAll() {
        ObjectMapper om = new ObjectMapper();
        return lr.findAll()
                .stream()
                .map(link -> om.convertValue(link, LinkDto.class))
                .toList();
    }

    public LinkDto findById(String id) {
        ObjectMapper om = new ObjectMapper();
        Optional<Link> optionalLink = lr.findById(id);

        if (optionalLink.isEmpty())
            throw new EntityNotFoundException("Link not found by the id given!");

        incrementCount(optionalLink.get().getId());
        return om.convertValue(optionalLink.get(), LinkDto.class);
    }

    public LinkDto save(LinkDto linkDto) {
        ObjectMapper om = new ObjectMapper();
        Link link = lr.save(om.convertValue(linkDto, Link.class));
        return om.convertValue(link, LinkDto.class);
    }

    @Override
    public LinkDto remove(String id) {
        ObjectMapper om = new ObjectMapper();
        Optional<Link> optionalLink = lr.remove(id);

        if (optionalLink.isEmpty())
            throw new EntityNotFoundException("Link not found by the id given!");
        return om.convertValue(optionalLink.get(), LinkDto.class);
    }
}