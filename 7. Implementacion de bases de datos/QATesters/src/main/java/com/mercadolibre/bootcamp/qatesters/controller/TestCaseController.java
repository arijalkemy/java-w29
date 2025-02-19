package com.mercadolibre.bootcamp.qatesters.controller;

import com.mercadolibre.bootcamp.qatesters.dto.TestCaseDto;
import com.mercadolibre.bootcamp.qatesters.model.TestCase;
import com.mercadolibre.bootcamp.qatesters.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService tcService;

    public TestCaseController(ITestCaseService tcService) {
        this.tcService = tcService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> create(@RequestBody TestCaseDto testCase) {
        return ResponseEntity.ok(tcService.save(testCase));
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDto>> findAll(@RequestParam(required = false) LocalDate lastUpdate) {
        return ResponseEntity.ok(tcService.findAll(lastUpdate));
    }

    @GetMapping("{id}")
    public ResponseEntity<TestCaseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tcService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(
            @RequestBody TestCaseDto testCase,
            @PathVariable Long id
    ) {
        tcService.update(id, testCase);
        return ResponseEntity.ok("Updated succesfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        tcService.delete(id);
        return ResponseEntity.ok("Deleted succesfully");
    }



}
