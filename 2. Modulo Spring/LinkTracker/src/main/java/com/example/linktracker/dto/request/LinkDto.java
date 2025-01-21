package com.example.linktracker.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LinkDto {
    private String url;
}
