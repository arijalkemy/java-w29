package org.example.ej_calculadora_calorias.Controller;

import org.example.ej_calculadora_calorias.Dto.IngredienteDTO;
import org.example.ej_calculadora_calorias.Service.PlatoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final PlatoServiceImpl service;

    public Controller(PlatoServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/calorias/{plato}")
    public ResponseEntity<String> getCalorias(@PathVariable String plato) {
        Integer calorias = service.getCalorias(plato);
        return ResponseEntity.ok(String.format("EL plato tiene %d calorias", calorias));
    }

    @GetMapping("/listIngredientes/{plato}")
    public ResponseEntity<List<IngredienteDTO>> getIngredientes(@PathVariable String plato) {
        return ResponseEntity.ok(service.getIngredientes(plato));
    }

    @GetMapping("/maxCalorias/{plato}")
    public ResponseEntity<?> getMaximaCaloria(@PathVariable String plato) {
        return ResponseEntity.ok(service.maxCalorias(plato));

    }


}
