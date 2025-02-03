package com.meli.socialmeli.constants;

public enum OrderType {
    ASCENDING(1),
    DESCENDING(2);

    private final int value;

    OrderType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static OrderType fromString(String str) {
        if (str == null) {
            return DESCENDING;
        }
        return switch (str) {
            case "date_asc" -> ASCENDING;
            case "date_desc" -> DESCENDING;
            default -> DESCENDING;
        };
    }
}