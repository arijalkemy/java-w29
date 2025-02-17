package meli.ejercicio.controller;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.interfaces.VehiculoProjection;
import meli.ejercicio.interfaces.VehiculoProjectionModelo;
import meli.ejercicio.interfaces.VehiculoProjectionPerdidaTotal;
import meli.ejercicio.model.Vehiculo;
import meli.ejercicio.service.VehiculoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> findAll() {
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<String>> findAllPatentes() {
        return ResponseEntity.ok(vehiculoService.findAllPatentes());
    }

    @GetMapping("/patente-marca")
    public ResponseEntity<List<VehiculoProjection>> obtenerPatenteYMarcaOrdenadosPorAnioFabricacion() {
        return ResponseEntity.ok(vehiculoService.findPatenteYMarcaOrdenadosPorAnioFabricacion());
    }

    @GetMapping("/patente-anio-ruedas")
    public ResponseEntity<List<String>> obtenerPatentePorAnioYRuedas() {
        return ResponseEntity.ok(vehiculoService.findPatentePorAnioYRuedas());
    }

    @GetMapping("/matricula-marca-modelo")
    public ResponseEntity<List<VehiculoProjectionModelo>> obtenerMatriculaMarcaModeloPorPerdida() {
        return ResponseEntity.ok(vehiculoService.findMatriculaMarcaModeloPorPerdida());
    }

    @GetMapping("/matricula-marca-modelo-perdida")
    public ResponseEntity<List<VehiculoProjectionPerdidaTotal>> obtenerMatriculaMarcaModeloPerdida() {
        return ResponseEntity.ok(vehiculoService.findMatriculaMarcaModeloPerdida());
    }
}
