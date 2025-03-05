package com.example.literaryWorks.controller;

import com.example.literaryWorks.dto.WorkDTO;
import com.example.literaryWorks.service.IWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work")
public class WorkController {
    private final IWorkService workService;

    @GetMapping
    ResponseEntity<List<WorkDTO>> findAll() {
        return ResponseEntity.ok(workService.findAll());
    }

    @PostMapping
    ResponseEntity<WorkDTO> save(@RequestBody WorkDTO workDTO) {
        return ResponseEntity.ok(workService.save(workDTO));
    }

    @GetMapping("/name")
    ResponseEntity<List<WorkDTO>> findWorksByName(@RequestParam(name = "author") String name) {
        return ResponseEntity.ok(workService.findWorksByName(name));
    }

    @GetMapping("/word")
    ResponseEntity<List<WorkDTO>> findWorksByWordInName(@RequestParam String word) {
        return ResponseEntity.ok(workService.findWorksByWordInName(word));
    }

    @GetMapping("/top_five")
    ResponseEntity<List<WorkDTO>> findWorksByPagesOrderByPagesDesc() {
        return ResponseEntity.ok(workService.findWorksByPagesOrderByPagesDesc());
    }

    @GetMapping("/year/{publishedYear}")
    ResponseEntity<List<WorkDTO>> findWorksByPublishedYear(@PathVariable Integer publishedYear) {
        return ResponseEntity.ok(workService.findWorksByPublishedYear(publishedYear));
    }

    @GetMapping("/publisher/{publisher}")
    ResponseEntity<List<WorkDTO>> findWorksByPublisher(@PathVariable String publisher) {
        return ResponseEntity.ok(workService.findWorksByPublisher(publisher));
    }
}
