package meli.ejercicio.controller;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.dto.TestCaseDto;
import meli.ejercicio.service.TestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {
    private final TestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> create(@RequestBody TestCaseDto testCaseDto) {
        return ResponseEntity.ok(testCaseService.createTestCase(testCaseDto));
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDto>> getTestCases() {
        return ResponseEntity.ok(testCaseService.getAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@RequestBody TestCaseDto testCaseDto, @PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.updateTestCase(testCaseDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/date")
    public ResponseEntity<List<TestCaseDto>> getTestCasesByFecha(@RequestParam(name = "last_update") LocalDate fecha) {
        return ResponseEntity.ok(testCaseService.getTestCasesByFecha(fecha));
    }
}
