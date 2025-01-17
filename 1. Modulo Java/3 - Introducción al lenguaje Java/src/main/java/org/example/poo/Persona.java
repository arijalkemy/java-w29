package org.example.poo;

public class Persona {

    //Ejercicio 1
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //Ejercicio 2
    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
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

    //Ejercicio 5.1
    public int cacularIMC(){

        double imc = this.peso / (Math.pow(this.altura, 2));

        return imc < 20 ? -1 : (imc >= 20 && imc <= 25) ? 0 : 1;
    }

    //Ejercicio 5.2
    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    //Ejercicio 5.3
    @Override
    public String toString() {
        return "Persona { " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                " }";
    }
}
