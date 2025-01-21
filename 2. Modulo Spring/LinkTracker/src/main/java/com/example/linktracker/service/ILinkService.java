package com.example.linktracker.service;

import com.example.linktracker.dto.request.LinkDto;
import com.example.linktracker.dto.response.SuccessLinkDto;

public interface ILinkService {
     SuccessLinkDto create(LinkDto entity);
     LinkDto getLink(Integer id);
}
