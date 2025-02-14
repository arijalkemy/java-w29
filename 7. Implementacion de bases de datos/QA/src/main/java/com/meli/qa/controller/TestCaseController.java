package com.meli.qa.controller;

import com.meli.qa.dto.request.AddTestCaseRequestDto;
import com.meli.qa.dto.request.TestCaseDto;
import com.meli.qa.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcase")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> addTestCase(@RequestBody AddTestCaseRequestDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.save(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(testCaseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable("id") Long id, @RequestBody AddTestCaseRequestDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.update(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCaseById(@PathVariable("id") Long id) {
        testCaseService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
