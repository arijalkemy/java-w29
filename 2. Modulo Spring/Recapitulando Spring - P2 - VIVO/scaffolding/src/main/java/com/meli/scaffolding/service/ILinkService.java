package com.meli.scaffolding.service;

import com.meli.scaffolding.dto.LinkDTO;

public interface ILinkService {
  LinkDTO create(LinkDTO link);

  LinkDTO redirect(Integer linkId);

  LinkDTO redirect(Integer linkId, String password);

  LinkDTO metrics(Integer linkId);

  void invalidate(Integer linkId);
}
