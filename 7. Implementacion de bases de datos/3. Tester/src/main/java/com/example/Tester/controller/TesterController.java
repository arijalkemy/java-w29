package com.example.Tester.controller;

import com.example.Tester.dto.request.TestDtoRequest;
import com.example.Tester.server.ITesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testcases")
public class TesterController {
    private final ITesterService service;

    @PostMapping("/new")
    public ResponseEntity<?> addNewTester(@RequestBody TestDtoRequest request) {
        return new ResponseEntity<>(service.addNewTest(request), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTesters(@RequestParam(value = "last_update", required = false) String date) {
        return new ResponseEntity<>(service.getAllTest(date), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getTestById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestById(@PathVariable Long id, @RequestBody TestDtoRequest request) {
        return new ResponseEntity<>(service.updateTestById(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestById(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteTestById(id), HttpStatus.OK);
    }
}
