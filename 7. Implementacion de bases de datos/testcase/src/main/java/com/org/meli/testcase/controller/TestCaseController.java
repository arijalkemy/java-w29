package com.org.meli.testcase.controller;

import com.org.meli.testcase.dto.TestCaseDto;
import com.org.meli.testcase.entity.TestCase;
import com.org.meli.testcase.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api")
public class TestCaseController {
    private final ITestCaseService testCaseService;
    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("testcases/new")
    public ResponseEntity<TestCaseDto> createTestCase(@RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseDto), HttpStatus.OK);
    }

    @GetMapping("testcases")
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.findAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("testcases/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("testcases/{id}")
    public ResponseEntity<TestCaseDto> deleteTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping("testcases/afterdate")
    public ResponseEntity<List<TestCase>> getTestCasesAfterDate(@RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        List<TestCase> testCases = testCaseService.findTestCasesAfterDate(lastUpdate);
        if (testCases.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }
}
