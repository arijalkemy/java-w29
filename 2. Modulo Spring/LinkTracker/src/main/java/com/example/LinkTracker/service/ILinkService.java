package com.example.LinkTracker.service;

import com.example.LinkTracker.dto.LinkDTO;

public interface ILinkService {
    Integer createLink(LinkDTO link);

    String redirect(Integer linkId);

    Integer stats(Integer linkId);

    void invalidate(Integer linkId);
}
