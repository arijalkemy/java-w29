package com.example.ejercicio_link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseLinkDTO {
    private Long id;
    private String url;
    private Integer countAccessed;
}
