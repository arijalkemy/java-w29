package hql.hqlmovies.repository;

import hql.hqlmovies.dto.VehicleDTO;
import hql.hqlmovies.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehiculo , Long> {

    @Query("SELECT v FROM Vehiculo v")
    List<Vehiculo> findPatentesRegistered();

    @Query("SELECT v FROM Vehiculo v order by v.yearFabricated")
    List<Vehiculo> findBrandAndPatentOrderByYearFabricated();

    @Query("select v FROM Vehiculo v where v.cantidadDeRuedas > 4 and v.yearFabricated = YEAR(CURRENT_DATE) ")
    List<Vehiculo> findPatentsAbove4WheelsCurrentYear();

    @Query("SELECT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> findVehicleWithLostAbove10000();

}
