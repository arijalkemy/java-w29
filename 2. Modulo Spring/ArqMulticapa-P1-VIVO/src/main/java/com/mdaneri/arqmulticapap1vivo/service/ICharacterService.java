package com.mdaneri.arqmulticapap1vivo.service;

import com.mdaneri.arqmulticapap1vivo.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    List<CharacterDTO> findByName(String name);

}
