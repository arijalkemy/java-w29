package com.thiagoschreck.local;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private double altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int calcularIMC() {
        if (altura < 1) {
            return -1;
        }
        final double imc = peso/Math.pow(altura, 2);
        System.out.println("imc " + imc);
        if (imc < 20) {
            return -1;
        }
        if (imc <= 25) {
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                Edad: %s
                DNI: %s
                Peso: %s
                Altura: %s
                """, nombre, edad, dni, peso, altura);
    }
}
