package com.example.linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkMetricsDto {
    private String url;
    private Integer visitCounter;
    private Integer visitTotal;
    private Double average;
}
