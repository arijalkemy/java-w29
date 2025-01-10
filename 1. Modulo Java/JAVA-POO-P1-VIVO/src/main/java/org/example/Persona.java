package org.example;

public class Persona {

    private String nombre, dni;
    private int edad;
    private Double altura, peso;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, Double altura, Double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
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

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", dni='" + dni + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }


    public int calcularIMC() {
        if (altura <= 0) {
            throw new IllegalArgumentException("altura tiene que ser mayor que 0");

        }
        if (peso <= 0) {
            throw new IllegalArgumentException("peso tiene que ser mayor que 0");
        }

        double imc = peso / Math.pow(altura, 2);

        if (imc < 20) {return -1;}
        if (imc >= 20 && imc <=25) {return 0;}

        return 1;

    }
    public boolean mayorEdad(){
        return edad >= 18;
    }
}
