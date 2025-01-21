package com.bootcamp.service;

import com.bootcamp.dto.LinkDto;

public interface ILinkService {

    LinkDto add(LinkDto link);

    LinkDto redirect(Integer linkId);

    LinkDto redirect(Integer linkId, String password);

    LinkDto metrics(Integer linkId);

    void invalidate(Integer linkId);
}
