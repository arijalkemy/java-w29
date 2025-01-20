package org.melibootcamp.url_ejercicio.repository;

import org.melibootcamp.url_ejercicio.entity.Url;

import java.util.Optional;

public interface IUrlRepository {

    Optional<Url> saveUrl(Url url);
    Optional<Url> findById(Integer id);
    Integer deleteUrl(Integer id);
}
