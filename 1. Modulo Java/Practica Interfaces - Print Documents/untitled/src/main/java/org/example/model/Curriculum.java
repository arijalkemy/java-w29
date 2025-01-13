package org.example.model;

import java.util.List;

public class Curriculum implements  Documents{

        private String nombre;
        private String apellido;
        private int edad;
        private List<String> habilidades;

        public Curriculum(String nombre, String apellido, int edad, List<String> habilidades) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.habilidades = habilidades;
        }

        @Override
        public String contentToPrint() {
            return "Curriculum de " + nombre + " " + apellido + " (Edad: " + edad + " años)\nHabilidades: " + String.join(", ", habilidades);
        }

}
