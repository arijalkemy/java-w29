package com.example.repository;

import com.example.entities.Link;

import java.util.List;

public interface ILinkRepository {

    void save(Link link);
    Link findById(Integer id);
    List<Link> findAll();
    Boolean existsById(Integer id);
}
