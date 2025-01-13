package org.example.model;

public class Vehicle {
    /**
     * Attributes
     */
    private String model;
    private String brand;
    private double price;

    /**
     * Constants
     */
    public Vehicle(String brand, String model, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    /**
     * Getters and setters
     */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
