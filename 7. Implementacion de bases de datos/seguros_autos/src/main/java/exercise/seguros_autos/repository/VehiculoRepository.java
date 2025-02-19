package exercise.seguros_autos.repository;

import exercise.seguros_autos.interfaces.VehiculoPatenteMarcaModeloProjection;
import exercise.seguros_autos.interfaces.VehiculoPatenteMarcaProjection;
import exercise.seguros_autos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo AS v")
    List<String> findPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo AS v ORDER BY v.anioFabricacion ASC")
    List<VehiculoPatenteMarcaProjection> findPatenteMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo AS v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = YEAR(NOW())")
    List<String> findPatenteByRuedasGreaterThan4AndCurrentYear();

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo AS v INNER JOIN v.siniestros AS s WHERE s.perdidaEconomica > 10000")
    List<VehiculoPatenteMarcaModeloProjection> findPatenteMarcaModeloThanPerdidaGreaterThan10000();

    @Query("SELECT SUM(v.id) FROM Vehiculo AS v INNER JOIN v.siniestros AS s WHERE s.perdidaEconomica > 10000")
    Double findPerdidaTotalThanPerdidaGreaterThan10000();
}
