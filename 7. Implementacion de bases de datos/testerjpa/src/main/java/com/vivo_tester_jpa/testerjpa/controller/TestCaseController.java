package com.vivo_tester_jpa.testerjpa.controller;

import com.vivo_tester_jpa.testerjpa.dto.MessageDto;
import com.vivo_tester_jpa.testerjpa.model.TestCase;
import com.vivo_tester_jpa.testerjpa.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
public class TestCaseController {

    @Autowired
    private ITestCaseService serv;

    @PostMapping("/testcases")
    public ResponseEntity<MessageDto> newTestCase(@RequestBody TestCase tc) {

        return new ResponseEntity<>(serv.saveTestCase(tc), HttpStatus.OK);
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCase>> getAllTestCases(@RequestParam(value = "last_update", required = false) LocalDate lastUpdate) {
        if (lastUpdate != null) {
            return new ResponseEntity<>(serv.getTestCasesByLastUpdateAfter(lastUpdate), HttpStatus.OK);
        }
        return new ResponseEntity<>(serv.getAllTestCase(), HttpStatus.OK);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCase> getById(@PathVariable Long id) {
        return new ResponseEntity<>(serv.getTestCaseById(id), HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<MessageDto> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(serv.deleteTestCase(id), HttpStatus.OK);
    }
}
