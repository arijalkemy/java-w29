package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.dto.request.LiterallyWorkRequestDto;
import com.example.obrasliterarias.dto.response.LiterallyWorkResponseDto;
import com.example.obrasliterarias.model.LiterallyWork;
import com.example.obrasliterarias.service.ILiterallyWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/literally")
public class LiterallyWorkController {

    @Autowired
    private ILiterallyWorkService literallyWorkService;

    @PostMapping
    public ResponseEntity<LiterallyWorkResponseDto> postLiterallyWork(@RequestBody LiterallyWorkRequestDto literallyWorkDTO) {
        return new ResponseEntity<>(literallyWorkService.saveLiterallyWork(literallyWorkDTO), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<?> getLiterallyWorkAll() {
        return new ResponseEntity<>(literallyWorkService.findAllLiterallyWork(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLiterallyWorkById(@PathVariable String id) {
        return new ResponseEntity<>(literallyWorkService.findLiterallyWorkById(id), HttpStatus.OK);
    }

    @GetMapping("/findByAuthorName/{name}")
    public ResponseEntity<?> getLiterallyWorkPlanByName(@PathVariable String name){
        return new ResponseEntity<>(literallyWorkService.findLiterallyWorkByAuthorName(name), HttpStatus.OK);
    }

    @GetMapping("/findByNameTitle/{name}")
    public ResponseEntity<?> getLiterallyWorkByNameTitle(@PathVariable String name){
        return new ResponseEntity<>(literallyWorkService.findLiterallyWorkByNameTitle(name), HttpStatus.OK);
    }

    @GetMapping("/TopFiveMaxPages")
    public ResponseEntity<?> getLiterallyWorkTopFiveByMaxPages (){
        return new ResponseEntity<>(literallyWorkService.findLiterallyWorkTopFiveByMaxPages(), HttpStatus.OK);
    }

    @GetMapping("/BeforeYear/{year}")
    public ResponseEntity<?> getLiterallyWorkByBeforeYear(@PathVariable Integer year){
        return new ResponseEntity<>(literallyWorkService.findLiteralWorkByBeforeYear(year), HttpStatus.OK);
    }

    @GetMapping("/findByNameEditorial/{name}")
    public ResponseEntity<?> getLiterallyWorkByNameEditorial(@PathVariable String name){
        return new ResponseEntity<>(literallyWorkService.findLiterallyWorkByNameEditorial(name), HttpStatus.OK);
    }

}



