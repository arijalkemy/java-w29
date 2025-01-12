package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("David",24,"1.193.525.542");
        Persona persona3 = new Persona("Gabriela",24,"1.007.698.591", 52.0, 1.65);
        Persona persona4 = new Persona("juan",24,"1.787.698.591", 64.0, 1.70);
        Persona persona5 = new Persona("art",24,"1.007.698.591", 93.0, 1.77);


        System.out.println("El nivel de peso de " + persona3.getNombre() + " es " + persona3.nivelDePeso() + " y es: " + (persona3.esMayorDeEdad() ? "mayor de edad" : "menor de edad"));
        System.out.println("El nivel de peso de " + persona4.getNombre() + " es " + persona4.nivelDePeso() + " y es: " + (persona4.esMayorDeEdad() ? "mayor de edad" : "menor de edad"));
        System.out.println("El nivel de peso de " + persona5.getNombre() + " es " + persona5.nivelDePeso() + " y es: " + (persona5.esMayorDeEdad() ? "mayor de edad" : "menor de edad"));

    }
}