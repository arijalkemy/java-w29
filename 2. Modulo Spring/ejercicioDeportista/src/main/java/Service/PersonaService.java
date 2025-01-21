package Service;

import DTO.PersonaDTO;
import Model.Deporte;
import Model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaService {

    private List<Persona> persona = new ArrayList<Persona>();

    public PersonaService() {
        persona.add(new Persona("John", "Doe", 25, new Deporte("Football", "High")));
        persona.add(new Persona("Jane", "Smith", 30, new Deporte("Basketball", "Medium")));
        persona.add(new Persona("Tom", "Johnson", 28, new Deporte("Tennis", "Low")));
    }

    public List<PersonaDTO> getAllPeople() {
        List<PersonaDTO> peopleDTOList = new ArrayList<>();
        for (Persona person : persona) {
            peopleDTOList.add(new PersonaDTO(person.getNombre(),person.getApellido(),person.getDeporte().getNombre()));
        }
        return peopleDTOList;
    }
}
