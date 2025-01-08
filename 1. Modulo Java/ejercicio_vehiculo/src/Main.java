import com.bootcamp.Garaje;
import com.bootcamp.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        Garaje garaje = new Garaje(1, vehiculos);

        garaje.getVehiculos().add(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.getVehiculos().add(new Vehiculo("Focus", "Ford", 1200));
        garaje.getVehiculos().add(new Vehiculo("Explorer", "Ford", 2500));
        garaje.getVehiculos().add(new Vehiculo("Uno", "Fiat", 500));
        garaje.getVehiculos().add(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.getVehiculos().add(new Vehiculo("Torino", "Fiat", 1250));
        garaje.getVehiculos().add(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.getVehiculos().add(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.getVehiculos().add(new Vehiculo("Corola", "Toyota", 1200));
        garaje.getVehiculos().add(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.getVehiculos().add(new Vehiculo("Logan", "Renault", 950));

        System.out.println("Vehiculos en el garaje: ");

        // Lista ordernada por precio
        vehiculos.sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));

        // Ordenada por marca y precio
        vehiculos.sort((v1, v2) -> {
            int precio = Double.compare(v1.getCosto(), v2.getCosto());
            int marca = v1.getMarca().compareTo(v2.getMarca());
            return marca != 0 ? marca : precio;
        });

        // filtrar
        System.out.println("Vehiculos menores a 1000$");
        List<Vehiculo> vehiculosMenorA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
        vehiculosMenorA1000.forEach(vehiculo -> System.out.println(vehiculo));

        System.out.println("Vehiculos mayores a 1000$");
        List<Vehiculo> vehiculosMayoresA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        vehiculosMayoresA1000.forEach(vehiculo -> System.out.println(vehiculo));

        Double promedioCosto = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
        System.out.println(promedioCosto);
    }
}
