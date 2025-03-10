package org.example.ej_siniestros.repository;


import org.example.ej_siniestros.dto.PatenteMarcaModeloDto;
import org.example.ej_siniestros.model.Vehiculo;
import org.example.ej_siniestros.projection.PatenteAndBrandProjection;
import org.example.ej_siniestros.projection.PatenteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    //    Listar las patentes de todos los vehículos registrados.
    @Query("SELECT  v.patente AS patent FROM Vehiculo v")
        List<PatenteProjection> findAllPatents();

    //    Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anio DESC")
    List<String> getAllPatentesAndBrandByAnio();

    //    Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
//    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas >= 4 AND v.anio  >= YEAR(current_date)")
//    List<String> getPatentesByWheelsAndCurrentYear();

    //    Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE  s.perdidaEconomica >= 10000")
    List<Vehiculo> findVehiclesWithAccidentEconomicLossGreaterThan10000();

    //    Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT  v.patente, v.marca, v.modelo, s.perdidaEconomica FROM Vehiculo v JOIN v.siniestros s WHERE  s.perdidaEconomica >= 10000 GROUP BY  v.patente,v.marca,v.modelo, s.perdidaEconomica")
    List<String> findVehiclesWithAccidentEconomicLossGreater();
}

