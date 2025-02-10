package org.example.linktracker.utisl;

import org.example.linktracker.dtos.LinkIdDto;
import org.example.linktracker.entities.Link;

public class Mapper {
    public static LinkIdDto toDto(Link link) {
        return new LinkIdDto(link.getId());
    }
}
