package model;

import enums.Products;

public class Booking {
    private Products type;
    private Double price;

    public Booking(Products type, Double price) {
        this.type = type;
        this.price = price;
    }

    public Products getType() {
        return type;
    }

    public void setType(Products type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "type=" + type +
                ", price=" + price +
                '}';
    }
}
