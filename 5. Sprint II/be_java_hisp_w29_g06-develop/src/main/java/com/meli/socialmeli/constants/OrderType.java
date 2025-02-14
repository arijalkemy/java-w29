package com.meli.socialmeli.constants;

public enum OrderType {
    NOT_FOUND(0),
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
            return NOT_FOUND;
        }

        return switch (str) {
            case "date_asc" -> ASCENDING;
            case "date_desc" -> DESCENDING;
            case "name_asc" -> ASCENDING;
            case "name_desc" -> DESCENDING;
            default -> NOT_FOUND;
        };
    }
}
