package exercise.starwars.repository;

import exercise.starwars.entity.MovieCharacter;

import java.util.List;

public interface ICharacterRepository {

    List<MovieCharacter> getCharactersByName(String search);
}
