package com.bootcamp.service;

import com.bootcamp.dto.LinkDto;
import com.bootcamp.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;

    @Override
    public LinkDto add(LinkDto link) {
        return linkRepository.add(link);
    }

    @Override
    public LinkDto redirect(Integer linkId) {
        Optional<LinkDto> link = linkRepository.findLinkById(linkId);
        link.ifPresent(this::sumMetric);
        return link.orElse(null);
    }

    @Override
    public LinkDto redirect(Integer linkId, String password) {
        Optional<LinkDto> link = linkRepository.findLinkById(linkId);
        LinkDto result = null;
        if (link.isPresent())
            result = checkLinkAndPassword(password, link.get());
        return result;
    }

    private LinkDto checkLinkAndPassword(String password, LinkDto linkDTO) {
        LinkDto result = null;
        if (linkDTO.getPassword() != null && linkDTO.getPassword().equals(password)) {
            result = linkDTO;
            sumMetric(linkDTO);
        }
        return result;
    }

    private void sumMetric(LinkDto linkDTO) {
        linkDTO.sumCount();
        linkRepository.add(linkDTO);
    }

    @Override
    public LinkDto metrics(Integer linkId) {
        Optional<LinkDto> link = linkRepository.findLinkById(linkId);
        return link.orElse(null);
    }

    @Override
    public void invalidate(Integer linkId) {
        Optional<LinkDto> link = linkRepository.findLinkById(linkId);
        link.ifPresent(linkRepository::remove);
    }

}
