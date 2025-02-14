package exercise.qa_testers.controller;

import exercise.qa_testers.dto.request.TestCaseRequestDto;
import exercise.qa_testers.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class testCaseController {
    private final ITestCaseService testCaseService;

    public testCaseController(ITestCaseService testCaseService){
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveTestCase(@RequestBody TestCaseRequestDto testCaseRequestDto){
        this.testCaseService.save(testCaseRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) LocalDate lastUpdate){
        return new ResponseEntity<>(this.testCaseService.getAll(lastUpdate), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(this.testCaseService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TestCaseRequestDto testCaseRequestDto){
        return new ResponseEntity<>(this.testCaseService.update(testCaseRequestDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        this.testCaseService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
