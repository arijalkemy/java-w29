package org.example.ej_concesionaria_autos.Controllers;

import org.example.ej_concesionaria_autos.Dtos.VehiculoDTO;
import org.example.ej_concesionaria_autos.Services.VehiculoServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class VehiculoController {

    private final VehiculoServiceImpl service;

    public VehiculoController(VehiculoServiceImpl service) {
        this.service = service;
    }

    //Agrega un nuevo vehículos
    @PostMapping("/vehicles")
    public ResponseEntity<?> saveVehicle(@RequestBody VehiculoDTO vehiculoDTO) {

        return ResponseEntity.ok(service.add(vehiculoDTO));

    }

    //    Retorna un listado de todos los usados seleccionados. No incluye services.
    @GetMapping("/vehicles")
    public ResponseEntity<List<VehiculoDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    //    Retorna el listado de los vehículos según fecha de fabricación.
    @GetMapping("/vehicles/dates")
    public ResponseEntity<?> findByDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date since,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date to) {
        return ResponseEntity.ok(service.getVehiculoByDate(since, to));
    }

    //    Muestra el listado de los vehículos según los precios dados.
    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<VehiculoDTO>> findByPrices(@RequestParam Integer since, @RequestParam Integer to) {
        return ResponseEntity.ok(service.getVehiculoByPrice(since, to));
    }

    //    Muestra toda la información relacionada con el vehículo.
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getVehiculoById(id));
    }


}

