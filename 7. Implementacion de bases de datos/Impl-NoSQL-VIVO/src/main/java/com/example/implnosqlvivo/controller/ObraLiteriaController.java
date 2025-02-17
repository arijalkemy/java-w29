package com.example.implnosqlvivo.controller;

import com.example.implnosqlvivo.entity.ObraLiteraria;
import com.example.implnosqlvivo.services.ObraLiterariaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra-literaria")
@AllArgsConstructor
public class ObraLiteriaController {

    private final ObraLiterariaServiceImpl obraLiterariaService;

    @PostMapping
    public ResponseEntity<ObraLiteraria> postObraLiteraria(@RequestBody ObraLiteraria obra) {
        ObraLiteraria save = obraLiterariaService.guardarObra(obra);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraLiteraria> obtenerPorId(@PathVariable String id) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorId(id).orElse(null));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiteraria>> obtenerPorAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorAutor(autor));
    }

    @GetMapping("/titulo/{palabraClave}")
    public ResponseEntity<List<ObraLiteraria>> buscarPorTitulo(@PathVariable String palabraClave) {
        return ResponseEntity.ok(obraLiterariaService.buscarPorTitulo(palabraClave));
    }

    @GetMapping("/top5")
    public ResponseEntity<List<ObraLiteraria>> top5MasPaginas() {
        return ResponseEntity.ok(obraLiterariaService.top5MasPaginas());
    }

    // 6. Retornar las obras publicadas antes de un determinado año
    @GetMapping("/antes-de/{anio}")
    public ResponseEntity<List<ObraLiteraria>> publicadasAntesDe(@PathVariable int anio) {
        return ResponseEntity.ok(obraLiterariaService.publicadasAntesDe(anio));
    }

    // 7. Retornar todas las obras de una determinada editorial
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiteraria>> obtenerPorEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.obtenerPorEditorial(editorial));
    }


}
