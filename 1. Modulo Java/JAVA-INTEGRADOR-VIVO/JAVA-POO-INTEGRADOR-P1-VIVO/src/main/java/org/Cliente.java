package org;

// Clase Cliente
class Cliente {
    private String id;
    private String nombre;

    public Cliente(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}
