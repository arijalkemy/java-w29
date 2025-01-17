package com.meli.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private Integer cantidadConsulta;

    public Link(String url, Integer cantidadConsulta) {
        this.url = url;
        this.cantidadConsulta = cantidadConsulta;
    }
}
