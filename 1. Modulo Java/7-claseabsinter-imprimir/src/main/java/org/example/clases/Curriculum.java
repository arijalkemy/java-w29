package org.example.clases;

import java.util.ArrayList;

//Curriculums: incluye a una persona con todos sus atributos más una lista de sus habilidades.
public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    //constructor
    public Curriculum(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }

    //getters y setters


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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    //Agregar habilidad
    public  void agregarhabilidad(String habilidad){
        this.habilidades.add(habilidad);
    }

    //Implementar metodo imprimir
    @Override
    public void imprimir(){
        imprimirTipoDoc();
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        System.out.print("Habilidades: ");
        for(String habilidad: habilidades) {
            System.out.println(habilidad +", ");
        }
    }
}
