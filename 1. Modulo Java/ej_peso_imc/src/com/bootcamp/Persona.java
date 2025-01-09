package com.bootcamp;

public class Persona {
    private String nombre;
    private Integer edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){

    }

    public Persona(String nombre, Integer edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Integer calcularIMC(){
        double imc = this.peso / (Math.pow(this.altura, 2));
        if(imc < 20)
            return -1;

        if(imc >= 20 && imc <= 25)
            return 0;

        return 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18 ? true : false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
