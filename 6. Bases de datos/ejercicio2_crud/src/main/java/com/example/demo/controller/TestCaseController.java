package com.example.demo.controller;

import com.example.demo.dto.response.TestCaseResDTO;
import com.example.demo.dto.request.TestCaseReqDTO;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {
    private final ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseReqDTO testCaseReqDTO) {
        testCaseService.createTestCase(testCaseReqDTO);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) LocalDate lastUpdate) {
        return new ResponseEntity<>(testCaseService.getTestCases(lastUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResDTO> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseReqDTO testCaseReqDTO) {
        testCaseService.updateTestCase(id, testCaseReqDTO);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}

