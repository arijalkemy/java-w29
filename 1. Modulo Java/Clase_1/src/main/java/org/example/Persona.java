package org.example.clases1;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private Double peso;
    private Double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public int calcularIMC() {
        if (peso != null && altura != null) {
            double imc = peso / Math.pow(altura, 2); // altura en metros
            if (imc < 20) {
                return -1;  // Bajo peso
            } else if (imc >= 20 && imc <= 25) {
                return 0;   // Peso saludable
            } else {
                return 1;   // Sobrepeso
            }
        }
        return 0; // Retornar 0 si no se puede calcular
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", DNI: " + dni + ", Peso: " + peso + "kg, Altura: " + altura + "m";
    }
}
