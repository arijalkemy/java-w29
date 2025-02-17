package com.example.segurosautos.repository;

import com.example.segurosautos.entity.Vehiculo;
import lombok.experimental.PackagePrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT DISTINCT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();


    @Query("""
            SELECT v
            FROM Vehiculo v
            ORDER BY
                CASE WHEN :order = 'ASC' THEN
                    CASE 
                        WHEN :by = 'patente'           THEN v.patente
                                    WHEN :by = 'anioFabricacion'   THEN CAST(v.anioFabricacion AS string)
                        ELSE CAST(v.idVehiculo AS string)
                    END
                END ASC,
            
                CASE WHEN :order = 'DESC' THEN
                    CASE 
                        WHEN :by = 'patente'           THEN v.patente
                        WHEN :by = 'anioFabricacion'   THEN CAST(v.anioFabricacion AS string)
                        ELSE CAST(v.idVehiculo AS string)
                    END
                END DESC
            """)
    List<Vehiculo> findAllVehicles(@Param("order") String order,
                                   @Param("by") String by);

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.anioFabricacion = :anioFabricacion and v.cantidadRuedas > :cantidadRuedas")
    List<String> findPatenteByAnioFabricacionAndCantidadRuedas(@Param("anioFabricacion") Integer anioFabricacion, @Param("cantidadRuedas") Integer cantidadRuedas);

    @Query("SELECT v FROM Vehiculo v INNER JOIN Siniestro s ON v.idVehiculo = s.vehiculo.idVehiculo WHERE s.perdidaEconomica >:perdidaEconomica")
    List<Vehiculo> findVehiculosByPerdidaEconomica(@Param("perdidaEconomica") Double perdidaEconomica);

}
