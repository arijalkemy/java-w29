package com.example.starWars.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import com.example.starWars.repositories.CharacterRepo;

import com.example.starWars.entities.Character;

@Service
@RequiredArgsConstructor
public class FindCharacters {
    private final CharacterRepo characterRepo;

    public List<Character> findByName(String name){
        return characterRepo.getCharacters().stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
