package com.Covid_19.covid.DTO;

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String sintoma;

    public PersonaDTO(String nombre, String apellido, Integer edad, String sintoma) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintoma = sintoma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }
}
