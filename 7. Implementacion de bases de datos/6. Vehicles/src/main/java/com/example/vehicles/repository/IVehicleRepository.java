package com.example.vehicles.repository;

import com.example.vehicles.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
    // Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patent FROM Vehicle v")
    List<String> getAllPatents();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patent, v.brand FROM Vehicle v ORDER BY v.yearManufacture")
    List<Object[]> getAllPatentsAndBrandsOrderByYear();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("SELECT v.patent FROM Vehicle v WHERE v.wheels = 4 AND v.yearManufacture = 2025")
    List<Object[]> getPatentsFromVehiclesWithFourWheelsAndCurrentYear();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v.patent, v.brand, v.model FROM Vehicle v JOIN v.accidents a WHERE size(v.accidents) = 1 AND a.economicLoss > 10000")
    List<Object[]> getPatentBrandModelVehiclesWithOneAccidentAndLoss();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT v.patent, v.brand, v.model, SUM(a.economicLoss) FROM Vehicle v JOIN v.accidents a WHERE size(v.accidents) = 1 AND a.economicLoss > 10000 GROUP BY v.patent, v.brand, v.model")
    List<Object[]> getPatentBrandModelVehiclesWithOneAccidentAndLossAndSum();
}
