import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1, new ArrayList<>());

        garaje.getVehiculos().add(new Vehiculo("Ford", "Fiesta", 1000.0));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Focus", 1200.0));
        garaje.getVehiculos().add(new Vehiculo("Ford", "Explorer", 2500.0));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Uno", 500.0));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Cronos", 1000.0));
        garaje.getVehiculos().add(new Vehiculo("Fiat", "Torino", 1250.0));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        garaje.getVehiculos().add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Corola", 1200.0));
        garaje.getVehiculos().add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        garaje.getVehiculos().add(new Vehiculo("Renault", "Logan", 950.0));

        // Ejercicio 3
        System.out.println("======Ejercicio 3======");
        System.out.println("Vehiculos oredenados por precio: ");
        // Alternativa
        // garaje.getVehiculos().sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));
        // System.out.println(garaje.getVehiculos());
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .toList()
                .forEach(System.out::println);

        // Ejercicio 4
        // Alternativa
//        System.out.println("Ejercicio 4");
//        List<Vehiculo> vehiculos = garaje.getVehiculos().stream()
//                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
//                .sorted(Comparator.comparing(Vehiculo::getMarca))
//                .toList();
//        vehiculos.forEach(System.out::println);

        System.out.println("======Ejercicio 4======");
        List<Vehiculo> vehiculos = garaje.getVehiculos().stream()
                //.sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .sorted(Comparator
                        .comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto))
                .toList();
        vehiculos.forEach(System.out::println);

        // Ejercicio 5
        System.out.println("======Ejercicio 5======");
        List<Vehiculo> vehiculosMenor1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();
        System.out.println(vehiculosMenor1000);

        List<Vehiculo> vehiculosMayor1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();
        System.out.println(vehiculosMayor1000);

        Double promedio = garaje.getVehiculos().stream()
                .collect(Collectors.averagingDouble(Vehiculo::getCosto));
        System.out.println(promedio);
    }
}
