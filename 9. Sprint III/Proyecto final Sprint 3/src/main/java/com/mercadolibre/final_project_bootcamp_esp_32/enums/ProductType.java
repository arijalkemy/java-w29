package com.mercadolibre.final_project_bootcamp_esp_32.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductType {
    FS("Fresh"),
    RF("Refrigerated"),
    FF("Frozen");

    private final String description;
}
