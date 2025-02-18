package com.meli.ejerciciohql.repository;

import com.meli.ejerciciohql.model.DTO.VehicleDto;
import com.meli.ejerciciohql.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle,Long> {
    @Query("select v from Vehicle v where v.patente is not null ")
    List<Vehicle> getPatentes();
    @Query("select v from Vehicle v order by v.fabricacionAnio")
    List<Vehicle> getPatentesAnio();

}
