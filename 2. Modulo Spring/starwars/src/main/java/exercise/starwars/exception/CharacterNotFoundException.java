package exercise.starwars.exception;

public class CharacterNotFoundException extends  RuntimeException{

    public CharacterNotFoundException(String message) {
        super(message);
    }

}
