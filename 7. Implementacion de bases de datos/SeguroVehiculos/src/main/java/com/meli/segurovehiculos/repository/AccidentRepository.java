package com.meli.segurovehiculos.repository;

import com.meli.segurovehiculos.model.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    @Query("SELECT v.plate, v.brand, v.model FROM Accident a RIGHT JOIN a.vehicle v WHERE a.economicLoss > 10000")
    List<Object[]> findAccidentVehicles();


    @Query("SELECT v.plate, v.brand, v.model, sum(a.economicLoss) FROM Accident a RIGHT JOIN a.vehicle v WHERE a.economicLoss > 10000 GROUP BY v.plate, v.brand, v.model")
    List<Object[]> findAccidentVehiclesEconomicLoss();
}
