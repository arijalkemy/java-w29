package com.thiagoschreck.local.link_tracker.repository;

import com.thiagoschreck.local.link_tracker.entity.Link;

public interface ILinkRepository {
    Link save(Link link);

    Link findById(int linkId);

    Link update(Integer linkId, Link link);
}
