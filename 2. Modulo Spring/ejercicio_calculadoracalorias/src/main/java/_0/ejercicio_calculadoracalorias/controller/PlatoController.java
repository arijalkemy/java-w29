package _0.ejercicio_calculadoracalorias.controller;

import _0.ejercicio_calculadoracalorias.service.PlatoServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PlatoController {

    private PlatoServiceImp platoServiceImp;

    public PlatoController(PlatoServiceImp platoServiceImp) {
        this.platoServiceImp = platoServiceImp;
    }

    @GetMapping("plato/{n}")
    public ResponseEntity<?> getPlato(@PathVariable String n) {
        return ResponseEntity.ok(platoServiceImp.calcularCalorias(n));

    }

}
