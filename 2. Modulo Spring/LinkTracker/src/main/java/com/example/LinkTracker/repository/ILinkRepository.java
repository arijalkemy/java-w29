package com.example.LinkTracker.repository;

import com.example.LinkTracker.model.Link;

import java.util.Optional;

public interface ILinkRepository {
    Integer createLink(Link link);

    Optional<Link> getLinkById(Integer linkId);

    Optional<Link> getLinkByUrl(String url);

    String redirect(Integer linkId);

    Integer stats(Integer linkId);

    Link invalidate(Integer linkId);
}
