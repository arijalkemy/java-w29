package org.example;

public class NotPerishable extends Product {

    //Attributes
    private String type;

    //Constructor
    public NotPerishable(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    //Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double calculate(int quantityOfProducts) {
        return super.calculate(quantityOfProducts);
    }

    @Override
    public String toString() {
        return "NotPerishable{" +
                "type='" + type + '\'' +
                '}';
    }
}
