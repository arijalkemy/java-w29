package com.bootcamp.linktracker.dto;

public record LinkResponseBody(
        String id,
        String url,
        Integer visits
) {
}
