package com.autos.empresaseguros.repository;

import com.autos.empresaseguros.model.Vehiculo;
import com.autos.empresaseguros.model.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    @Query("FROM Vehiculo v")
    List<Vehiculo> findPatente();
    @Query("FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Vehiculo> findAllByPatentAndBrand();
    @Query("FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = YEAR(CURRENT_DATE)")
    List<Vehiculo> findAllByPatentWithWheels();
    @Query("FROM Vehiculo v JOIN v.siniestro s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findAllByPatentWithLoss();
    @Query("select v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) " +
            "from Vehiculo v join v.siniestro s " +
            "where s.perdidaEconomica > 10000 " +
            "group by v.patente, v.marca, v.modelo")
    List<Object[]> findVehiclesWithLossMayorTo10000();
}
