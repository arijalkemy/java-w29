package com.org.meli.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkDto {
    private Long id;
    private String originalUrl;
    private Integer redirectCount;
}
