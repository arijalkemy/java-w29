package meli.ejercicio.repository;

import meli.ejercicio.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
    Optional<Empleado> findById(String id);
}
