package org.bootcamp.recapitulandospringp2.entity;

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
    private boolean valid;

    public Link(String url) {
        this.url = url;
        this.cantidadConsulta = 0;
        this.valid = true;
    }
}
