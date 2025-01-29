package com.example.EjercicioCovidBootcamp.Controller;

import com.example.EjercicioCovidBootcamp.Service.ISintomaSerivce;
import com.example.EjercicioCovidBootcamp.Service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SintomaController {
    SintomaService sintomaService;
    @GetMapping("/findSymptom")
    public ResponseEntity<?> findSymptom() {
        return new ResponseEntity<>(sintomaService.findSymptom(),HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptom(@PathVariable String name) {
        return new ResponseEntity<>(sintomaService.findSymptomByName(name), HttpStatus.OK);
    }
}
