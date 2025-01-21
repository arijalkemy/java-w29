package spring.ejercicionumerosromanos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.ejercicionumerosromanos.service.NumerosRomanosService;

@RestController
public class NumerosRomanosController {

    NumerosRomanosService service;

    public NumerosRomanosController() {
        this.service = new NumerosRomanosService();
    }

    @GetMapping("/decimalaromano/{numero}")
    public ResponseEntity<?> convertirARomano(@PathVariable int numero) {
        return ResponseEntity.ok(service.calcularNumeroRomano(numero));
    }
}
