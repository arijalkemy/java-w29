package com.bootcamp.repository;

import com.bootcamp.dto.LinkDto;

import java.util.Optional;

public interface ILinkRepository {

    LinkDto add(LinkDto link);

    Optional<LinkDto> findLinkById(Integer linkId);

    void remove(LinkDto linkDTO);

}
