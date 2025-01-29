package deportista.spring_deportista.Repository;

import deportista.spring_deportista.Model.Person;
import deportista.spring_deportista.Model.Sport;

import java.util.List;

public interface IRepository {

    List<Sport> getAllSports();
    Sport findSPort(String name);
    List<Person> getAthletes();
    Sport findSportById(Integer sportId);
}
