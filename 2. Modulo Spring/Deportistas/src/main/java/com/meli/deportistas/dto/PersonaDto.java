package com.meli.deportistas.dto;

public class PersonaDto {
    public String nombre;
    public String apellido;
    public Integer edad;
    public String deporte;

    public PersonaDto(String apellido, Integer edad, String nombre, String deporte) {
        this.apellido = apellido;
        this.edad = edad;
        this.nombre = nombre;
        this.deporte = deporte;
    }
}
