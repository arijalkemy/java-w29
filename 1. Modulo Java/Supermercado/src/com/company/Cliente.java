package com.company;

public class Cliente implements ICrud {
    private Integer dni;
    private String nombre;
    private String apellido;

    public Cliente() {
    }

    public Cliente(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString(){
        return ("Cliente: "+ this.nombre+" "+this.apellido + " | DNI: "+dni);
    }

    @Override
    public Object altaProducto(Object producto) {
        System.out.println("Se dio de alta el cliente: "+producto.toString());
        return producto;
    }

    @Override
    public Object bajaProducto(Object producto) {
        System.out.println("Se dio de baja el cliente: "+producto.toString());
        return producto;
    }

    @Override
    public Object modificacionProducto(Object producto) {
        System.out.println("Se modifico el cliente: "+producto.toString());
        return producto;
    }
}
