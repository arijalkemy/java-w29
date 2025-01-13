package com.example.codigomorse.controllers;

import com.example.codigomorse.dtos.CodigoMorseRequest;
import com.example.codigomorse.services.CodigoMorseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequiredArgsConstructor
public class CodigoMorseController {

    private final CodigoMorseService service;

    @PostMapping("/fromMorse")
    public ResponseEntity<String> fromMorse(@Valid @RequestBody CodigoMorseRequest request) {
        String resultado = service.fromMorse(request.codigo());
        return ResponseEntity.ok(resultado);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> handleValidationException(MethodArgumentNotValidException ex) {
        List<FieldError> errores = ex.getBindingResult().getFieldErrors();
        List<String> mensajesDeError = errores.stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(mensajesDeError);
    }

}
