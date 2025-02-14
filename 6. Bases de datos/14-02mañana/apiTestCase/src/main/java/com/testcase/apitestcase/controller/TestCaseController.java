package com.testcase.apitestcase.controller;

import com.testcase.apitestcase.model.TestCase;
import com.testcase.apitestcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class TestCaseController {

    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public String createTestCase(@RequestBody TestCase testCase){
        testCaseService.saveTestCase(testCase);
        return "Test created";
    }

    @GetMapping("/api/testcases")
    public List<TestCase> getAllTestsCases(){
        return testCaseService.getAllTestCase();
    }

    @GetMapping("/api/testcases/{id}")
    public Optional<TestCase> getTestById(@PathVariable Long id){
        return testCaseService.findTestCase(id);
    }

    @PutMapping("/api/testcases/{id}")
    public TestCase editTestCase(@PathVariable Long id,
                               @RequestBody TestCase testCase){
        TestCase test = testCaseService.findTestCase(id).orElse(null);
        test.setDescription(testCase.getDescription());
        test.setTested(testCase.getTested());
        test.setPassed(testCase.getPassed());
        test.setNumber_of_tries(testCase.getNumber_of_tries());
        test.setLast_update(LocalDate.now());
        testCaseService.saveTestCase(test);
        return test;
    }

    @DeleteMapping("/api/testcases/{id}")
    public String deleteTestCase(@PathVariable Long id){
        testCaseService.deleteTestCase(id);
        return "Test deleted";
    }
}
