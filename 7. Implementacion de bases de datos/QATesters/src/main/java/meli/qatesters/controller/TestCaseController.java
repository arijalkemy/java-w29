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
    public ResponseEntity<?> postTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCase(
            @RequestParam(required = false, value = "lastUpdate")
            @DateTimeFormat(pattern = "dd/MM/yyyy")
            LocalDate lastUpdate
    ){
        if(Objects.isNull(lastUpdate)){
            return new ResponseEntity<>(testCaseService.searchListTestCase(), HttpStatus.OK);
        }
        return new ResponseEntity<>(testCaseService.listLastUpdatedTestCaseByAfterDate(lastUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.searchTestCase(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putTestCase(@PathVariable Long id, @RequestBody TestCaseRequestDTO testCaseRequestDTO ){
        return new ResponseEntity<>(testCaseService.modifyTestCase(id, testCaseRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTesCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }



}
