package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.dto.request.LiteralyPlayRequestDto;
import com.example.obrasliterarias.model.LiteralyWork;
import com.example.obrasliterarias.service.ILiteralyPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/literaly")
public class LiteralyPlayController {

    @Autowired
    private ILiteralyPlayService literalyPlayService;

    @PostMapping
    public ResponseEntity<?> postLiteralyPlay(@RequestBody LiteralyWork literalyWork){
        return new ResponseEntity<>(literalyPlayService.saveLiteralyPlay(literalyWork), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<?> getLiteralyPlayAll(){
        return new ResponseEntity<>(literalyPlayService.findAllLiteralyPlay(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLiteralyPlayById(@PathVariable String id){
        return new ResponseEntity<>(literalyPlayService.findLiteralyPlayById(id),HttpStatus.OK);
    }

}
