import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1);

        garage.agregarVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garage.agregarVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garage.agregarVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garage.agregarVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garage.agregarVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garage.agregarVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garage.agregarVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garage.agregarVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garage.agregarVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garage.agregarVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garage.agregarVehiculo(new Vehiculo("Logan", "Renault", 950));

        System.out.println("Vehículos ordenados por precio (menor a mayor):");
        List<Vehiculo> vehiculosOrdenadosPorPrecio = garage.getVehiculos()
                .stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .toList();

        vehiculosOrdenadosPorPrecio.forEach(System.out::println);

        System.out.println("\nVehículos ordenados por marca y precio:");
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = garage.getVehiculos()
                .stream()
                .sorted((v1, v2) -> {
                    int marcaCompare = v1.getMarca().compareTo(v2.getMarca());
                    if (marcaCompare == 0) {
                        return Double.compare(v1.getCosto(), v2.getCosto());
                    }
                    return marcaCompare;
                })
                .toList();

        vehiculosOrdenadosPorMarcaYPrecio.forEach(System.out::println);

        List<Vehiculo> vehiculosMenoresA1000 = garage.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() < 1000)
                .toList();

        List<Vehiculo> vehiculosMayoresOIgualesA1000 = garage.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();

        double promedioPrecio = garage.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("\nVehículos con precio no mayor a 1000:");
        vehiculosMenoresA1000.forEach(System.out::println);

        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        vehiculosMayoresOIgualesA1000.forEach(System.out::println);

        System.out.println("\nPromedio total de precios: " + promedioPrecio);
    }
}