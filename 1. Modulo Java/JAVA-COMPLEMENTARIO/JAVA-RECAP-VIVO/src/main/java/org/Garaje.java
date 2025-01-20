package org;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    int id;
    List<Vehiculo> listadoVehiculos;

    public Garaje(int id, List listadoVehiculos) {
        this.id = id;
        this.listadoVehiculos = listadoVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListadoVehiculos() {
        return listadoVehiculos;
    }

    public void setListadoVehiculos(List listadoVehiculos) {
        this.listadoVehiculos = listadoVehiculos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", listadoVehiculos=" + getListadoVehiculos() +
                '}';
    }

}
