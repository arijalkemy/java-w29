package ejercicios.meli.controller;

import ejercicios.meli.entity.ObraLitearia;
import ejercicios.meli.services.ObraLiterariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra-literaria")
@RequiredArgsConstructor
public class ObraLiterariaController {
    private final ObraLiterariaService obraLiterariaService;

    @PostMapping("/crear")
    public ResponseEntity<ObraLitearia> crearObraLiteraria(@RequestBody ObraLitearia obraLitearia) {
        return ResponseEntity.ok(obraLiterariaService.save(obraLitearia));
    }


    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLitearia>> getAllObrasLiterariasByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(obraLiterariaService.getByAutor(autor));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ObraLitearia>> getAllObrasLiterariasByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(obraLiterariaService.getByNombre(nombre));
    }

    @GetMapping("/top-5")
    public ResponseEntity<List<ObraLitearia>> getTop5ObrasLiterarias() {
        return ResponseEntity.ok(obraLiterariaService.getTop5ObrasLiterarias());
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<ObraLitearia>> getAllObrasLiterariasByAnio(@PathVariable Integer anio) {
        return ResponseEntity.ok(obraLiterariaService.getByBeforeThanAnio(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLitearia>> getAllObrasLiterariasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(obraLiterariaService.getByEditorial(editorial));
    }
}
