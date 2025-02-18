package com.meli.qatesters.controller;

import com.meli.qatesters.model.TestCase;
import com.meli.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    ITestCaseService testCaseService;


    @PostMapping("/api/testcases/new")
    public ResponseEntity<String> newTestCase(@RequestBody TestCase testCase) {
        testCaseService.saveTestCase(testCase);
        return new ResponseEntity<>("Test creado correctamente", HttpStatus.CREATED);
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<String> updateTestCase(@RequestBody TestCase testCase, @PathVariable Long id) {
        testCaseService.updateTestCase(testCase, id);
        return new ResponseEntity<>("Test actualizado correctamente", HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCase>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.findTestCase(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<String> deleteTestCaseById(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>("Test eliminado correctamente", HttpStatus.OK);
    }

    @GetMapping("/api/testcases/lastUpdate")
    public ResponseEntity<List<TestCase>> getTestCases(@RequestParam("last_update") String lastUpdateStr) {
            return new ResponseEntity<>(testCaseService.getTestCasesLastUpdate(lastUpdateStr), HttpStatus.OK);
    }
}
