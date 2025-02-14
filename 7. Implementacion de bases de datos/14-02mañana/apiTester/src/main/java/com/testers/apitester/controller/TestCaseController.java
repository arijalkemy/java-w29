package com.testers.apitester.controller;

import com.testers.apitester.model.TestCase;
import com.testers.apitester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public String createTest(@RequestBody TestCase testCase){
        testCaseService.saveTestCase(testCase);
        return "Se creo el test";
    }

    @GetMapping("/api/testcases")
    public List<TestCase> getTests(){
        return testCaseService.getTestCase();
    }

    @GetMapping("/api/testcases/{id}")
    public TestCase getTests(@PathVariable Long id){
        return testCaseService.findTestById(id);
    }

    @PutMapping("/api/testcases/{id}")
    public String editTestCase(@PathVariable Long id,
                               @RequestBody TestCase testCase){
        TestCase test = testCaseService.findTestById(id);
        test.setDescription(testCase.getDescription());
        test.setTested(testCase.getTested());
        test.setPassed(testCase.getPassed());
        test.setNumber_of_tries(testCase.getNumber_of_tries());
        test.setLast_update(LocalDate.now());
        testCaseService.saveTestCase(test);
        return "Test modificado con éxito";
    }

    @DeleteMapping("/api/testcases/{id}")
    public String deleteTestCase(@PathVariable Long id){
        testCaseService.deleteTest(id);
        return "Test deleted";
    }
}
