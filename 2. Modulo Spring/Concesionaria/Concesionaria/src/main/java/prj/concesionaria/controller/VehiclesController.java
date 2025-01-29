package prj.concesionaria.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prj.concesionaria.dto.ResponseDto;
import prj.concesionaria.dto.VehiclesDto;
import prj.concesionaria.service.IVehiclesService;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

    private IVehiclesService vehiclesServices;

    public VehiclesController(IVehiclesService vehiclesServices) {
        this.vehiclesServices = vehiclesServices;
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> createVehicles(@RequestBody VehiclesDto vehicle){
        return new ResponseEntity<>(vehiclesServices.addVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<VehiclesDto>> getVehicles(){
        return new ResponseEntity<>(vehiclesServices.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehiclesDto>> filterByYears(@RequestParam Integer since, @RequestParam Integer to){
        return new ResponseEntity<>(vehiclesServices.getByYears(since,to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiclesDto>> filterByPrices(@RequestParam Integer since, @RequestParam Integer to){
        return new ResponseEntity<>(vehiclesServices.getByPrices(since,to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiclesDto> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(vehiclesServices.getById(id), HttpStatus.OK);
    }
}
