package org.meli.qatesters.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.meli.qatesters.dto.request.TestCaseDTO;
import org.meli.qatesters.dto.response.ResponseDTO;
import org.meli.qatesters.entity.TestCase;
import org.meli.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/test-cases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    @Autowired
    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDto) {
        TestCase testCase = testCaseService.createTestCase(testCaseDto);
        return ResponseEntity.ok(new ResponseDTO(testCase, "Test case created successfully"));
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllTestCases() {
        List<TestCase> testCases = testCaseService.getAllTestCases();
        return ResponseEntity.ok(new ResponseDTO(testCases, "Test cases retrieved successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getTestCaseById(@PathVariable Long id) {
        TestCase testCase = testCaseService.getTestCaseById(id);
        return ResponseEntity.ok(new ResponseDTO(testCase, "Test case retrieved successfully"));
    }

    @GetMapping(params = "last_update")
    public ResponseEntity<ResponseDTO> getTestCasesByDate(@RequestParam("last_update") String date) {
        List<TestCase> testCases = testCaseService.getTestCasesByDate(date);
        return ResponseEntity.ok(new ResponseDTO(testCases, "Test cases retrieved successfully"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDto) {
        TestCase testCase = testCaseService.updateTestCase(id, testCaseDto);
        return ResponseEntity.ok(new ResponseDTO(testCase, "Test case updated successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
