package com.org.meli.linktracker.service;

import com.org.meli.linktracker.dto.LinkDto;
import com.org.meli.linktracker.model.Link;

import java.util.List;
import java.util.Optional;

public interface ILinkService {
    LinkDto createLink(String url, String password);
    String getRedirectUrlResponse(Long id, String password);
    LinkDto getMetricsResponse(Long id);
    String invalidateLinkResponse(Long id);
    List<LinkDto> getAllLinks();
}
