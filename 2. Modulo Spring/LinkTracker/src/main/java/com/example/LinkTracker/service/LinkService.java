package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.LinkDTO;
import com.example.LinkTracker.exception.AlreadyExistsLinkException;
import com.example.LinkTracker.exception.LinkNotFoundException;
import com.example.LinkTracker.model.Link;
import com.example.LinkTracker.repository.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalRadioButtonUI;

@Service
@RequiredArgsConstructor
public class LinkService implements ILinkService{
    private final LinkRepository linkRepository;

    @Override
    public Integer createLink(LinkDTO link) {
        if(linkRepository.getLinkByUrl(link.url()).isPresent()){
            throw new AlreadyExistsLinkException("La URL ya existe");
        }
        return linkRepository.createLink(Link.convertFromDTO(link));
    }

    @Override
    public String redirect(Integer linkId) {
        if(isLinkExists(linkId)){
            throw new LinkNotFoundException("El link no existe");
        }
        return linkRepository.redirect(linkId);
    }

    @Override
    public Integer stats(Integer linkId) {
        if(isLinkExists(linkId)){
            throw new LinkNotFoundException("El link no existe");
        }
        return linkRepository.stats(linkId);
    }

    @Override
    public void invalidate(Integer linkId) {
        if(isLinkExists(linkId)){
            throw new LinkNotFoundException("El link no existe");
        }
        linkRepository.invalidate(linkId);
    }

    private boolean isLinkExists(Integer linkId){
        return linkRepository.getLinkById(linkId).isPresent();
    }
}
