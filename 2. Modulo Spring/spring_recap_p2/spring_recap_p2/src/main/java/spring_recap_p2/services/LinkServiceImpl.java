package spring_recap_p2.services;

import java.net.URI;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soundicly.jnanoidenhanced.jnanoid.NanoIdUtils;

import spring_recap_p2.dtos.createLinkDTO.RequestDTOCreateLink;
import spring_recap_p2.dtos.createLinkDTO.ResponseDTOCreateLink;
import spring_recap_p2.dtos.linkMetricsDTO.ResponseDTOMetricsLink;
import spring_recap_p2.entities.Link;
import spring_recap_p2.exceptions.IncorrectPasswordException;
import spring_recap_p2.repositories.ILinkRepository;

@Service
public class LinkServiceImpl implements ILinkService {
  @Autowired
  private ILinkRepository link_repository;

  public ResponseDTOCreateLink createLink(RequestDTOCreateLink request_dto){
    String url = request_dto.getUrl();
    String regex = "^(http|https)://.*$";
    if(!url.matches(regex)) throw new IllegalArgumentException("Invalid URL");
    ObjectMapper mapper = new ObjectMapper();
    Link new_link = mapper.convertValue(request_dto, Link.class);
    new_link.setLink_id(NanoIdUtils.randomNanoId(4));
    if(!link_repository.addLink(new_link))
      throw new IllegalArgumentException("Link already exists");
    return mapper.convertValue(new_link, ResponseDTOCreateLink.class);
  }

  public URI redirect(String link_id, String password){
    Optional<Link> link = link_repository.getLink(link_id);
    if(link.isEmpty()) throw new NoSuchElementException("Investigar Redirect");
    Link link_obj = link.get();
    if(link_obj.getPassword() != "" &&
      (password == null || !link_obj.getPassword().matches(password))
    ) throw new IncorrectPasswordException("Incorrect password");
    link_obj.setRedirects(link_obj.getRedirects() + 1);
    return URI.create(link_obj.getUrl());
  }

  @Override
  public ResponseDTOMetricsLink linkMetrics(String link_id) {
    Optional<Link> link = link_repository.getLink(link_id);
    if(link.isEmpty()) throw new NoSuchElementException("Link no encontrado");
    ObjectMapper mapper = new ObjectMapper();
    return mapper.convertValue(link.get(), ResponseDTOMetricsLink.class);
  }

  @Override
  public String deleteLink(String link_id) {
    if(!link_repository.deleteLink(link_id))
      throw new NoSuchElementException("Link no encontrado");
    return "Link invalidado";
  }
}
