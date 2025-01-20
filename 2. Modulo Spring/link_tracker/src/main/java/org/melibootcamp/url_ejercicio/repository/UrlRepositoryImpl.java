package org.melibootcamp.url_ejercicio.repository;

import org.melibootcamp.url_ejercicio.entity.Url;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UrlRepositoryImpl implements IUrlRepository{

    private Map<Integer, Url> urls = new HashMap<>();

    @Override
    public Optional<Url> saveUrl(Url url) {
        url.setId(urls.size() + 1);
        urls.put(urls.size() + 1,url);
        return Optional.of(url);
    }

    @Override
    public Optional<Url> findById(Integer id) {
        return Optional.ofNullable(urls.get(id));
    }

    @Override
    public Integer deleteUrl(Integer id) {
        if (urls.containsKey(id)){
            urls.remove(id);
            return id;
        }
        return null;
    }
}
