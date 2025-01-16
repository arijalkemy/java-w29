package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.dto.IdDTO;
import com.bootcamp.linkTracker.dto.LinkDTO;
import com.bootcamp.linkTracker.dto.MetricDTO;
import com.bootcamp.linkTracker.entitiy.Link;
import com.bootcamp.linkTracker.exception.InvalidLinkException;
import com.bootcamp.linkTracker.exception.PasswordException;
import com.bootcamp.linkTracker.repository.ILinkTrackerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
@RequiredArgsConstructor
public class LinkTrackerService implements ILinkTrackerService{

    private final ILinkTrackerRepository repository;

    @Override
    public IdDTO createLink(LinkDTO request) {
        validateLink(request.getLink());
        Link link = new Link(request.getLink());
        Integer id = repository.save(link);
        return new IdDTO(id);
    }

    private void validateLink(String link){
        String regex = "[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)";
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(link);
        if(!matcher.matches())
            throw new InvalidLinkException("El link no es valido");
    }

    @Override
    public LinkDTO getLinkToRedirectById(Integer id, String password){
        Link link = getActiveLinkByid(id);
        verifyPassword(link, password);
        addUses(link);
        return new LinkDTO(link.getLink());
    }

    private Link getActiveLinkByid(Integer id){
        Optional<Link> oLink = repository.getActiveLink(id);
        if(oLink.isEmpty())
            throw new InvalidLinkException("El link no es valido");

        return oLink.get();
    }

    private void verifyPassword(Link link, String password){
        if(!link.getPassword().equals(password))
            throw new PasswordException("La contraseña es incorrecta");
    }

    private void addUses(Link link){
        Integer uses = link.getUses();
        link.setUses(++uses);
        repository.save(link);
    }

    @Override
    public MetricDTO getMetricsById(Integer id) {
        Link link = getLinkById(id);
        return new MetricDTO(link.getLink(), link.getUses());
    }

    private Link getLinkById(Integer id){
        Optional<Link> oLink = repository.getLink(id);
        if(oLink.isEmpty())
            throw new InvalidLinkException("El link no se encontro");

        return oLink.get();
    }

    @Override
    public void invalidateLinkById(Integer id) {
        Link link = getLinkById(id);
        invalidateLink(link);
    }

    private void invalidateLink(Link link){
        link.setValid(false);
        repository.save(link);
    }
}
