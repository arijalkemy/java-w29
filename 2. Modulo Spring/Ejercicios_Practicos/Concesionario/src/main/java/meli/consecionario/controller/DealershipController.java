package meli.consecionario.controller;

import meli.consecionario.dto.request.RequestVehicleDto;
import meli.consecionario.service.IDealershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class DealershipController {

    IDealershipService dealershipService;

    public DealershipController(IDealershipService dealershipService){
        this.dealershipService = dealershipService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody RequestVehicleDto vehicleDto){
        return new ResponseEntity<>(dealershipService.addVehicle(vehicleDto),HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> listVehicle(){
        return new ResponseEntity<>(dealershipService.listVehicle(),HttpStatus.OK);
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<?>filterDates(@RequestParam String since, String to){
        return new ResponseEntity<>(dealershipService.filterDates(since, to), HttpStatus.OK);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<?> filterPrices(@RequestParam Integer since, Integer to){
        return new ResponseEntity<>(dealershipService.filterPrice(since, to), HttpStatus.OK);
    }
    @GetMapping("vehicles/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return new ResponseEntity<>(dealershipService.findById(id), HttpStatus.OK);
    }


}
