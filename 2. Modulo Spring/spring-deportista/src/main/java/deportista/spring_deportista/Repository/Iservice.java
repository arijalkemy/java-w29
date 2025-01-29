package deportista.spring_deportista.Repository;

import deportista.spring_deportista.Dto.ResponseAthlete;
import deportista.spring_deportista.Model.Sport;

import java.util.List;

// It should return Dtos
public interface Iservice {
    List<Sport> getAllSports();
    Sport findSPort(String name);
    List<ResponseAthlete> getAthletes();

}
