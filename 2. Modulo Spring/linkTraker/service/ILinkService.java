package com.api.linkTraker.service;

import com.api.linkTraker.dto.LinkDto;
import java.util.List;

public interface ILinkService {
    List<LinkDto> findAll();
    LinkDto findById(String id);
    LinkDto save(LinkDto linkDto);
    LinkDto remove(String id);

}