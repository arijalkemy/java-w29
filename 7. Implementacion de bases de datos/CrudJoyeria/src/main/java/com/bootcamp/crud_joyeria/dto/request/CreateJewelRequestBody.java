package com.bootcamp.crud_joyeria.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateJewelRequestBody(
        //@JsonProperty(value = "nombre")
        String name,
        //@JsonProperty(value = "material")
        String material,
        //@JsonProperty(value = "peso")
        String weight,
        //@JsonProperty(value = "particularidad")
        String feature,
//        @JsonProperty(value = "posee_piedra")
        boolean hasStone,
//        @JsonProperty(value = "ventaONo")
        boolean sellable
) {
}
