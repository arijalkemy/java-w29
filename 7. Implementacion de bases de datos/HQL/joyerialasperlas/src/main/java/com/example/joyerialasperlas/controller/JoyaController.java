package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.dto.in.JoyaIdDto;
import com.example.joyerialasperlas.dto.out.EditadoDto;
import com.example.joyerialasperlas.dto.out.MessageDto;
import com.example.joyerialasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    private IJoyaService iJoyaService;

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postJewerly(
            @RequestBody @Valid JoyaDto joyaDto
    ){
        return ResponseEntity.ok(this.iJoyaService.addJewerly(joyaDto));
    }

    @GetMapping
    public ResponseEntity<List<JoyaDto>> getAll(){
        return ResponseEntity.ok(this.iJoyaService.searchAll());
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<MessageDto> deleteById(
            @PathVariable Long id
    ) throws Exception {
        return ResponseEntity.ok(this.iJoyaService.deleteById(id));
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<EditadoDto> putById(
            @RequestBody @Valid JoyaIdDto joyaIdDto
    ) {
        return ResponseEntity.ok(this.iJoyaService.modify(joyaIdDto));
    }
}
