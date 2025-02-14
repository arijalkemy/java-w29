package com.QaTester.QaTester.controller;

import com.QaTester.QaTester.dto.TestCaseDto;
import com.QaTester.QaTester.service.TestCaseServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {

    private final TestCaseServiceImpl service;

    public TestCaseController(TestCaseServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<TestCaseDto> addTestCase(@RequestBody TestCaseDto dto){
        return new ResponseEntity<>(service.addTestCase(dto), HttpStatus.CREATED);
    }

    @GetMapping("/testcase")
    public ResponseEntity<List<TestCaseDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/testcase/{id}")
    public ResponseEntity<TestCaseDto> getById(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/testcase/{id}")
    public ResponseEntity<TestCaseDto> updateCase(@PathVariable Long id, @RequestBody TestCaseDto dto){
        return new ResponseEntity<>(service.update(id,dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<TestCaseDto> deleteCase(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/testcases/updated-after/{last_update}")
    public ResponseEntity<List<TestCaseDto>> getTestCasesByLastUpdate(
            @PathVariable("last_update") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate lastUpdate) {
        return ResponseEntity.ok(service.findByLastUpdateAfter(lastUpdate));
    }






}
