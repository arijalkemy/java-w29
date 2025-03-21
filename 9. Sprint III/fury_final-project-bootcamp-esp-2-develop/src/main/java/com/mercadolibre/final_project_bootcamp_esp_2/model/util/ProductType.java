package com.mercadolibre.final_project_bootcamp_esp_2.model.util;

public enum ProductType {
    FRESH,          // Products that do not require special refrigeration
    REFRIGERATED,   // Products that require a temperature between 0°C and 8°C
    FROZEN          // Products that require temperatures of -18°C or lower
}