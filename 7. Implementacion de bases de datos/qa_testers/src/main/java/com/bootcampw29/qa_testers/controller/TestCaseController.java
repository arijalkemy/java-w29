package com.bootcampw29.qa_testers.controller;

import com.bootcampw29.qa_testers.dto.request.TestCaseRequestDTO;
import com.bootcampw29.qa_testers.dto.response.TestCaseCreatedDTO;
import com.bootcampw29.qa_testers.dto.response.TestCaseResponseDTO;
import com.bootcampw29.qa_testers.service.TestCaseService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDTO>> getAll(
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<LocalDate> last_update
    ) {
        return new ResponseEntity<>(this.testCaseService.searchAllTestCases(last_update), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(this.testCaseService.searchTestCaseById(id), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseCreatedDTO> postTestCase(
            @Valid @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return new ResponseEntity<>(this.testCaseService.createTestCase(testCaseRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> putTestCase(
            @PathVariable Long id,
            @Valid @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return new ResponseEntity<>(this.testCaseService.modifyTestCase(id, testCaseRequestDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        this.testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }

}
