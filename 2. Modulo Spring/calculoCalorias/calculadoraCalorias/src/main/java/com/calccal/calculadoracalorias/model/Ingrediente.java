package com.calccal.calculadoracalorias.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Ingrediente {
    private String name;
    private int calories;
}
