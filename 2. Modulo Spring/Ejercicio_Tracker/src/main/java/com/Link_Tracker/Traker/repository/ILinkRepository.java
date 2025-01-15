package com.Link_Tracker.Traker.repository;

import com.Link_Tracker.Traker.dto.response.LinkResponseDto;
import com.Link_Tracker.Traker.entity.Link;

import java.util.Optional;

public interface ILinkRepository {
    Link addLink(Link link);
    Optional<Link> getLinkById(Integer id);
    void invalidateLink(Integer id);

    Integer getNextId();
}
