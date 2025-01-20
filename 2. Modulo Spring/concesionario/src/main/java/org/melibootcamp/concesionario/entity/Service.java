package org.melibootcamp.concesionario.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private Integer id;
    private Double kilometers;
    private String descriptions;
}
