package com.example.testers.controller;

import com.example.testers.model.TestCase;
import com.example.testers.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {

    private final TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<String> saveTestCase(@RequestBody TestCase testCase) {
        service.saveTestCase(testCase);
        return ResponseEntity.ok("Test case created");
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getTestCases(
            @RequestParam(required = false, value = "last_update")
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        if (Objects.isNull(lastUpdate)) {
            return ResponseEntity.ok(service.getTestCases());
        } else {
            return ResponseEntity.ok(service.getTestCases(lastUpdate));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(service.findTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        service.updateTestCase(id, testCase);
        return ResponseEntity.ok("Test case updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        service.deleteTestCase(id);
        return ResponseEntity.ok("Test case deleted");
    }
}
