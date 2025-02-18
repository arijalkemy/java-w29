package com.autos.empresaseguros.repository;

import com.autos.empresaseguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("FROM Vehiculo v")
    List<Vehiculo> findPatente();
}
