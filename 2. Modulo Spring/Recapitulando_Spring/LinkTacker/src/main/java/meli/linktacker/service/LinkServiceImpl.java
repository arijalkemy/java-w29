package meli.linktacker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.linktacker.dto.LinkDto;
import meli.linktacker.entity.Link;
import meli.linktacker.exception.BadRequestException;
import meli.linktacker.exception.InvalidUrlException;
import meli.linktacker.exception.UnauthorizedException;
import meli.linktacker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Service
public class LinkServiceImpl implements ILinkService{

    @Autowired
    ILinkRepository repository;

    @Override
    public Integer addLink(LinkDto linkDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Link link = objectMapper.convertValue(linkDto, Link.class);
        try {
            URL url = new URL(linkDto.getLink());
        }catch (MalformedURLException e){
            throw new InvalidUrlException("url mal formada");
        }
        return repository.addLink(link);
    }

    @Override
    public String getLink(Integer linkId, String password) {
        Optional<Link> link = repository.getLink(linkId);
        if(link.isEmpty()){
            throw new InvalidUrlException("url no existe");
        }
        if (!link.get().getPassword().equals(password)){
            throw new UnauthorizedException("password incorrecto");
        }
        if(link.get().getInvalid()!=null){
            throw new BadRequestException("El link ha sido invalidado");
        }
        if (link.get().getViews() == null) {
            link.get().setViews(1);
        } else {
            link.get().setViews(link.get().getViews() + 1);
        }

        return link.get().getLink();
    }

    @Override
    public Integer metricsForLink(Integer linkId) {
        return repository.metricsForLink(linkId);
    }

    @Override
    public String invalidateLink(Integer linkId) {
        repository.invalidateLink(linkId);
        return "link invalidado correctamente";
    }


}
