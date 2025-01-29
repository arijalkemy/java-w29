package deportista.spring_deportista.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import deportista.spring_deportista.Dto.ResponseAthlete;
import deportista.spring_deportista.Model.Person;
import deportista.spring_deportista.Model.Sport;

import java.util.List;
import java.util.stream.Collectors;

public class Service implements Iservice{

    private IRepository myRepository =  new RepositoryIMPL();

    @Override
    public List<Sport> getAllSports() {
        return myRepository.getAllSports();
    }

    @Override
    public Sport findSPort(String name) {
        return myRepository.findSPort(name);
    }

    @Override
    public List<ResponseAthlete> getAthletes() {
        List<Person> myAthletes = myRepository.getAthletes();
        ObjectMapper om = new ObjectMapper();
        return myAthletes.stream()
                .map(
                        a->new ResponseAthlete(a.getName(), a.getLastname(), myRepository.findSportById(a.getFkSportId()).getName())).toList();
    }
}
