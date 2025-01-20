package Ex2;

import java.util.List;

public class Curriculum {

        private String name;
        private String description;
        private String surname;
        private int age;
        private List<String> skills;

    public Curriculum(String name, String description, String surname, int age, List<String> skills) {
        this.name = name;
        this.description = description;
        this.surname = surname;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}
