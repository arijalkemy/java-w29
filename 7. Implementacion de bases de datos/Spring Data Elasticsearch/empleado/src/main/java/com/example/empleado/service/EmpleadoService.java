package com.example.empleado.service;

import com.example.empleado.model.Empleado;
import com.example.empleado.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoService implements IEmpleadoService{
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
        return empleadoRepository.findById(id).orElse(null);
    }
}
