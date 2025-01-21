package meli.linktacker.service;

import meli.linktacker.dto.LinkDto;
import meli.linktacker.entity.Link;
import meli.linktacker.repository.ILinkRepository;

public interface ILinkService {

    Integer addLink(LinkDto linkDto);
    String getLink(Integer linkId, String password);
    Integer metricsForLink(Integer linkId);
    String invalidateLink(Integer linkId);
}
