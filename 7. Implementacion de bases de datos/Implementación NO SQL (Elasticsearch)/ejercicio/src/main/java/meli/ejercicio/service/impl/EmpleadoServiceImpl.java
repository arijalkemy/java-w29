package meli.ejercicio.service.impl;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.domain.Empleado;
import meli.ejercicio.repository.EmpleadoRepository;
import meli.ejercicio.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado agregarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);

    }

    @Override
    public Empleado modificarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Optional<Empleado> obtenerEmpleado(String id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Iterable<Empleado> obtenerEmpleados() {
        return empleadoRepository.findAll();
    }
}
