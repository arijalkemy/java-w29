package com.example.demo.controller;
import com.example.demo.service.EdadService;
import com.example.demo.service.EdadServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    private final EdadServiceImp edadService;

    public EdadController(EdadServiceImp edadService) {
        this.edadService = edadService;
    }

    @GetMapping("/edad/{dia}/{mes}/{ano}")
    public ResponseEntity<Integer> calcularEdadPersona (@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return  ResponseEntity.ok(edadService.calcularEdad(dia, mes, ano));
    }

    //mustra las excepciones que surjan
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
