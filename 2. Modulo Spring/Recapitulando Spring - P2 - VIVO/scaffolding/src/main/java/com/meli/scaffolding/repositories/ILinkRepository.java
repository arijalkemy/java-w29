package com.meli.scaffolding.repositories;

import com.meli.scaffolding.dto.LinkDTO;

import java.util.Optional;

public interface ILinkRepository {
  LinkDTO save(LinkDTO link);

  Optional<LinkDTO> findLinkByLinkId(Integer linkId);

  void delete(LinkDTO linkDTO);
}
