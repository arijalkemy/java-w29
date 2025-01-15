package com.example.links.services;

import com.example.links.DTOs.LinkCreateDTO;
import com.example.links.DTOs.LinkDTO;
import com.example.links.entity.Link;

public interface ILinkService {
    public Integer createLink(LinkCreateDTO link);
    public LinkDTO getLink(Integer id);
    public void incrementCount(Integer linkId);
}
