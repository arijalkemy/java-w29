package com.example.Seguros_Autos.repository;

import com.example.Seguros_Autos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehículos
    @Query("SELECT v.Patente FROM Vehiculo v")
    List<String> findAllPatentes();

    // Listar patente y marca, ordenados por año de fabricación
    @Query("SELECT v.Patente, v.Marca FROM Vehiculo v ORDER BY v.AnioFabricacion ASC")
    List<Object[]> findPatenteAndMarcaOrderedByAnioFabricacion();

    // Listar patente de vehículos con más de cuatro ruedas y fabricados este año
    @Query("SELECT v.Patente FROM Vehiculo v WHERE v.CantidadDeRuedas > 4 AND v.AnioFabricacion = :anioFabricacion")
    List<String> findPatentesByMoreThanFourRuedasAndCurrentYear(Integer anioFabricacion);

    // Listar matrícula, marca y modelo de vehículos con siniestros con pérdida mayor a 10000 pesos
    @Query("SELECT v.Patente, v.Marca, v.Modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Object[]> findPatenteMarcaModeloBySiniestroWithLossGreaterThan10000();

    // Listar matrícula, marca y modelo de vehículos con siniestros de pérdida mayor a 10000 y mostrar la pérdida total
    @Query("SELECT v.Patente, v.Marca, v.Modelo, SUM(s.perdidaEconomica) " +
            "FROM Vehiculo v " +
            "JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.idVehiculo")
    List<Object[]> findPatenteMarcaModeloAndTotalLossBySiniestroWithLossGreaterThan10000();
}
