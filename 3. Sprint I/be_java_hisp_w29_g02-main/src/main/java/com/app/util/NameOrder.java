package com.app.util;

public enum NameOrder {

    NAME_ASC("name_asc"),
    NAME_DESC("name_desc");

    private final String value;

    NameOrder(String value) {
        this.value = value;
    }

    public static NameOrder fromValue(String value) {
        for (NameOrder order : NameOrder.values()) {
            if (order.getValue().equalsIgnoreCase(value)) {
                return order;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
