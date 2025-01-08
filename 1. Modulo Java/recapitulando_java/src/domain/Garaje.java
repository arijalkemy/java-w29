package domain;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private static int id = 0;
    List<Vehiculo> vehiculos;

    public Garaje() {
        Garaje.id += 1;
        this.vehiculos = new ArrayList<>();
    }

    public int getId() {
        return Garaje.id;
    }

    public void setId(int id) {
        Garaje.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
