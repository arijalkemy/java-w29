package com.meli.seguroDeAutos.repository;

import com.meli.seguroDeAutos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    @Query("select v from Vehiculo v where v.patente = :patente")
    Optional<Vehiculo> findVehiculoByPatente(@Param("patente") Long patente);

    @Query("select v.patente from Vehiculo v")
    List<Long> findAllPatentes();

    @Query("select v.patente, v.marca from Vehiculo v order by v.yearDeFabricacion")
}
