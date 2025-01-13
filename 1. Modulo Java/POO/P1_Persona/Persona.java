package com.example.demo.POO.P1_Persona;


import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

public class Persona {
    /*
     Crea una clase Persona, la cual tendrá los siguientes atributos:
     nombre, edad, dni (en este caso vamos a representarlo como una cadena de caracteres),
     peso y altura ¿Qué tipo de dato le asignarías a las variables de instancia?
     ¿Cómo sería la estructura básica de tu clase?
    */
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;
    public Persona() {
    }

    public Persona(String name,int age, String dni) {
        this.age = age;
        this.name = name;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, double height, double weight) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.height = height;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName(){ return this.name; }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    // Método calcularIMC
    public int calcularIMC() {
        if (height <= 0) { throw new IllegalArgumentException("La altura debe ser mayor a 0."); }
        if (weight <= 0) { throw new IllegalArgumentException("El peso debe ser mayor a 0."); }

        double imc = weight / Math.pow(height, 2);

        if (imc < 20) return -1;
        if (imc >= 20 && imc <= 25) return 0;

        return 1;
    }

    public boolean esMayorDeEdad() { return age >= 18; }

    /* Ejercicio 4

    A continuación vamos a crear otro objeto de tipo persona y vamos a
    construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor.
    ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?

    */

    public static class PersonaBuilder{
        private String name;
        private int age;
        private String dni;
        double weight;
        double height;

        public PersonaBuilder(){}
        public PersonaBuilder setAge(int age){
            this.age = age;
            return this;
        }
        public PersonaBuilder setName(String name){
            this.name = name;
            return this;
        }
        public PersonaBuilder setDni(String dni){
            this.dni = dni;
            return this;
        }
        public PersonaBuilder setWeight(double weight){
            this.weight = weight;
            return this;
        }
        public PersonaBuilder setHeight(double height){
            this.height = height;
            return this;
        }
        public Persona build(){
            return new Persona(name, age, dni, height, weight);
        }
    }
}



