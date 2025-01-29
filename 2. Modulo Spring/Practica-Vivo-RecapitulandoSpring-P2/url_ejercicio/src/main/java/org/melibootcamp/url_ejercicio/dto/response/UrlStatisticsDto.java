package org.melibootcamp.url_ejercicio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlStatisticsDto {
    private Integer id;
    private String url;
    private Integer visits;
}
