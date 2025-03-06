import java.util.List;

public class Garage {
    private String id;
    private List<Vehicle> vehicles;

    public Garage(String id, List<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
