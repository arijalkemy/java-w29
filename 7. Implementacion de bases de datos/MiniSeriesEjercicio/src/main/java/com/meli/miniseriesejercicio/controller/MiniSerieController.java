package com.meli.miniseriesejercicio.controller;

import com.meli.miniseriesejercicio.model.MiniSerie;
import com.meli.miniseriesejercicio.service.MiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MiniSerieController {

    private final MiniSerieService miniSerieService;

    public MiniSerieController(MiniSerieService miniSerieService) {
        this.miniSerieService = miniSerieService;
    }

    @PostMapping("/mini_serie")
    public ResponseEntity<?> postMiniSerie(@RequestBody MiniSerie miniSerie) {
        return new ResponseEntity<>(miniSerieService.addMiniSerie(miniSerie), HttpStatus.CREATED);
    }
}
