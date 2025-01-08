package com.bootcamp;

public class Participante {

    private Integer numero;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer dni;
    private Integer celular;
    private Integer numeroEmergencia;
    private String grupoSanguineo;

    public Participante() {
    }

    public Participante(Integer numero, String nombre, String apellido, Integer edad, Integer dni, Integer celular, Integer numeroEmergencia, String grupoSanguineo) {
        this.numero = numero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(Integer numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                ", celular=" + celular +
                ", numeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
