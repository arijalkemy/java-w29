package com.mdaneri.arqmulticapap1vivo.service;

import com.mdaneri.arqmulticapap1vivo.dto.CharacterDTO;
import com.mdaneri.arqmulticapap1vivo.repository.FileCharacterRepositoryImpl;
import com.mdaneri.arqmulticapap1vivo.repository.IFileCharacterRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    private final IFileCharacterRepository fileCharacterRepository;

    public CharacterServiceImpl(IFileCharacterRepository fileCharacterRepository) {
        this.fileCharacterRepository = fileCharacterRepository;
    }

    @Override
    public List<CharacterDTO> findByName(String name) {
        return fileCharacterRepository
                .findByName(name)
                .stream()
                .map(CharacterDTO::from)
                .toList();
    }


}
