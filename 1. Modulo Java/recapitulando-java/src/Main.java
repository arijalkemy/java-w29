import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000.0);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200.0);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500.0);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500.0);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000.0);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250.0);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250.0);

        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(vehiculo1);
        vehiculoList.add(vehiculo2);
        vehiculoList.add(vehiculo3);
        vehiculoList.add(vehiculo4);
        vehiculoList.add(vehiculo5);
        vehiculoList.add(vehiculo6);
        vehiculoList.add(vehiculo7);

        Garaje garaje = new Garaje("G-01", vehiculoList);

        //Ejercicio 3
        System.out.println("Ordenar por precio de menor a mayor");
        System.out.println("Marca   Modelo    Costo");
        garaje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 4
        System.out.println("Ordenar por marca y precio");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 5
        System.out.println("\nVehiculos con costo mayor a 1000");
        System.out.println("\nMarca   Modelo    Costo");
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() > 1000).forEach(System.out::print);

        System.out.println("\nVehiculos con costo menor o igual a 1000");
        System.out.println("\nMarca   Modelo    Costo");
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::print);

        System.out.println("\nPromedio de costo de los vehiculos");
        double promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.printf("%.2f%n", promedio);
    }
}