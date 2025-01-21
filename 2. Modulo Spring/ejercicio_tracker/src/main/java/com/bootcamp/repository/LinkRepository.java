package com.bootcamp.repository;

import com.bootcamp.dto.LinkDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository {

    private final Map<Integer, LinkDto> database = new HashMap<>();

    @Override
    public LinkDto add(LinkDto link) {
        if (link.getLinkId() == null)
            link.setLinkId(database.size());
        database.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public Optional<LinkDto> findLinkById(Integer linkId) {
        LinkDto linkDTO = database.get(linkId);
        return Optional.ofNullable(linkDTO);
    }

    @Override
    public void remove(LinkDto linkDTO) {
        database.remove(linkDTO.getLinkId());
    }

}
