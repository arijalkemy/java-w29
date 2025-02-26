package com.parteuno.integrador;

import java.util.Objects;

public class Booking {

    private Type  type;
    private Double cost;

    public Booking(Type  type, Double cost) {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return type == booking.type && Objects.equals(cost, booking.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, cost);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public enum Type {
        TICKET,
        TRANSPORT,
        FOOD,
        HOTEL
    }

    @Override
    public String toString() {
        return "Booking{" +
                "type=" + type +
                ", cost=" + cost +
                '}';
    }
}
