package org.melibootcamp.qatester.controller;

import org.melibootcamp.qatester.dto.MessajeDto;
import org.melibootcamp.qatester.dto.TestDto;
import org.melibootcamp.qatester.model.TestCase;
import org.melibootcamp.qatester.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ITestService service;

    @GetMapping("/testcases")
    public ResponseEntity<List<TestDto>> getTestCases() {
        return ResponseEntity.ok(service.getAllTestCases());
    }

    @GetMapping("/testcase/{id}")
    public ResponseEntity<TestDto> getTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTestCase(id));
    }

    @PutMapping("/testcase/{id}")
    public ResponseEntity<MessajeDto> updateTestCase(@RequestBody TestDto testCaseDTO) {
        return ResponseEntity.ok(service.updateTestCase(testCaseDTO));
    }

    @PostMapping("/testcase/new")
    public ResponseEntity<MessajeDto> createTestCase(@RequestBody TestDto testCaseDTO) {
        return ResponseEntity.ok(service.createTestCase(testCaseDTO));
    }

    @DeleteMapping("/testcase/{id}")
    public ResponseEntity<MessajeDto> deleteTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteTestCase(id));
    }

    @GetMapping("/testcases/notpassed")
    public ResponseEntity<List<TestDto>> getNotPassedTest() {
        return ResponseEntity.ok(service.getNotPassedTest());
    }
}
