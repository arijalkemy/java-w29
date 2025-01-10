package org.example.clases;
 //De cada cliente se registran: dni, nombre y apellido.
public class Cliente {
     private Integer id;
    private String nombre;
    private String apellido;
    private String dni;

    //Constructor
     public Cliente() {
     }

     public Cliente(Integer id , String nombre, String apellido, String dni) {
         this.id = id;
         this.nombre = nombre;
         this.apellido = apellido;
         this.dni = dni;
     }

     //Getter y Setter

     public String getDni() {
         return dni;
     }

     public void setDni(String dni) {
         this.dni = dni;
     }

     public String getApellido() {
         return apellido;
     }

     public void setApellido(String apellido) {
         this.apellido = apellido;
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     //to string

     @Override
     public String toString() {
         return "Cliente[" +
                 "nombre='" + nombre + '\'' +
                 ", apellido='" + apellido + '\'' +
                 ", dni='" + dni + '\'' +
                 ']';
     }
 }
