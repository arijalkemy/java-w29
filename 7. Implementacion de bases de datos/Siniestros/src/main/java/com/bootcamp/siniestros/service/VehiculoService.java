package com.bootcamp.siniestros.service;

import com.bootcamp.siniestros.dto.VehiculoPatenteResponseBody;
import com.bootcamp.siniestros.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public List<String> findAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    public List<VehiculoPatenteResponseBody> findPatentesSortByFecha() {
        return vehiculoRepository
                .findPatentesByFechaAndMarca()
                .stream()
                .map(v -> new VehiculoPatenteResponseBody(v.getPatente(), v.getMarca(), v.getAnio()))
                .toList();
    }

    public List<String> findPatentesByCantidadRuedasYAnio(Integer cantidadRuedas, Integer anio) {
        return vehiculoRepository
                .findPatentesByCantidadRuedasYAnio(cantidadRuedas, anio);
    }

    public List<VehiculoPatenteResponseBody> findBySiniestro(int perdida) {
        return vehiculoRepository
                .findBySiestroPerdida(perdida)
                .stream()
                .map(v -> new VehiculoPatenteResponseBody(v.getPatente(), v.getMarca(), v.getAnio()))
                .toList();
    }
}
