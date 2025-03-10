package com.meli.concesionarioseguros.repository;

import com.meli.concesionarioseguros.entity.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehiculoRepository extends CrudRepository<Vehiculo, Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> findAllVehicularPatents(Integer minWheels, Integer year);
}
