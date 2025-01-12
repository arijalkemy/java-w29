package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;


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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String nivelDePeso(){
        if(calcularIMC() == -1){
            return "bajo";
        }
        else if(calcularIMC() == 0){
            return "saludable";
        }
        else if(calcularIMC() == 1){
            return "sobrepeso";
        }
        return "peso";
    }

    public int calcularIMC(){

        double imc = (peso/(Math.pow(altura,2)));
        if(imc<20){
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        }
        else if (imc > 25) {
            return 1;
        }
        return 33;
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

    public boolean esMayorDeEdad(){
        if(edad >= 18){
            return true;
        }
        return false;
    }


    public Persona( ){
    }
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
}
