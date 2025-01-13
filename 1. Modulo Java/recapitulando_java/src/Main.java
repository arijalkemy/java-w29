import domain.Garaje;
import domain.Vehiculo;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        garaje.getVehiculos().add(
                new Vehiculo("Fiesta", "Ford", 1000)
        );
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
        garaje.getVehiculos()
                .stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("--------------");
        garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("-------------");
        List<Vehiculo> precioNoMayorAMil = garaje.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() < 1000)
                .toList();
        precioNoMayorAMil.forEach(System.out::println);
        System.out.println("-----------");
        List<Vehiculo> precioMayorIgualAMil = garaje.getVehiculos()
                .stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();
        precioMayorIgualAMil.forEach(System.out::println);

        Double prom = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average().orElse(0.0);
        System.out.println(prom);

    }
}