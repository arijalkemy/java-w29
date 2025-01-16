package classes;

import java.util.List;

public class Curriculum extends Document {
    private Person person;
    private List<String> abilities;

    public Curriculum(Person person, List<String> abilities) {
        this.person = person;
        this.abilities = abilities;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Curriculum - Person: " +
                person.toString() +
                ". Abilities: " +
                abilities.toString() +
                ".";
    }
}
