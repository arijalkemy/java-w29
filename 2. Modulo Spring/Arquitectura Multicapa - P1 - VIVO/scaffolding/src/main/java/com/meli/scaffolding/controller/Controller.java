package com.meli.scaffolding.controller;

import com.meli.scaffolding.dto.CharacterDto;
import com.meli.scaffolding.service.ICharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ICharacterService characterService;

    @GetMapping("/{query}")
    public List<CharacterDto> find(@PathVariable String query) {
        return characterService.find(query);
    }
}
