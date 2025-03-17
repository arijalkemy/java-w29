package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.model.ObraLiteraria;
import com.example.obrasliterarias.service.IObrasLiterariasService;
import com.example.obrasliterarias.service.ObrasLiterariasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ObrasLiterariasController {
    private final ObrasLiterariasService obrasLiterariasService;

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByAutor(@PathVariable String autor) {
        List<ObraLiteraria> obras = obrasLiterariasService.getObrasByAutor(autor);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<ObraLiteraria>> getObrasByTitleContaining(@RequestParam String keyword) {
        List<ObraLiteraria> obras = obrasLiterariasService.getObrasByTitleContaining(keyword);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/top5")
    public ResponseEntity<List<ObraLiteraria>> getTop5ObrasByPages() {
        List<ObraLiteraria> obras = obrasLiterariasService.getTop5ObrasByPages();
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/publicadas-antes")
    public ResponseEntity<List<ObraLiteraria>> getObrasPublishedBeforeYear(@RequestParam Integer year) {
        List<ObraLiteraria> obras = obrasLiterariasService.getObrasPublishedBeforeYear(year);
        return ResponseEntity.ok(obras);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByEditorial(@PathVariable String editorial) {
        List<ObraLiteraria> obras = obrasLiterariasService.getObrasByEditorial(editorial);
        return ResponseEntity.ok(obras);
    }
}
