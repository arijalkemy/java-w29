package org.example.model;

public class Item {
    /**
     * Attributes
     */
    private Long code;
    private String name;
    private int quantity;
    private double unitPrice;

    /**
     * Constructor
     */
    public Item(Long code, String name, int quantity, double unitPrice) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    /**
     * Getters and setters
     */
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item --" +
                "code= " + code +
                "\nname=" + name +
                "\nquantity=" + quantity +
                "\nunitPrice=" + unitPrice;
    }
}
