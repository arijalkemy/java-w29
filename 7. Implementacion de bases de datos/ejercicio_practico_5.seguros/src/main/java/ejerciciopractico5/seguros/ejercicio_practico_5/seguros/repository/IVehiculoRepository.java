package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.repository;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehículos registrados
    @Query("SELECT v.patente FROM Vehiculo AS v")
    List<String> findAllPatente();

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT v.patente, v.marca FROM Vehiculo AS v ORDER BY v.año")
    List<String []> findAllPatenteMarca();

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados
    // en el corriente año.
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantRuedad >= :cantidadRuedas AND v.año = :anio")
    List<String> findAllByRuedasAndYear(Integer cantidadRuedas, Integer anio);

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida
    // mayor de 10000 pesos.
    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.sinietros s WHERE s.perdida >= :monto")
    List<String[]> findAllByPerdidaEconomica(Integer monto);

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor
    // de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdida - :monto)  FROM Vehiculo v JOIN v.sinietros s WHERE s.perdida >= :monto GROUP BY v.id")
    List<String[]> findAllByPerdidaEconomicaConDif(Integer monto);
}
