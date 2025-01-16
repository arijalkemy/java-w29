package com.meli.covid19.dto;
import com.meli.covid19.model.SintomaModel;
import java.util.List;

public class PersonaDTO {
    public String nombre;
    public String apellido;
    public Integer edad;
    public List<SintomaModel> sintomas;

    public PersonaDTO(String apellido, Integer edad, String nombre, List<SintomaModel> sintomas) {
        this.apellido = apellido;
        this.edad = edad;
        this.nombre = nombre;
        this.sintomas = sintomas;
    }
}
