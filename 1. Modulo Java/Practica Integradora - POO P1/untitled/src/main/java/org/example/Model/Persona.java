package org.example.Model;

//Ejercicio 1
public class Persona {

    /*
     Crea una clase Persona, la cual tendrá los siguientes atributos:
     nombre, edad, dni (en este caso vamos a representarlo como una cadena de caracteres),
     peso y altura.*/

    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    //Ejercicio 2
    public Persona() {
    }

    public Persona(String name,int age, String dni) {
        this.name = name;
        this.age = age;
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

    //Ejercicio 5
    public int calcularIMC() {
        if (height <= 0) { throw new IllegalArgumentException("La altura debe ser mayor a 0."); }
        if (weight <= 0) { throw new IllegalArgumentException("El peso debe ser mayor a 0."); }

        double imc = weight / Math.pow(height, 2);

        if (imc < 20) return -1;
        if (imc >= 20 && imc <= 25) return 0;

        return 1;
    }

    public boolean esMayorDeEdad() { return age >= 18; }

}
