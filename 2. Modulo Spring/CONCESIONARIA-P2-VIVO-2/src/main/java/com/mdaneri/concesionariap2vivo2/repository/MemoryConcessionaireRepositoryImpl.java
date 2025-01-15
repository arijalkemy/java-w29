package com.mdaneri.concesionariap2vivo2.repository;

import com.mdaneri.concesionariap2vivo2.entity.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class MemoryConcessionaireRepositoryImpl implements IConcessionaireRepository {

    private List<Car> carsList;
    private Integer maxId;

    public MemoryConcessionaireRepositoryImpl() {
        this.carsList = new ArrayList<>();
        maxId = 0;
    }

    public List<Car> findAll() {
        return carsList;
    }

    public Optional<Car> findById(Integer id) {
        return carsList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Optional<Car> save(Car car) {
        car.setId(maxId++);
        carsList.add(car);
        return Optional.of(car);
    }

    public List<Car> findByPrice(Integer from, Integer to) {
        return carsList
                .stream()
                .filter(c -> from <= c.getPrice() && c.getPrice() <= to )
                .toList();
    }

    public List<Car> findByDate(LocalDate from, LocalDate to) {
        return carsList
                .stream()
                .filter(c -> from.isBefore(c.getManufacturingDate()) && c.getManufacturingDate().isBefore(to))
                .toList();
    }




}
