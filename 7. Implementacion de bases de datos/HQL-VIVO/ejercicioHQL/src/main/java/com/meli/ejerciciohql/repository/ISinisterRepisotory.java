package com.meli.ejerciciohql.repository;

import com.meli.ejerciciohql.model.Sinister;
import com.meli.ejerciciohql.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISinisterRepisotory extends JpaRepository<Sinister, Long> {
    @Query("select v from Vehicle v inner join Sinister s on s.vehicle = v where s.perdidaEconomica > 10000 ")
    List<Vehicle> getSinisterPerdeidaMayor();
}
