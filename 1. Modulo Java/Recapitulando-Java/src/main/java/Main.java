import domain.Garage;
import domain.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));


        Garage garage = new Garage(1, vehiculos);

        //Ejercicio 3
        List<Vehiculo> vehiculosOrdenadosPrecio = garage.getVehiculos().stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .toList();
        System.out.println("==== Ordenados por precio ====");
        vehiculosOrdenadosPrecio.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        //Ejercicio 4
        List<Vehiculo> vehiculoOrdenadosPorMarcaYPrecio = vehiculosOrdenadosPrecio;
        System.out.println("==== Ordenados por marca y precio ====");
        vehiculoOrdenadosPorMarcaYPrecio.stream()
                .sorted((v1, v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .toList().forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        //Ejercicio 5

        List<Vehiculo> vehiculosPrecioMenorMil = garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .toList();
        List<Vehiculo> vehiculosPrecioMayorMil = garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        System.out.println("==== Vehiculos: Precio Menor Mil ====");
        vehiculosPrecioMenorMil.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        System.out.println("==== Vehiculos: Precio Mayor/igual Mil ====");
        vehiculosPrecioMayorMil.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        System.out.println("Promedio de precio de vehiculos : ");

        Double promedio = garage.getVehiculos().stream()
                .map(Vehiculo::getCosto)
                .reduce(Double::sum).orElse(0.0) / garage.getVehiculos().size();
        System.out.println(promedio);
    }
}

