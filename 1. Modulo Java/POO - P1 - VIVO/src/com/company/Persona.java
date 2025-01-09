package com.company;

public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    private double peso;
    private double altura;

    public Persona(){
    }
    public Persona(String nombre, int edad, int dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, int dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int getIMC(){
        double imc = peso / (altura * altura);
        if (imc < 20){
            return -1;
        }
        else if(imc <= 20 && imc <= 25){
            return 0;
        }
        return 1;
    }
    public boolean esMayorDeEdad(){
        return (edad >= 18);
    }
    @Override
    public String toString(){
        return "Nombre: " + nombre + " | Edad: "+ edad + " | DNI: " + dni + " | Peso: " + peso +"kg"+ " | Altura: " + altura +"m";
    }
}
