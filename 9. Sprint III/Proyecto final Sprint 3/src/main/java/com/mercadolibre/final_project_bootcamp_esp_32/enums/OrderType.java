package com.mercadolibre.final_project_bootcamp_esp_32.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {
    BATCH_NUMBER("L"),
    CURRENT_QUANTITY("C"),
    DUE_DATE("F");

    private final String value;

    public static OrderType fromString(String value) {
        for (OrderType order : OrderType.values()) {
            if (order.getValue().equalsIgnoreCase(value)) {
                return order;
            }
        }
        throw new IllegalArgumentException("Invalid order value: " + value);
    }
}
