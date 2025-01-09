package entity;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    // Constructor sin parámetros
    public Persona() {
    }

    // Constructor con nombre, edad y dni
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // Constructor con todos los atributos
    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso / (Math.pow(altura, 2));
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona\n" +
                "nombre='" + nombre +
                "\nedad=" + edad +
                "\ndni='" + dni +
                "\npeso=" + peso +
                "\naltura=" + altura +
                '\n';
    }

}