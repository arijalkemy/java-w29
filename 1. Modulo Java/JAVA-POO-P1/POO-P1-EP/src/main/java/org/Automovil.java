package org;

public class Automovil {
    String marca;
    String color;
    double kilometros;

    // Constructor por defecto
    public Automovil() {
    }

    // Constructor con parámetros
    public Automovil(String marca, String color, double kilometros) {
        this.marca = marca;
        this.color = color;
        this.kilometros = kilometros;
    }

    // Método para mostrar la marca y el color
    public String mostrarMarcaYColor() {
        return "La marca del auto es: " + this.marca + ". El color del auto es: " + this.color;
    }

    public static void main(String[] args) {
        Automovil automovil = new Automovil("Nissan", "Gris", 200);
        System.out.println(automovil.mostrarMarcaYColor());
    }
}
