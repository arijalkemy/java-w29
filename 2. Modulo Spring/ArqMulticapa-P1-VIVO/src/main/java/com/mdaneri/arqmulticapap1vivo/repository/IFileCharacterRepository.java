package com.mdaneri.arqmulticapap1vivo.repository;

import com.mdaneri.arqmulticapap1vivo.dto.CharacterDTO;
import com.mdaneri.arqmulticapap1vivo.entity.Character;

import java.util.List;

public interface IFileCharacterRepository {

    List<Character> findAll();
    List<Character> findByName(String name);

}
