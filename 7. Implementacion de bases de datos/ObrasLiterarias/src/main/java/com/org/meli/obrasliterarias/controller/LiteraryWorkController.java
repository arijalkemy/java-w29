package com.org.meli.obrasliterarias.controller;

import com.org.meli.obrasliterarias.dto.LiteraryWorkDto;
import com.org.meli.obrasliterarias.service.ILiteraryWorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LiteraryWorkController {
    private final ILiteraryWorkService literaryWorkService;

    public LiteraryWorkController(ILiteraryWorkService literaryWorkService) {
        this.literaryWorkService = literaryWorkService;
    }

    @GetMapping("/literaryworks/author/{author}")
    public ResponseEntity<List<LiteraryWorkDto>> getLiteraryWorksByAuthor (
            @PathVariable String author){
        return new ResponseEntity<>(literaryWorkService.findLiteraryWorksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/literaryworks/name")
    public ResponseEntity<List<LiteraryWorkDto>> getLiteraryWorksByTitleContaining(
            @RequestParam(value = "name", required = false) String name
    ){
        return new ResponseEntity<>(literaryWorkService.findLiteraryWorksByTitleContaining(name), HttpStatus.OK);
    }

    @GetMapping("/literaryworks/top-five-by-pages")
    public ResponseEntity<List<LiteraryWorkDto>> getTopFiveLiteraryWorksByNumberPages(){
        return new ResponseEntity<>(literaryWorkService.findTopFiveLiteraryWorksByNumberPages(), HttpStatus.OK);
    }

    @GetMapping("/literaryworks/published-before/{year}")
    public ResponseEntity<List<LiteraryWorkDto>> getLiteraryWorksByYear(
            @PathVariable String year){
        return new ResponseEntity<>(literaryWorkService.findLiteraryWorksByYear(year), HttpStatus.OK);
    }

    @GetMapping("/literaryworks/editorial/{editorial}")
    public ResponseEntity<List<LiteraryWorkDto>> getLiteraryWorksByEditorial(
            @PathVariable String editorial){
        return new ResponseEntity<>(literaryWorkService.findLiteraryWorksByEditorial(editorial), HttpStatus.OK);
    }
}
