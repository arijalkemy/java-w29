package com.mercadolibre.bootcamp.qatesters.controller;

import com.mercadolibre.bootcamp.qatesters.dto.TestCaseDto;
import com.mercadolibre.bootcamp.qatesters.dto.response.MessageDto;
import com.mercadolibre.bootcamp.qatesters.service.ITestCaseService;
import com.mercadolibre.bootcamp.qatesters.service.TestCaseServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService tcService;
    private final TestCaseServiceImpl testCaseServiceImpl;

    public TestCaseController(ITestCaseService tcService, TestCaseServiceImpl testCaseServiceImpl) {
        this.tcService = tcService;
        this.testCaseServiceImpl = testCaseServiceImpl;
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
    public ResponseEntity<MessageDto> updateById(
            @RequestBody TestCaseDto testCaseDto,
            @PathVariable Long id
    ) {
        MessageDto responseMessage = testCaseServiceImpl.update(id, testCaseDto);
        return ResponseEntity.ok(responseMessage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable Long id) {
        MessageDto responseMessage = testCaseServiceImpl.delete(id);
        return ResponseEntity.ok(responseMessage);
    }



}
