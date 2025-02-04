package ejercicio_2;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private int edad;
    List<String> habilidades;

    public Curriculum(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Habilidades: " + habilidades);
    }
}
