package org.example.linktracker.services;

import org.example.linktracker.dtos.LinkUrlDto;
import org.example.linktracker.dtos.LinkIdDto;

public interface LinkService {
    LinkIdDto createLink(LinkUrlDto linkDtoRequest, String password);

    String redirect(Long linkId, String password);

    Integer getMetrics(Long linkId);

    Void invalidate(Long linkId);
}
