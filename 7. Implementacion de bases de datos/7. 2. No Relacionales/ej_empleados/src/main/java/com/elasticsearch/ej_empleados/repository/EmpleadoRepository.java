package com.elasticsearch.ej_empleados.repository;

import com.elasticsearch.ej_empleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
