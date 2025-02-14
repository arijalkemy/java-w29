package com.example.qatester.controller;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.response.ApiResponseDto;
import com.example.qatester.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/api/testcases/new")
    public ResponseEntity<ApiResponseDto> createTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDto>> getAllTestCase(){
        return new ResponseEntity<>(testCaseService.getAllTestCase(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/id")
    public ResponseEntity<TestCaseDto> getTestCaseById(@RequestParam Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/id")
    public ResponseEntity<ApiResponseDto> updateTestCase(@RequestParam Long id, @RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.updateTestCase(id,testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/id")
    public ResponseEntity<ApiResponseDto> deleteTestCaseById(@RequestParam Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCaseById(id), HttpStatus.OK);
    }

}
