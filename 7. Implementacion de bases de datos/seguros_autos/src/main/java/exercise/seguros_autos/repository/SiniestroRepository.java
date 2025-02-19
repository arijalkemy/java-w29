package exercise.seguros_autos.repository;

import exercise.seguros_autos.interfaces.VehiculoPatenteMarcaProjection;
import exercise.seguros_autos.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {

}
