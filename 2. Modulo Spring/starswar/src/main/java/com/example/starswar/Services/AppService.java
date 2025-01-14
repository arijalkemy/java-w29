package com.example.starswar.Services;

import com.example.starswar.DTO.CharacterDTO;
import com.example.starswar.Models.Characterer;
import com.example.starswar.Repositories.AppRepository;
import com.example.starswar.Repositories.IAppRepository;
import jakarta.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppService implements IAppService {

    private IAppRepository appRepository;
    /// Inyección de dependencias.
    public AppService(IAppRepository appRepository) {
        this.appRepository = appRepository;
    }

    public List<CharacterDTO> getCharacterWithName(String name){
        List<Characterer> characters = appRepository.readStarWarsData();
        return characters.stream().filter(c -> c.getName().contains(name))
                .map(c -> {
                    CharacterDTO characterDTO = new CharacterDTO();
                    characterDTO.setName(c.getName());
                    characterDTO.setGender(c.getGender());
                    characterDTO.setHomeworld(c.getHomeworld());
                    characterDTO.setMass(c.getMass());
                    characterDTO.setSpecies(c.getSpecies());
                    characterDTO.setHeight(c.getHeight());
                    return characterDTO;
                }).collect(Collectors.toList());
    }
}
