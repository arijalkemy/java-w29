package exercise.es_obras_literarias.controller;

import exercise.es_obras_literarias.domain.Obra;
import exercise.es_obras_literarias.dto.request.ObraRequestDto;
import exercise.es_obras_literarias.dto.response.ObraResponseDto;
import exercise.es_obras_literarias.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras_literarias")
public class ObraController {

    private final IObraService obraService;

    public ObraController(IObraService obraService){
        this.obraService = obraService;
    }

    @PostMapping
    public ResponseEntity<ObraResponseDto> save(@RequestBody ObraRequestDto obraRequestDto){
        return new ResponseEntity<>(this.obraService.save(obraRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<ObraResponseDto>> findByAuthor(@PathVariable String author){
        return ResponseEntity.ok(this.obraService.findByAuthor(author));
    }

    @GetMapping("/top-5")
    public ResponseEntity<List<ObraResponseDto>> findTop5CantidadPaginas(){
        return ResponseEntity.ok(this.obraService.findTop5CantidadPaginas());
    }

    @GetMapping("/before/{year}")
    public ResponseEntity<List<ObraResponseDto>> findByAnioBefore(@PathVariable Integer year){
        return ResponseEntity.ok(this.obraService.findByAnioPublicacionBefore(year));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraResponseDto>> findByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(this.obraService.findByEditorial(editorial));
    }

    @GetMapping("/obra/{nombre}")
    public ResponseEntity<List<ObraResponseDto>> findByNombreObra(@PathVariable String nombre){
        return ResponseEntity.ok(this.obraService.findByName(nombre));
    }
}
