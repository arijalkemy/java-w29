package com.meli.empleados.repository;

import com.meli.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {
}
