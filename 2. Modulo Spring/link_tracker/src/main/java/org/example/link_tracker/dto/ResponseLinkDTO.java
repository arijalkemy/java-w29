package org.example.link_tracker.dto;

import lombok.AllArgsConstructor;

import lombok.Data;


@Data
@AllArgsConstructor
public class ResponseLinkDTO {
    private int id;
    private String url;
}
