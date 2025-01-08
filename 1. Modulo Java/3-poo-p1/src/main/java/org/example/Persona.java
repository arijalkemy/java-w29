package org.example;

public class Persona {
    // Ejercicio 1
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    // Ejercicio 2
    public Persona() {}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // Ejercicio 5
    public int calcularIMC(){
        double calculo = this.peso / Math.pow(this.altura,2);
        if(calculo < 20){
            return -1;
        } else if(calculo >= 20 && calculo <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
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
