package com.app.util;

public enum DateOrder {

    DATE_ASC("date_asc"),
    DATE_DESC("date_desc");

    private final String value;

    DateOrder(String value) {
        this.value = value;
    }

    public static DateOrder fromValue(String value) {
        for (DateOrder order : DateOrder.values()) {
            if (order.getValue().equalsIgnoreCase(value)) {
                return order;
            }
        }
        return DATE_DESC;
    }

    public String getValue() {
        return value;
    }
}
