package com.bootcamp.hqlvivo.repository;

import com.bootcamp.hqlvivo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v ORDER BY v.manufacturingYear")
    List<Vehicle> findAllOrderedByManufacturingYear();

    @Query("SELECT v FROM Vehicle v WHERE v.wheels > 4 AND v.manufacturingYear = :year")
    List<Vehicle> findAllWithMoreThanFourWheelsAndManufacturedInYear(@Param("year") Integer year);

    @Query("SELECT v FROM Vehicle v JOIN v.accidents a WHERE a.economicLoss > 10000")
    List<Vehicle> findAllWithLossGreaterThan10000();

    @Query("SELECT v, SUM(a.economicLoss) FROM Vehicle v JOIN v.accidents a WHERE a.economicLoss > 10000 GROUP BY v.id")
    List<Object[]> findAllWithLossGreaterThan10000AndTotalLoss();
}
