package org.melibootcamp.url_ejercicio.repository;

import org.melibootcamp.url_ejercicio.entity.Url;

import java.util.Optional;

public interface IUrlRepository {

    Optional<Url> saveUrl(Url url);

    Optional<Url> saveUrlWithPassword(Url url, String password);

    Optional<Url> findById(Integer id);

    void addVisit(Integer id);

    void deleteUrl(Integer id);
}
