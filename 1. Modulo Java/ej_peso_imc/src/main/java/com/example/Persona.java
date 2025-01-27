package com.example;

public class Persona {
    private String nombre;

    private int edad;

    private String dni;

    private double peso;

    private double altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double calculo = peso / (Math.pow(altura, 2));

        return calculo < 20 ? -1 : calculo <= 25 ? 0 : 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String getNombre() {
        return nombre;
    }
}
