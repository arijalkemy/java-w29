package org.example.service;

import org.example.model.Booking;
import org.example.model.BookingType;
import org.example.model.Client;
import org.example.model.Locator;
import org.example.repository.LocatorRepository;

import java.util.Arrays;
import java.util.List;

public class LocatorService {

    private LocatorRepository repository;

    public LocatorService() {
        repository = new LocatorRepository();
    }

    public void save(Client client, List<Booking> bookings) {
        Double totalPrice = calculateTotalPrice(client.getId(), bookings);
        Locator locator = new Locator(client, bookings, totalPrice);
        repository.save(locator);
    }

    private Double calculateTotalPrice(Long id, List<Booking> bookings) {
        double totalDiscount = 0.0;
        if (repository.findByClientId(id).size() >= 2) {
            totalDiscount += 5.0;
        }
        if (isFullBooking(bookings)) {
            totalDiscount += 10.0;
        }
        if (getCountTypeBooking(bookings, BookingType.HOTEL) >= 2 || getCountTypeBooking(bookings, BookingType.TICKET) >= 2) {
            totalDiscount += 5.0;
        }
        double totalPrice = bookings.stream().mapToDouble(Booking::getPrice).sum();
        return totalPrice * (100 - totalDiscount) / 100;
    }

    private int getCountTypeBooking(List<Booking> bookings, BookingType bookingType) {
        return (int) bookings.stream().filter(b -> b.getBookingType() == bookingType).count();
    }

    private boolean isFullBooking(List<Booking> bookings) {
        List<BookingType> actualBookingTypes = bookings.stream().map(Booking::getBookingType).toList();
        final List<BookingType> expectedBookingTypes = Arrays.stream(BookingType.values()).toList();
        return actualBookingTypes.containsAll(expectedBookingTypes);
    }

    public List<Locator> getLocators() {
        return repository.findAll();
    }
}
