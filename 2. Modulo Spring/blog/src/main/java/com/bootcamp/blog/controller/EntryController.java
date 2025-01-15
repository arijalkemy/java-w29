package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {
    @Autowired
    EntryService entryService;
    @PostMapping("/blog")
    public ResponseEntity<Integer> createEntry(@RequestParam Integer id, @RequestBody EntradaBlogDTO entry){
        Integer savedId = entryService.createEntry(id, entry);
        return new ResponseEntity<>(savedId, HttpStatus.CREATED);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<EntradaBlog>> getAllEntries(){
        List<EntradaBlog> entries = entryService.getAllEntries();
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> getEntryByID(@PathVariable Integer id){
        EntradaBlogDTO entryDTO = entryService.getEntryById(id);
        return new ResponseEntity<>(entryDTO,HttpStatus.OK);
    }
}
