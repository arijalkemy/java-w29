package com.elasticsearch.ej_empleados.service;

import com.elasticsearch.ej_empleados.model.Empleado;

public interface EmpleadoService {
    Iterable<Empleado> getAll();

    Empleado save(Empleado empleado);

    Empleado update(String id, Empleado empleado);

    Empleado getById(String id);
}
