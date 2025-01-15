package com.mdaneri.linktrackerspringp2vivo.repository;


import com.mdaneri.linktrackerspringp2vivo.entity.Link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ILinkRepository {

    List<Link> findAll();
    Optional<Link> findById(String id);
    Link save(Link link);
    Optional<Link> remove(String id);

    void incrementCount(String id);

}
