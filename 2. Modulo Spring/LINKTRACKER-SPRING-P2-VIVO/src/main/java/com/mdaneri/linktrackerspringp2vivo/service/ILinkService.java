package com.mdaneri.linktrackerspringp2vivo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdaneri.linktrackerspringp2vivo.dto.LinkDto;
import com.mdaneri.linktrackerspringp2vivo.entity.Link;
import com.mdaneri.linktrackerspringp2vivo.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ILinkService {


    List<LinkDto> findAll();
    LinkDto findById(String id);
    LinkDto save(LinkDto linkDto);
    LinkDto remove(String id);

}
