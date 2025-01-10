package org.example.clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Luego crea una clase garaje con los atributos id o identificador único y una lista de vehículos.
// Crea además los constructores de las clases y los métodos Setter y Getter.
public class Garaje {
    private Integer id;
    private List<Auto> autos;

    //constructor
    public Garaje(Integer id) {
        this.id = id;
        this.autos = new ArrayList<>();
    }

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    // Método para agregar un vehículo al garaje
    public void agregarVehiculo(Auto vehiculo) {
        autos.add(vehiculo);
    }



}
