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

    @PutMapping("/api/testcases/{id}")
    public String editTestCase(@PathVariable Long id,
                               @RequestParam ("description") String description,
                               @RequestParam ("tested") Boolean tested,
                               @RequestParam ("pased") Boolean pased,
                               @RequestParam ("number_of_tries") int number_of_tries){
        TestCase test = testCaseService.findTestById(id);
        test.setDescription(description);
        test.setTested(tested);
        test.setPassed(pased);
        test.setNumber_of_tries(number_of_tries);
        test.setLast_update(LocalDate.now());
        testCaseService.saveTestCase(test);
        return "Test modificado con éxito";
    }
}
