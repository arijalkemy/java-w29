package org.example.linktracker.dtos;

import org.example.linktracker.entities.Link;

public record LinkIdDto(Long id) {

    public static LinkIdDto toDto(Link link) {
        return new LinkIdDto(link.getId());
    }

}
