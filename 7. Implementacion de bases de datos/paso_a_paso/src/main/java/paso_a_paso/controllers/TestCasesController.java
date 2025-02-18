package paso_a_paso.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {
  
  @PostMapping("/new")
  public String createTestCase() {
    return "Create Test Case";
  }

  @GetMapping
  public String getTestCases(
    @RequestParam(required = false) String last_update
  ) {
    return "Get Test Cases";
  }

  @GetMapping("/{id}")
  public String getTestCaseById() {
    return "Get Test Case by Id";
  }

  @PutMapping("/{id}")
  public String updateTestCaseById() {
    return "Update Test Case by Id";
  }

  @DeleteMapping("/{id}")
  public String deleteTestCaseById() {
    return "Delete Test Case by Id";
  }  
}