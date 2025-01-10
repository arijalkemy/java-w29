package org.example.model;

public enum BookingType {
    HOTEL("Hotel"),
    TICKET("Ticket"),
    FOOD("Food"),
    TRANSPORT("Transport");

    private final String type;

    BookingType(String type) {
        this.type = type;
    }
}
