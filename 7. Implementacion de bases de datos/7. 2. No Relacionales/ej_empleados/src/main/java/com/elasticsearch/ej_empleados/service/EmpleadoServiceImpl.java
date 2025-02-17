package com.elasticsearch.ej_empleados.service;

import com.elasticsearch.ej_empleados.exceptions.NotFoundException;
import com.elasticsearch.ej_empleados.model.Empleado;
import com.elasticsearch.ej_empleados.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Iterable<Empleado> getAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(String id, Empleado empleado) {
        empleado.setId(id);
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado getById(String id) {
        return empleadoRepository.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
    }
}
