package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RoomDTO {
    private String name;
    private Integer width;
    private Integer length;

    public Integer getSquareFeet() {
        if (width == null || length == null || width <= 0 || length <= 0) {
            return null;
        }
        return width * length;
    }
}
