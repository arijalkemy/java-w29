package com.calccal.calculadoracalorias.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredienteDTO {
    private String name;
    private int calories;
}
