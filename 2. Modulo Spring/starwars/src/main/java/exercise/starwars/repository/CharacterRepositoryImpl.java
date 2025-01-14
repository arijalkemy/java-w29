package exercise.starwars.repository;

import exercise.starwars.entity.MovieCharacter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CharacterRepositoryImpl implements ICharacterRepository {

    private List<MovieCharacter> characters;

    public CharacterRepositoryImpl() {
        characters = new ArrayList<>();

        characters.add(new MovieCharacter("Gasgano", 122, 0, "none", "white, blue", "black", "NA", "male", "Troiken", "Xexto"));
        characters.add(new MovieCharacter("Ben Quadinaros", 163, 65, "none", "grey, green, yellow", "orange", "NA", "male", "Tund", "Toong"));
        characters.add(new MovieCharacter("Mace Windu", 188, 84, "none", "dark", "brown", "72BBY", "male", "Haruun Kal", "Human"));
        characters.add(new MovieCharacter("Ki-Adi-Mundi", 198, 82, "white", "pale", "yellow", "92BBY", "male", "Cerea", "Cerean"));
        characters.add(new MovieCharacter("Kit Fisto", 196, 87, "none", "green", "black", "NA", "male", "Glee Anselm", "Nautolan"));
        characters.add(new MovieCharacter("Eeth Koth", 171, 0, "black", "brown", "brown", "78BBY", "male", "Iziz", "Zabrak"));
        characters.add(new MovieCharacter("Dexter Jettster", 198, 102, "none", "brown", "yellow", "NA", "male", "Ojom", "Besalisk"));
        characters.add(new MovieCharacter("Lama Su", 229, 88, "none", "grey", "black", "NA", "male", "Kamino", "Kaminoan"));
        characters.add(new MovieCharacter("Taun We", 213, 0, "none", "grey", "black", "NA", "female", "Kamino", "Kaminoan"));
        characters.add(new MovieCharacter("Jocasta Nu", 167, 0, "white", "fair", "blue", "NA", "female", "Coruscant", "Human"));
        characters.add(new MovieCharacter("Ratts Tyerell", 79, 15, "none", "grey, blue", "NA", "NA", "male", "Aleen Minor", "Aleena"));
        characters.add(new MovieCharacter("R4-P17", 96, 0, "none", "silver, red", "red", "NA", "none", "NA", "Droid"));
        characters.add(new MovieCharacter("BB8", 0, 0, "none", "none", "black", "NA", "none", "NA", "Droid"));
        characters.add(new MovieCharacter("Captain Phasma", 0, 0, "NA", "NA", "NA", "NA", "female", "NA", "NA"));
        characters.add(new MovieCharacter("Padmé Amidala", 165, 45, "brown", "light", "brown", "46BBY", "female", "Naboo", "Human"));
        characters.add(new MovieCharacter("Jar Jar Binks", 196, 66, "none", "orange", "orange", "52BBY", "male", "Naboo", "Gungan"));
        characters.add(new MovieCharacter("Roos Tarpals", 224, 82, "none", "grey", "orange", "NA", "male", "Naboo", "Gungan"));
        characters.add(new MovieCharacter("Rugor Nass", 206, 0, "none", "green", "orange", "NA", "male", "Naboo", "Gungan"));
        characters.add(new MovieCharacter("Ric Olié", 183, 0, "brown", "fair", "blue", "NA", "male", "Naboo", "NA"));
        characters.add(new MovieCharacter("Watto", 137, 0, "black", "blue, grey", "yellow", "NA", "male", "Toydaria", "Toydarian"));
        characters.add(new MovieCharacter("Sebulba", 112, 40, "none", "grey, red", "orange", "NA", "male", "Malastare", "Dug"));
        characters.add(new MovieCharacter("Quarsh Panaka", 183, 0, "black", "dark", "brown", "NA", "male", "NA", "Human"));
    }

    @Override
    public List<MovieCharacter> getCharactersByName(String search) {
        return characters.stream()
                .filter(c -> c.getName().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }
}
