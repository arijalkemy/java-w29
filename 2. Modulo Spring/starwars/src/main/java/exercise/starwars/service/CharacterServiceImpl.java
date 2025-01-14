package exercise.starwars.service;

import exercise.starwars.dto.response.CharacterResponseDto;
import exercise.starwars.entity.MovieCharacter;
import exercise.starwars.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements ICharacterService {

    private final ICharacterRepository characterRepository;

    public CharacterServiceImpl(ICharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<CharacterResponseDto> getCharactersByName(String search) {
        List<MovieCharacter> characters = characterRepository.getCharactersByName(search);
        List<CharacterResponseDto> characterResponseDtos = new ArrayList<>();

        for (MovieCharacter movieCharacter : characters) {
            CharacterResponseDto characterResponseDto = new CharacterResponseDto();

            characterResponseDto.setName(movieCharacter.getName());
            characterResponseDto.setHeight(movieCharacter.getHeight());
            characterResponseDto.setMass(movieCharacter.getMass());
            characterResponseDto.setGender(movieCharacter.getGender());
            characterResponseDto.setHomeworld(movieCharacter.getHomeworld());
            characterResponseDto.setSpecies(movieCharacter.getSpecies());

            characterResponseDtos.add(characterResponseDto);

        }

        return characterResponseDtos;
    }
}
