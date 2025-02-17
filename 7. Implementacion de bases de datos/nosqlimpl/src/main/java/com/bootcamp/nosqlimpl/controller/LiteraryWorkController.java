package com.bootcamp.nosqlimpl.controller;

import com.bootcamp.nosqlimpl.dto.LiteraryWorkDTO;
import com.bootcamp.nosqlimpl.service.ILiteraryWorkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/literarywork")
public class LiteraryWorkController {

    private ILiteraryWorkService literaryWorkService;

    @PostMapping()
    public ResponseEntity<?> postLiteraryWork(@RequestBody LiteraryWorkDTO literaryWorkDTO){
        return new ResponseEntity<>(literaryWorkService.save(literaryWorkDTO), HttpStatus.CREATED);
    }

    @PostMapping("/batch")
    public ResponseEntity<?> postLiteraryWorkBatch(@RequestBody List<LiteraryWorkDTO> literaryWorkDTO){
        return new ResponseEntity<>(literaryWorkService.saveAll(literaryWorkDTO), HttpStatus.CREATED);
    }

    @GetMapping("/autor")
    public ResponseEntity<?> getAllLiteraryWorkByAutor(@RequestParam String autor){
        return new ResponseEntity<>(literaryWorkService.searchAllByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAllLiteraryWorkByTitleKeyWord(@PathVariable String name){
        return new ResponseEntity<>(literaryWorkService.searchAllByTitleKeyWord(name), HttpStatus.OK);
    }

    @GetMapping("/topfivepagescount")
    public ResponseEntity<?> getTopFiveLiteraryWorkByPagesCount(){
        return new ResponseEntity<>(literaryWorkService.searchTopFiveByPageCount(), HttpStatus.OK);
    }

    @GetMapping("/publicationyear/{year}")
    public ResponseEntity<?> getLiteraryWorkBeforePublicationYear(@PathVariable Integer year){
        return new ResponseEntity<>(literaryWorkService.searchAllByPublicationYear(year), HttpStatus.OK);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<?> getLiteraryWorkByPublisher(@PathVariable String publisher){
        return new ResponseEntity<>(literaryWorkService.searchAllByPublisher(publisher), HttpStatus.OK);
    }
}
