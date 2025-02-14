package com.example.qa_tester.controller;

import com.example.qa_tester.dto.RequestTestCaseDto;
import com.example.qa_tester.dto.ResponseTestCaseDto;
import com.example.qa_tester.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestCaseController {
    private final TestCaseService service;

    @GetMapping("/api/testcases")
    public ResponseEntity<List<ResponseTestCaseDto>> searchAllTestCases(){
        return new ResponseEntity<>(service.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<ResponseTestCaseDto> searchTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(service.searchById(id), HttpStatus.OK);
    }

    @PostMapping("api/testcases/new")
    public ResponseEntity<?> createTestCase(@RequestBody RequestTestCaseDto request){
        service.create(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("api/testcases/{id}")
    public ResponseEntity<?> createTestCase(@PathVariable Long id, @RequestBody RequestTestCaseDto request){
        service.updateById(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("api/testcases/{id}")
    public ResponseEntity<?> createTestCase(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
