package org.example.controller.repository;

import org.example.model.Beeper;
import org.example.model.Booking;
import org.example.model.Client;
import org.example.model.TypeBooking;

import java.util.*;
import java.util.stream.Collectors;

public class BeeperService {
    private final BeeperRepository beeperRepository;

    public BeeperService() {
        this(new BeeperRepository());
    }

    public BeeperService(BeeperRepository beeperRepository) {
        this.beeperRepository = beeperRepository;
    }

    public Beeper addBeeper(Client client, List<Booking> bookings) {
        List<Beeper> beepers = beeperRepository.getBeepersByClient(client.getDni());
        Beeper beeper = new Beeper(beeperRepository.getId(), client, bookings);
        beeper.validateAmountOfBookings();

        if (beepers.size() >= 2) {
            beeper.applyDiscount(0.05);
        }

        Set<TypeBooking> typeBookings = bookings.stream().map(Booking::getType).collect(Collectors.toSet());
        final List<TypeBooking> types = Arrays.asList(TypeBooking.values());
        if (typeBookings.containsAll(types)) {
            beeper.applyDiscount(0.1);
        }
        beeperRepository.add(beeper);
        return beeper;
    }

    public List<Beeper> getBeepersByClient(String dni) {
        return beeperRepository.getBeepersByClient(dni);
    }

    public List<Beeper> getAll() {
        return beeperRepository.getAll();
    }

    public double getTotalAllBeepers() {
        return beeperRepository.getAll().stream()
                .mapToDouble(Beeper::getPrice)
                .sum();
    }

    public Map<TypeBooking, List<Booking>> bookingsByType() {
        Map<TypeBooking, List<Booking>> listMap = new HashMap<>();

        List<TypeBooking> types = Arrays.asList(TypeBooking.values());
        types.forEach(type -> listMap.put(type, new ArrayList<>()));

        beeperRepository.getAll().forEach(beeper -> {
            beeper.getBookings().forEach(booking -> {
                listMap.get(booking.getType()).add(booking);
            });
        });

        return listMap;
    }
}
