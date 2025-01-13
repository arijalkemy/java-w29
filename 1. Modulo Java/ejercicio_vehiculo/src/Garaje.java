import java.util.*;

public class Garaje {
    private Integer id;
    private List<Vehiculo> vehiculos;

    public Garaje(Integer id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
