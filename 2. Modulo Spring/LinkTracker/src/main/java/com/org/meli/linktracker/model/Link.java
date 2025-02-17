package com.org.meli.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Long id;
    private String originalUrl;
    private Integer redirectCount;
    private Boolean valid;
    private String password;
}
