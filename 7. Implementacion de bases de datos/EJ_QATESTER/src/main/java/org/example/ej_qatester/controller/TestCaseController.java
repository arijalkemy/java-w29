package org.example.ej_qatester.controller;

import org.example.ej_qatester.dto.TestCaseDto;
import org.example.ej_qatester.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService service;

    public TestCaseController(ITestCaseService service) {
        this.service = service;
    }


    @PostMapping("/new")
    public ResponseEntity<?> saveTestCases(@RequestBody TestCaseDto testCaseDto) {

        return new ResponseEntity<>(service.addTestCase(testCaseDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDto>> findAll(@RequestParam(required = false) LocalDate lastUpdate) {
        return ResponseEntity.ok(service.getAllTestCase(lastUpdate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCasesById(@PathVariable Long id) {

        return new ResponseEntity<>(service.findTestCaseById(id), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {

        return new ResponseEntity<>(service.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }

}
