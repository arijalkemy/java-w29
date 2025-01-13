package service;

import model.Beeper;
import enums.Products;
import model.Booking;
import model.Client;
import repository.BeeperRepositoryImpl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.List;

public class BeeperService {
    private final BeeperRepositoryImpl beeperRepository;

    public BeeperService() {
        this.beeperRepository = new BeeperRepositoryImpl();
    }


    private Boolean isFullPackage(Beeper beeper) {
        Set<Products> produts = beeper.getBookingList()
                .stream()
                .map(Booking::getType)
                .collect(Collectors.toSet());

        return produts.containsAll(Set.of(Products.HOTEL, Products.FOOD, Products.TICKET, Products.TRANSPORT));
    }

    private Long getQuantityOf(Products product, Beeper beeper) {
        return beeper.getBookingList()
                .stream()
                .filter(booking -> booking.getType().equals(product))
                .count();
    }

    public Beeper createBeeper(Client client, List<Booking> bookingList) {
        List<Beeper> beepers = this.beeperRepository.findByClientId(client.getId());
        Beeper newBeeper = new Beeper(client, bookingList);


        if (beepers.size() >= 2) {
            newBeeper.applyDiscount(0.05);
        }
        if (isFullPackage(newBeeper)) {
            newBeeper.applyDiscount(0.10);
        }
        if (getQuantityOf(Products.HOTEL, newBeeper) >= 2 || getQuantityOf(Products.TICKET, newBeeper) >= 2) {
            newBeeper.applyDiscount(0.05);
        }

        beeperRepository.save(newBeeper);

        return newBeeper;
    }

    public Integer getQuantityOfBeepersSold() {
        return beeperRepository.getAll().size();
    }

    private List<Booking> getBookings() {
        return beeperRepository.getAll().stream()
                .flatMap(beeper -> beeper.getBookingList().stream()).toList();
    }

    public Integer getTotalBookings() {
        return getBookings().size();
    }


    public Map<Products, List<Booking>> getBookingsByType() {
        return getBookings().stream()
                .collect(Collectors.groupingBy(Booking::getType));
    }

    public Double getTotal() {
        return this.beeperRepository.getAll().stream()
                .mapToDouble(Beeper::getTotal)
                .average()
                .orElse(0.0);
    }

    public Double getAverage() {
        return this.beeperRepository.getAll().stream()
                .mapToDouble(Beeper::getTotal)
                .average()
                .orElse(0.0);
    }
}
