package jpa.qa_testers.controller;

import jpa.qa_testers.entity.response.AllTestsCasesDTO;
import jpa.qa_testers.entity.response.ResponseWrapperDTO;
import jpa.qa_testers.entity.resquest.TestCaseRequestDTO;
import jpa.qa_testers.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<ResponseWrapperDTO> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.createTestCase(testCaseRequestDTO));
    }

    @PutMapping("/{caseId}")
    public ResponseEntity<ResponseWrapperDTO> updateTestCase(@PathVariable Long caseId, @RequestBody TestCaseRequestDTO testCaseRequestDTO) {
        return ResponseEntity.ok(testCaseService.updateTestCase(caseId, testCaseRequestDTO));
    }

    @DeleteMapping("/{caseId}")
    public ResponseEntity<ResponseWrapperDTO> deleteTestCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(testCaseService.deleteTestCase(caseId));
    }

    @GetMapping("/{caseId}")
    public ResponseEntity<TestCaseRequestDTO> getTestCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(testCaseService.getTestCase(caseId));
    }


    @GetMapping
    public ResponseEntity<AllTestsCasesDTO> filterByDate(@RequestParam(required = false) String last_update) {
        if (last_update == null) {
            return ResponseEntity.ok(testCaseService.getAllTestCases());
        }
        return ResponseEntity.ok(testCaseService.filterByDate(last_update));
    }

    @GetMapping("/tested")
    public ResponseEntity<AllTestsCasesDTO> filterIsTested() {
        return ResponseEntity.ok(testCaseService.filterIsTested());
    }
}