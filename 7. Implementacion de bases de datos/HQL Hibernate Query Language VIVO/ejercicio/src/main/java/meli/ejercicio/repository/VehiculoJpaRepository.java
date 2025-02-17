package meli.ejercicio.repository;

import meli.ejercicio.interfaces.VehiculoProjection;
import meli.ejercicio.interfaces.VehiculoProjectionModelo;
import meli.ejercicio.interfaces.VehiculoProjectionPerdidaTotal;
import meli.ejercicio.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoJpaRepository extends JpaRepository<Vehiculo, Long> {
    //Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<VehiculoProjection> findPatenteAndMarca();

    //Listar la patente de todos los vehículos que tengan más de cuatro
    // ruedas y hayan sido fabricados en el corriente año.
    @Query("select v.patente from Vehiculo v where v.cantidadRuedas>=4 and v.anioFabricacion=year(current_date)")
    List<String> findPatenteByYearAndRuedas();

    //Listar la matrícula, marca y modelo de todos los vehículos que
    // hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("select v from Vehiculo v join v.siniestros s where s.perdidaEconomica>10000")
    List<VehiculoProjectionModelo> findMatriculaMarcaModeloByPerdida();

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida
    // mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    //@Query("select v.marca, v.modelo, v.patente, sum(s.perdidaEconomica) from Vehiculo v join v.siniestros s group by v")
    @Query("select v.patente as patente, v.marca, v.modelo, SUM(s.perdidaEconomica) " +
            "from Vehiculo v join v.siniestros s " +
            "where s.perdidaEconomica > 10000 " +
            "group by v")
    List<VehiculoProjectionPerdidaTotal> findMatriculaMarcaModeloPerdida();
}