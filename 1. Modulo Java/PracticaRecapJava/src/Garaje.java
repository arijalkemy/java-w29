import java.util.List;

public class Garaje {
    private String uid;
    private List<Vehiculo> vehiculos;
    public Garaje(String uid, List<Vehiculo> vehiculos) {
        this.uid = uid;
        this.vehiculos = vehiculos;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
