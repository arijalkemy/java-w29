import java.util.List;

public class Garage {
    private Integer id;
    private List<Vehicle> vehicles;

    public Garage(Integer id, List<Vehicle> vehiculos) {
        this.id = id;
        this.vehicles = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
