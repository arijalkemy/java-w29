import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {

    private int id;
    private List<Vehiculo> vehiculos;


    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculosSortedByCosto() {
        return vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosSortedByMarcaYCosto() {
        return vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosConCostoMaximo(int costoMaximo) {
        return vehiculos.stream()
                .filter(v -> v.getCosto() < costoMaximo)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosConCostoMinimo(int costoMinimo) {
        return vehiculos.stream()
                .filter(v -> v.getCosto() >= costoMinimo)
                .collect(Collectors.toList());
    }

    public double getPromedioCostos() {
        try {
            double total = vehiculos.stream().mapToDouble(Vehiculo::getCosto).sum();
            return total / vehiculos.size();
        } catch (ArithmeticException e) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
    }
}
