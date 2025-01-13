import java.util.List;

public class Garage {
    private int id;
    private List<Vehicul> vehiculos;

    public Garage(int id, List<Vehicul> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public double getPromedioCosto() {
        return vehiculos.stream().mapToDouble(Vehicul::getCosto).sum() / vehiculos.size();
    }

    public void mostrarVehiculos() {
        vehiculos.forEach(System.out::println);
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicul> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehicul> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
