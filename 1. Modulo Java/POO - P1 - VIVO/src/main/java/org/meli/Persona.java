package org.meli;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {

    }

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
        double IMC = peso / (Math.pow(altura, 2)) - altura - peso;

        if (IMC < 20)
            return -1;
        else if (IMC >= 20 && IMC <= 30)
            return 0;
        else
            return 1;

    }

    public double mostrarCalculo() {
        return peso / (Math.pow(altura, 2));
    }

    public String IMCSalud() {
        if (calcularIMC() == -1)
            return "Bajo peso";
        else if (calcularIMC() == 0)
            return "Peso saludable";
        else
            return "Sobrepeso";
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String esMayor() {
        String esMayor;
        if (esMayorDeEdad())
            esMayor = "SI";
        else
            esMayor = "NO";

        return esMayor;
    }

    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | DNI: " + dni +
                " | Peso: " + peso + " | Altura: " + altura;
    }
}
