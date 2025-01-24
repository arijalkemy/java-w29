package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VehicleController {

    private final IVehicleService vehicleService;

    /*public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }*/

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> agregarVehiculo(@RequestBody Vehicle vehicle){
        return new ResponseEntity<>(vehicleService.agregarVehiculo(vehicle),HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> buscarVehiculoPorColorYanio(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.obtenerVehiculosPorColorYanio(color,year),HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> buscarVehiculosPorYrangoDeAnios(@PathVariable String brand,@PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.buscarVehiculosPorYrangoDeAnios(brand,start_year,end_year),HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> conocerVelocidadPromedioPorMarca(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService,HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> añadirMultiplesVehiculos(@RequestBody List<Vehicle> vehiculo){
        return new ResponseEntity<>(vehicleService.cargarListaDeVehiculos(vehiculo),HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> actualizarVelocidad(@PathVariable Long id, @RequestBody String velocidad){
        return new ResponseEntity<>(vehicleService.actualizarVelocidad(id,velocidad),HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> listarPorDimensiones(@RequestParam double length,@RequestParam double width){
        return new ResponseEntity<>(vehicleService.listarPorDimensiones(length,width),HttpStatus.OK);
    }
}
