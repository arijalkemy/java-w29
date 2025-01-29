package calcularedad.spring_calcularedad.Repository;

import calcularedad.spring_calcularedad.Model.Persona;

import java.util.List;

public class PersonaRepository {
    private List<Persona> personas;


    public PersonaRepository() {}
    public PersonaRepository(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona(Persona persona) {
        this.personas.add(persona);
    }
}
