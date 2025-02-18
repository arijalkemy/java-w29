package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.controller;

import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto.MessageDto;
import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto.ObrasLiterariasDto;
import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.service.IObrasLiteriariasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObrasLiterariasController {
    private final IObrasLiteriariasService service;

    public ObrasLiterariasController(IObrasLiteriariasService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postObras (@RequestBody ObrasLiterariasDto obrasLiterariasDto) {
        return ResponseEntity.ok(service.saveObras(obrasLiterariasDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ObrasLiterariasDto>> getObras () {
        return  ResponseEntity.ok(service.searchAllObras());
    }

    @GetMapping("/autor/{nombre}")
    public ResponseEntity<List<ObrasLiterariasDto>> getObrasByAutor(@PathVariable String nombre) {
        return ResponseEntity.ok(service.searchAllObrasPorAutor(nombre));
    }

    @GetMapping("/titulo/{nombre}")
    public ResponseEntity<List<ObrasLiterariasDto>> getObrasByTitulo(@PathVariable String nombre) {
        return ResponseEntity.ok(service.searchAllObrasPorTitulo(nombre));
    }

    @GetMapping("/añoPublicacion/{ano}")
    public ResponseEntity<List<ObrasLiterariasDto>> getObrasByAñoPublicacion(@PathVariable int ano) {
        return ResponseEntity.ok(service.searchAllObrasPorAño(ano));
    }

    @GetMapping("/editorial/{nombre}")
    public ResponseEntity<List<ObrasLiterariasDto>> getObrasByEditorial(@PathVariable String nombre) {
        return ResponseEntity.ok(service.searchAllObrasPorEditorial(nombre));
    }
}
