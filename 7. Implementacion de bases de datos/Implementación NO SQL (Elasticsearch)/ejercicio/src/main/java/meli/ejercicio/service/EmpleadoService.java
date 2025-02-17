package meli.ejercicio.service;

import meli.ejercicio.domain.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    Empleado agregarEmpleado(Empleado empleado);

    Empleado modificarEmpleado(Empleado empleado);

    Optional<Empleado> obtenerEmpleado(String id);

    Iterable<Empleado> obtenerEmpleados();
}
