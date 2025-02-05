package com.org.meli.covid19.controller;

import com.org.meli.covid19.dto.SymptomDto;
import com.org.meli.covid19.service.ISymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSymptom")
public class SymptomControllerImpl {
    private final ISymptomService sintomaService;

    public SymptomControllerImpl(ISymptomService sintomaService) {
        this.sintomaService = sintomaService;
    }

    @GetMapping("")
    public ResponseEntity<List<SymptomDto>> getSintomas() {
        return new ResponseEntity<>(sintomaService.listAll(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<List<SymptomDto>> getSintomasByName(@PathVariable String name) {
        return new ResponseEntity<>(sintomaService.findSymptomsByName(name), HttpStatus.OK);
    }

}

