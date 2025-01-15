package com.mdaneri.concesionariap2vivo2.controller;

import com.mdaneri.concesionariap2vivo2.dto.CarDTO;
import com.mdaneri.concesionariap2vivo2.dto.request.RequestCarDTO;
import com.mdaneri.concesionariap2vivo2.dto.response.ResponseCarDTO;
import com.mdaneri.concesionariap2vivo2.entity.Car;
import com.mdaneri.concesionariap2vivo2.service.IConcessionaireService;
import com.mdaneri.concesionariap2vivo2.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/v1/api")
public class ConcessionaireController {

    private final IConcessionaireService cs;

    public ConcessionaireController(IConcessionaireService cs) {
        this.cs = cs;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<String> save(@RequestBody RequestCarDTO requestCarDTO) {
        Optional<ResponseCarDTO> optional = cs.save(requestCarDTO);
        if (optional.isEmpty())
            return ResponseEntity.badRequest().body("Car not saved");
        else
            return ResponseEntity.ok("Car saved");
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<ResponseCarDTO>> findAll() {
        return ResponseEntity.ok(cs.findAll());
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<ResponseCarDTO>> findByDates(
            @RequestParam String since,
            @RequestParam String to
    ) {
        List<ResponseCarDTO> cars = cs.findByDate(DateUtils.convert(since), DateUtils.convert(to));
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<ResponseCarDTO>> findByPrices(
            @RequestParam Integer from,
            @RequestParam Integer to
    ) {
        List<ResponseCarDTO> cars = cs.findByPrice(from, to);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<ResponseCarDTO> dtoOptional = cs.findById(id);

        if (dtoOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No se encontró el vehículo buscado");

        return ResponseEntity.ok(dtoOptional.get());
    }



}
