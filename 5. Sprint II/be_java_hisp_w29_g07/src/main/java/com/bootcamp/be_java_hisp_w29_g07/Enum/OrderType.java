package com.bootcamp.be_java_hisp_w29_g07.Enum;

/**
 * The enum OrderType defines the sorting order options for queries.
 * It provides two types of sorting:
 * <ul>
 *     <li>{@link #ASC}: Ascending order (e.g., name ascending).</li>
 *     <li>{@link #DESC}: Descending order (e.g., name descending).</li>
 * </ul>
 */
public enum OrderType {
    /**
     * Ascending order
     */
    ASC("name_asc"),

    /**
     * Descending order
     */
    DESC("name_desc");

    /**
     * The string representation of the order type.
     */
    private final String orderType;

    /**
     * Instantiates a new OrderType with its string representation.
     *
     * @param orderType the string representation of the order type
     */
    OrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Gets the string representation of the order type.
     *
     * @return the order type as a string
     */
    public String getOrderType() {
        return orderType;
    }
}
