package com.example.empleado.service;

import com.example.empleado.model.Empleado;

public interface IEmpleadoService {
    Iterable<Empleado> getAll();

    Empleado save(Empleado empleado);

    Empleado update(String id, Empleado empleado);

    Empleado getById(String id);
}
