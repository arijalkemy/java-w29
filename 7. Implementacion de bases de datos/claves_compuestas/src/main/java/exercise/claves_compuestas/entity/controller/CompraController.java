package exercise.claves_compuestas.entity.controller;

import exercise.claves_compuestas.entity.Compra;
import exercise.claves_compuestas.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping("/crear-ejemplos")
    public ResponseEntity<String> crearComprasEjemplo(){
        compraService.crearComprasEjemplo();
        return ResponseEntity.ok("Compras de ejemplo creadas");
    }

    @GetMapping
    public ResponseEntity<List<Compra>> getAll(){
        return new ResponseEntity<>(compraService.obtenerTodasLasCompra(), HttpStatus.OK);
    }
}
