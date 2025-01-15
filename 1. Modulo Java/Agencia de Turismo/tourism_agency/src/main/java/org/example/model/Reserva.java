package org.example.model;

public class Reserva {

    private String type;
    private Double price;

    public Reserva(String type, Double price) {
        this.type = type;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
