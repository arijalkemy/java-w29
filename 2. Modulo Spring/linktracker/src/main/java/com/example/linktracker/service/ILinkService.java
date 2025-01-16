package com.example.linktracker.service;

import com.example.linktracker.dto.LinkDto;
import com.example.linktracker.entity.Link;

public interface ILinkService {

    LinkDto saveLink(LinkDto linkDto);
    Integer getMetrics(Integer id);
    LinkDto findById(Integer id);
    Boolean invalidateLink(Integer id);

}
