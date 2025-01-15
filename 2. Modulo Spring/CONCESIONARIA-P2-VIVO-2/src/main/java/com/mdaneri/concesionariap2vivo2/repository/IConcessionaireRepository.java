package com.mdaneri.concesionariap2vivo2.repository;

import com.mdaneri.concesionariap2vivo2.entity.Car;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IConcessionaireRepository {

    List<Car> findAll();
    Optional<Car> findById(Integer id);
    Optional<Car> save(Car car);
    List<Car> findByPrice(Integer from, Integer to);
    List<Car> findByDate(LocalDate from, LocalDate to);

}
