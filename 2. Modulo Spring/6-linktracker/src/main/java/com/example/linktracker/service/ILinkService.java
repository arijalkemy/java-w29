package com.example.linktracker.service;

import com.example.linktracker.dto.request.LinkDtoIn;
import com.example.linktracker.dto.response.LinkAllDtoOut;
import com.example.linktracker.dto.response.LinkDtoOut;
import com.example.linktracker.dto.response.LinkMetricsDto;

import java.net.MalformedURLException;
import java.util.List;

public interface ILinkService {
    String redirectLinkById(Integer linkId, String password);

    LinkDtoOut addLink(LinkDtoIn linkDtoIn) throws MalformedURLException;

    Boolean updateVisitCounter(Integer linkId);

    Boolean updateValidUrl(Integer linkId, boolean b);

    List<LinkAllDtoOut> searchAll();

    LinkMetricsDto getMetrics(Integer linkId);

    Boolean invalidateById(Integer linkId);
}
