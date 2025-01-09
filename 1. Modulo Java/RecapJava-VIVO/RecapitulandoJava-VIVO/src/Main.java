import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        garaje.getListaVehiculos().add(new Vehiculo("Ford","Fiesta", 1000.));
        garaje.getListaVehiculos().add(new Vehiculo("Ford","Focus", 1200.));
        garaje.getListaVehiculos().add(new Vehiculo("Ford","Explorer", 2500.));
        garaje.getListaVehiculos().add(new Vehiculo("Fiat","Uno", 500.));
        garaje.getListaVehiculos().add(new Vehiculo("Fiat","Cronos", 1000.));
        garaje.getListaVehiculos().add(new Vehiculo("Fiat","Torino", 1250.));
        garaje.getListaVehiculos().add(new Vehiculo("Chevrolet","Aveo", 1250.));
        garaje.getListaVehiculos().add(new Vehiculo("Chevrolet","Spin", 2500.));
        garaje.getListaVehiculos().add(new Vehiculo("Toyota","Corola", 1200.));
        garaje.getListaVehiculos().add(new Vehiculo("Toyota","Fortuner", 3000.));
        garaje.getListaVehiculos().add(new Vehiculo("Renault","Logan", 900.));

        System.out.println("Vehiculos ordenados por precio de menor a mayor");
        garaje.getListaVehiculos()
                .stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println("Lista ordenada por marca y a su vez por precio");
        garaje.getListaVehiculos()
                .stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("-----------------");
        System.out.println("Lista de vehiculos con precio no mayor a 1000");
        List<Vehiculo> precioNoMayorAMil= garaje.getListaVehiculos()
                .stream().filter(v -> v.getCosto() < 1000).toList();
        precioNoMayorAMil.forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println("Lista de vehiculos con precios mayor o igual 1000");
        List<Vehiculo> precioIgualOMayorAMil = garaje.getListaVehiculos()
                .stream().filter(v -> v.getCosto() >= 1000).toList();
        precioIgualOMayorAMil.forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println("Promedio total de precios de toda la lista de vehiculos");
        Double promedio = garaje.getListaVehiculos()
                .stream().mapToDouble(Vehiculo::getCosto)
                .average().orElse(0.0);
        System.out.println(promedio);

    }
}
