package src.clases;

import java.util.ArrayList;

public class Curriculum extends Documento{

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    /*Para cada Clase se va a redefinir el método imprimir existente en la clase abstracta Documento, dependiendo
     de los atributos que necesitemos */
    @Override
    public void imprimir() {
        imprimirTipoDoc(); // Utiliza este metodo ya que la clase Curriculum extiende de Documento
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        for (String habilidad: habilidades) {
            System.out.println("Habilidad: " + habilidad);
        }

    }
}
