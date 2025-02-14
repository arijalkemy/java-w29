package com.example.qatester.controller;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.out.MessageDto;
import com.example.qatester.service.ITestCaseService;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/testcase")
public class TestCaseController {
    @Autowired
    private ITestCaseService iTestCaseService;

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postTestCase(
            @RequestBody @Valid TestCaseDto testCaseDto
    ) {
        return ResponseEntity.ok(this.iTestCaseService.addTestCase(testCaseDto));
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getAll(){
        return ResponseEntity.ok(this.iTestCaseService.searchTestCase());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getById(
            @PathVariable @Positive Long id
    ) throws Exception {
        return ResponseEntity.ok(this.iTestCaseService.searchTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> putById(
            @PathVariable @Positive Long id,
            @RequestBody @Valid TestCaseDto testCaseDto
    ) throws Exception {
        return ResponseEntity.ok(this.iTestCaseService.modifyById(id, testCaseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteById(
            @PathVariable @Positive Long id
    ) {
        return ResponseEntity.ok(this.iTestCaseService.deleteById(id));
    }

    // falta este.
    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getByFilter(
            @RequestParam String last_update
    ){
        return ResponseEntity.ok(this.iTestCaseService.filterByDate(last_update));
    }
}
