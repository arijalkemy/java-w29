package com.bootcamp.crudjpa.controller;

import com.bootcamp.crudjpa.dto.TestCaseDto;
import com.bootcamp.crudjpa.model.TestCase;
import com.bootcamp.crudjpa.service.TestCaseServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {
    private final TestCaseServiceImpl service;

    public TestCaseController(TestCaseServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/api/testcases/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCaseDto testCaseDto) {
        TestCase testCase = service.createTestCase(testCaseDto);
        return new ResponseEntity<>(testCase, HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<Iterable<TestCase>> getAllTestCases(
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update
    ) {
        List<TestCase> testCases = service.readAllTestCases(last_update);
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        TestCase testCase = service.readTestCase(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> updateTestCase(
            @PathVariable Long id,
            @RequestBody TestCaseDto testCaseDto) {
        TestCase testCase = service.updateTestCase(id, testCaseDto);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<HttpStatusCode> deleteTestCase(@PathVariable Long id) {
        service.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
