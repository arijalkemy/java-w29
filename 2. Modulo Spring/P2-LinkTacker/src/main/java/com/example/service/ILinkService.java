package com.example.service;

import com.example.dto.LinkDto;

import java.util.List;

public interface ILinkService {

   LinkDto agregarLink(LinkDto linkDto);
   LinkDto getLinkById(Integer id);
   List<LinkDto> getAllLinks();
   LinkDto redireccionar(Integer linkId);
   LinkDto invalidateLink(Integer linkId);
}
