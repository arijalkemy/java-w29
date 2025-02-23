package com.hqlvivo.hqlvivo.repository;

import com.hqlvivo.hqlvivo.entities.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<VehicleModel,Long> {

    @Query("SELECT v FROM VehicleModel v ")
    List<VehicleModel> getAllVehicle();

    @Query("SELECT v.patent FROM VehicleModel v")
    List<String> listAllPlates();

    @Query("SELECT v FROM VehicleModel v ORDER BY v.vehicleYear")
    List<VehicleModel[]> listVehiclesOrderedByYear();

    @Query("SELECT v.patent FROM VehicleModel v WHERE v.wheels > 4 AND v.vehicleYear = :currentYear")
    List<String> listVehiclesWithMoreThanFourWheels(@Param("currentYear") int currentYear);
}
