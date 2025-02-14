package com.bootcamp.test_cases.controller;

import com.bootcamp.test_cases.dto.TestCaseDto;
import com.bootcamp.test_cases.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService service;

    @Autowired
    public TestCaseController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> createTestCase(@RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTestCase(testCaseDto));
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getAllTestCases(@RequestParam(value = "last_update", required = false) String date){
        return ResponseEntity.ok(service.getAllTestCases(date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getCaseById(@PathVariable Long id){
        return ResponseEntity.ok(service.getCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.ok(service.updateTestCase(id, testCaseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCaseById(@PathVariable Long id){
        service.deleteTestCaseById(id);
        return ResponseEntity.noContent().build();
    }
}
