package EjerciciosRepaso;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehicles;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Vehiculo> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehiculo> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehiculo vehicle) {
        vehicles.add(vehicle);
    }

    public void ordenarVehiculosPorPrecio() {
        vehicles.sort((v1, v2) -> Integer.compare(v2.getCosto(), v1.getCosto()));
    }

    public void ordenarVehiculosPorMarcaYPrecio() {
        vehicles.sort((v1, v2) -> {
            int marcaComparison = v1.getMarca().compareTo(v2.getMarca());
            if (marcaComparison != 0) {
                return marcaComparison;
            } else {
                return Integer.compare(v2.getCosto(), v1.getCosto());
            }
        });
    }

    public void obtenerVehiculosPorRangoDePrecio(int menoraPrecio, int mayoraPrecio) {
        for (Vehiculo vehicle : vehicles) {
            if (vehicle.getCosto() > menoraPrecio && vehicle.getCosto() <= mayoraPrecio) {
                System.out.println(vehicle.toString());
            }
        }
    }

    public double calcularCostoPromedio() {
        return vehicles.stream().mapToInt(Vehiculo::getCosto).sum()/vehicles.size();
    }

    public Garaje(int id, List<Vehiculo> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }
    public Garaje(int id) {
        this.id = id;
        this.vehicles = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Garaje ID: ").append(id).append("\n");
        sb.append("Vehículos en el garaje:\n");
        for (Vehiculo vehicle : vehicles) {
            sb.append(vehicle.toString()).append("\n");
        }
        return sb.toString();
    }
    
}
