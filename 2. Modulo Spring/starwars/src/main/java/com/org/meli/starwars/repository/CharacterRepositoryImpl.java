package com.org.meli.starwars.repository;

import com.org.meli.starwars.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {
    private final List<Character> characters = List.of(
            new Character("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19BBY", "Male", "Tatooine", "Human"),
            new Character("Darth Vader", 202, 136, "None", "White", "Yellow", "41.9BBY", "Male", "Tatooine", "Human"),
            new Character("Leia Organa", 150, 49, "Brown", "Light", "Brown", "19BBY", "Female", "Alderaan", "Human"),
            new Character("Han Solo", 180, 80, "Brown", "Fair", "Brown", "29BBY", "Male", "Corellia", "Human"),
            new Character("Yoda", 66, 17, "White", "Green", "Brown", "896BBY", "Male", "Unknown", "Yoda's species"),
            new Character("Obi-Wan Kenobi", 182, 77, "Auburn", "Fair", "Blue-gray", "57BBY", "Male", "Stewjon", "Human"),
            new Character("Chewbacca", 228, 112, "Brown", "Unknown", "Blue", "200BBY", "Male", "Kashyyyk", "Wookiee"),
            new Character("Lando Calrissian", 177, 79, "Black", "Dark", "Brown", "31BBY", "Male", "Socorro", "Human"),
            new Character("Boba Fett", 183, 78, "Black", "Fair", "Brown", "31.5BBY", "Male", "Kamino", "Human"),
            new Character("Jabba the Hutt", 175, 1358, "None", "Green-tan", "Orange", "600BBY", "Hermaphrodite", "Nal Hutta", "Hutt"),
            new Character("Padmé Amidala", 165, 45, "Brown", "Light", "Brown", "46BBY", "Female", "Naboo", "Human"),
            new Character("Qui-Gon Jinn", 193, 89, "Brown", "Fair", "Blue", "80BBY", "Male", "Coruscant", "Human"),
            new Character("Mace Windu", 188, 84, "None", "Dark", "Brown", "72BBY", "Male", "Haruun Kal", "Human"),
            new Character("Ahsoka Tano", 167, 55, "None", "Orange", "Blue", "36BBY", "Female", "Shili", "Togruta"),
            new Character("Grogu", 42, 15, "None", "Green", "Black", "41BBY", "Male", "Unknown", "Yoda's species"),
            new Character("Darth Maul", 175, 80, "None", "Red", "Yellow", "54BBY", "Male", "Dathomir", "Zabrak"),
            new Character("Darth Sidious", 170, 75, "None", "Pale", "Yellow", "82BBY", "Male", "Naboo", "Human"),
            new Character("Darth Plagueis", 198, 90, "None", "Pale", "Yellow", "147BBY", "Male", "Mygeeto", "Muun"),
            new Character("Darth Bane", 191, 95, "None", "Pale", "Yellow", "1026BBY", "Male", "Apatros", "Human"),
            new Character("Darth Revan", 185, 85, "Black", "Fair", "Brown", "3994BBY", "Male", "Unknown", "Human")
    );

    @Override
    public List<Character> findCharacterByName(String name) {
        return characters.stream()
                .filter(character -> character.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
