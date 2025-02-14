package com.thiagoschreck.local.qa_testers.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thiagoschreck.local.qa_testers.dto.request.CreateTestCaseRequestDTO;
import com.thiagoschreck.local.qa_testers.dto.request.UpdateTestCaseRequestDTO;
import com.thiagoschreck.local.qa_testers.dto.response.TestCaseResponseDTO;
import com.thiagoschreck.local.qa_testers.service.TestCasesService;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {
    private final TestCasesService service;

    @Autowired
    public TestCasesController(TestCasesService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseResponseDTO> crearTestCase(@RequestBody CreateTestCaseRequestDTO dto) {
        return ResponseEntity.ok(service.crearTestCase(dto));
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponseDTO>> getAllTestCases(
            @RequestParam(value = "last_update", required = false)
            String last_update) {
        return ResponseEntity.ok(service.getAllTestCases(last_update));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> updateTestCaseById(
            @PathVariable("id") Long id,
            @RequestBody UpdateTestCaseRequestDTO dto
    ) {
        return ResponseEntity.ok(service.updateTestCaseById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> deleteTestCaseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.deleteTestCaseById(id));
    }
}
