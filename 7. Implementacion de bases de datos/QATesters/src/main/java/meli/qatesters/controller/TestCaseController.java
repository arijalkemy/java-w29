package meli.qatesters.controller;

import meli.qatesters.dto.request.TestCaseRequestDTO;
import meli.qatesters.service.TestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCase(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllTestCase(@RequestParam(required = false, value = "last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        if(Objects.isNull(lastUpdate)){
            return new ResponseEntity<>(testCaseService.getListTestCase(), HttpStatus.OK);
        }
        return new ResponseEntity<>(testCaseService.listLastUpdatedTestCaseByAfterDate(lastUpdate), HttpStatus.OK);
    }

}
