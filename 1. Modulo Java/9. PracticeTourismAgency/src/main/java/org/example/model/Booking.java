package org.example.model;

public class Booking {
    /**
     * Attributes
     */
    private Long id;
    private TypeBooking type;
    private double price;

    /**
     * Constructor
     * @param id Identification of booking
     * @param type Type of booking (4 options)
     * @param price Price of booking
     */
    public Booking(Long id, TypeBooking type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    /**
     * Getters and setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeBooking getType() {
        return type;
    }

    public void setType(TypeBooking type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking ==== " +
                "Id: " + id + '\n' +
                "Type: " + type +
                "\nPrice: " + price;
    }
}
