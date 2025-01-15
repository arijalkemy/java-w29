package org;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Categoria {
    private String id;
    private String nombre;
    private String descripcion;
    private List<Inscripcion> inscripciones;

    public Categoria(String id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscripciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void inscribir(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public void desinscribir(int numeroInscripcion) {
        inscripciones.removeIf(inscripcion -> inscripcion.getNumeroInscripcion() == numeroInscripcion);
    }

    public int calcularRecaudacionTotal() {
        return inscripciones.stream().mapToInt(Inscripcion::getMonto).sum();
    }
}