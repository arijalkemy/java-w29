package org.melibootcamp.url_ejercicio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    private Integer id;
    private String url;
    private Integer visits;
    private String password;
}
