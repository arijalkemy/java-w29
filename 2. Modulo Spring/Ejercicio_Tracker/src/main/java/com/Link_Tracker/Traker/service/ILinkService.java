package com.Link_Tracker.Traker.service;

import com.Link_Tracker.Traker.dto.request.LinkDto;
import com.Link_Tracker.Traker.dto.response.LinkResponseDto;

public interface ILinkService {
    LinkResponseDto createLink(LinkDto linkDto);

    LinkResponseDto getLinkById(Integer id);
    void invalidateLink(Integer id);
}
