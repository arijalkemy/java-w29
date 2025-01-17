package meli.linktacker.service;

import meli.linktacker.dto.LinkDto;
import meli.linktacker.entity.Link;
import meli.linktacker.repository.ILinkRepository;

public interface ILinkService {

    Integer addLink(LinkDto linkDto);
    String getLink(Integer linkId);

    Integer getViews(Integer linkId);

    Void invalidateLink(Integer linkId);

}
