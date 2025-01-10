package org.example.clases;

//Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje con
// los atributos id o identificador único y una lista de vehículos. Crea además los constructores de las
// clases y los métodos Setter y Getter.
public class Auto {
    private String modelo;
    private String marca;
    private Double precio;

    //constructor

    public Auto(String modelo, String marca, Double precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    //getters y setters

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Auto [modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + "]";
    }
}
