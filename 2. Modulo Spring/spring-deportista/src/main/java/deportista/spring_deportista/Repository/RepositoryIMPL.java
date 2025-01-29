package deportista.spring_deportista.Repository;

import deportista.spring_deportista.Model.Person;
import deportista.spring_deportista.Model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RepositoryIMPL implements IRepository{
    private List<Sport> mySports;
    private List<Person> athletes;

    public RepositoryIMPL() {
        this.mySports = new ArrayList<>();
        mySports.add(new Sport(1,"Fútbol", 1));
        mySports.add(new Sport(2,"Baloncesto", 2));
        mySports.add(new Sport(3,"Tenis", 3));

        this.athletes = new ArrayList<>();
        athletes.add(new Person("Matias","Leal",28,2));
        athletes.add(new Person("Ana", "Gonzalez", 25, 3));
        athletes.add(new Person("Carlos", "Rodriguez", 32, 1));
        athletes.add(new Person("Luis", "Perez", 24, 2));
        athletes.add(new Person("Maria", "Lopez", 27, 3));
        athletes.add(new Person("Pedro", "Martinez", 30, 1));

    }

    @Override
    public List<Sport> getAllSports() {
        return mySports;
    }

    @Override
    public Sport findSPort(String name) {
        return mySports.stream().filter(s->s.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @Override
    public List<Person> getAthletes() {
        return athletes;
    }

    @Override
    public Sport findSportById(Integer sportId) {
        return mySports.stream().filter(s->s.getSportId().equals(sportId)).findFirst().get();
    }
}
