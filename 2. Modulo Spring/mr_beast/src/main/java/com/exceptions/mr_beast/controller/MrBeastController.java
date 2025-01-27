package com.exceptions.mr_beast.controller;

import com.exceptions.mr_beast.dto.BlogEntryDto;
import com.exceptions.mr_beast.model.BlogEntry;
import com.exceptions.mr_beast.service.MrBeastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MrBeastController {
    private final MrBeastService mrBeastService;

    @PostMapping("/blog")
    public ResponseEntity<BlogEntry> addBlogEntry(@RequestBody BlogEntryDto blogRequest) {
        return ResponseEntity.ok(mrBeastService.addBlogEntry(blogRequest));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryDto> getBlogEntry(@PathVariable Integer id) {
        return ResponseEntity.ok(mrBeastService.getBlogEntryById(id));
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getBlogEntries() {
        return ResponseEntity.ok(mrBeastService.getBlogEntries());
    }
}
