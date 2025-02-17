package com.bootcampw29.siniestros_autos.repository;

import com.bootcampw29.siniestros_autos.model.Vehicle;
import com.bootcampw29.siniestros_autos.projection.VehicleEconomicLossTotalProjection;
import com.bootcampw29.siniestros_autos.projection.VehiclePatentProjection;
import com.bootcampw29.siniestros_autos.projection.VehicleSummaryProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    @Query("SELECT v.id AS id, v.patent AS patent FROM Vehicle v")
    List<VehiclePatentProjection> findAllPatents();

    @Query("SELECT v.id AS id, v.patent AS patent, v.brand AS brand FROM Vehicle v ORDER BY v.fabricationYear")
    List<VehicleSummaryProjection> findAllVehiclesOrderedByFabricationYear();

    @Query("SELECT v.id AS id, v.patent AS patent FROM Vehicle v WHERE v.numberOfTires > :numberOfTires AND v.fabricationYear >= YEAR(current_date)")
    List<VehiclePatentProjection> findVehiclesByNumberOfTiresGreaterThanAndCurrentFabricationYear(
            @Param("numberOfTires") int numberOfTires
    );

    @Query("SELECT DISTINCT v.id AS id, v.patent AS patent, v.brand AS brand, v.model AS model " +
            "FROM Vehicle v " +
            "JOIN v.accidents a " +
            "WHERE a.economicLoss >= :economicLoss")
    List<VehicleSummaryProjection> findVehiclesWithAccidentEconomicLossGreaterThan(
            @Param("economicLoss") double economicLoss);

    @Query("SELECT v.id AS id, v.patent AS patent, v.brand AS brand, v.model AS model, SUM(a.economicLoss) AS totalEconomicLoss " +
            "FROM Vehicle v " +
            "JOIN v.accidents a " +
            "WHERE a.economicLoss >= :economicLoss " +
            "GROUP BY v.id, v.patent, v.brand, v.model")
    List<VehicleEconomicLossTotalProjection> findVehiclesWithAccidentEconomicLossGreaterThanAndTotalEconomicLoss(
            @Param("economicLoss") double economicLoss);
}
