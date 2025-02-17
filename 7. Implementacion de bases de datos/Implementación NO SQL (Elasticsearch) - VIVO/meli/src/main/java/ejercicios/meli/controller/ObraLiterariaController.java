package ejercicios.meli.controller;

import ejercicios.meli.entity.ObraLitearia;
import ejercicios.meli.services.ObraLiterariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/obra-literaria")
@RequiredArgsConstructor
public class ObraLiterariaController {
    private final ObraLiterariaService obraLiterariaService;

    @PostMapping("/crear")
    public ResponseEntity<ObraLitearia> crearObraLiteraria(@RequestBody ObraLitearia obraLitearia) {
        return ResponseEntity.ok(obraLiterariaService.save(obraLitearia));
    }
}
