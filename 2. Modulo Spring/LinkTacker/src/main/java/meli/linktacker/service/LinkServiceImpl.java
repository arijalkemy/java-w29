package meli.linktacker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.linktacker.dto.LinkDto;
import meli.linktacker.entity.Link;
import meli.linktacker.exception.InvalidUrlException;
import meli.linktacker.exception.NotFoundException;
import meli.linktacker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    ILinkRepository repository;

    @Override
    public Integer addLink(LinkDto linkDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Link link = objectMapper.convertValue(linkDto, Link.class);
        String regex = "<\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]>";
        if (link.getLink().matches(regex))
            throw new InvalidUrlException("url mal formada");
        return repository.addLink(link);

    }

    @Override
    public String getLink(Integer linkId) {
        Optional<Link> link = repository.getLink(linkId);
        if (link.isEmpty()){
            throw new NotFoundException("url no encontrada");
        }
        addView(link.get());
        return link.get().getLink();
    }

    @Override
    public Integer getViews(Integer linkId) {
        Optional<Link> link = repository.getLink(linkId);
        if (link.isEmpty()){
            throw new NotFoundException("url no encontrada");
        }
        return link.get().getViews();
    }

    @Override
    public Void invalidateLink(Integer linkId) {
        Optional<Link> link = repository.getLink(linkId);
        if (link.isEmpty()){
            throw new NotFoundException("url no encontrada");
        }
        repository.removeLink(link.get());
        return null;
    }

    public void addView(Link link){
        Integer newViews = link.getViews()+1;
        repository.updateViews(link, newViews);
    }
}
