import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculosGaraje = Stream.of(
                new Vehiculo("Fiesta", "Ford", 1000.0),
                new Vehiculo("Focus", "Ford", 1200.0),
                new Vehiculo("Explorer", "Ford", 2500.0),
                new Vehiculo("Uno", "Fiat", 500.0),
                new Vehiculo("Cronos", "Fiat", 1000.0),
                new Vehiculo("Torino", "Fiat", 1250.0),
                new Vehiculo("Aveo", "Chevrolet", 1250.0),
                new Vehiculo("Spin", "Chevrolet", 2500.0),
                new Vehiculo("Corola", "Toyota", 1200.0),
                new Vehiculo("Fortuner", "Toyota", 3000.0),
                new Vehiculo("Logan", "Renault", 950.0)
        ).collect(Collectors.toList());

        Garaje garaje = new Garaje("G-01",vehiculosGaraje);


        //Ejercicio 3
        System.out.println("\nLista ordenada por precio de menor a mayor:");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getPrecio));
        System.out.println(garaje.getVehiculos());


        //Ejercicio 4
        System.out.println("\nLista ordenada por marca y precio:");
        garaje.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getPrecio));
        System.out.println(garaje.getVehiculos());


        //Ejercicio 5
        System.out.print("\nVehiculos con precio menor a 1000:");
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getPrecio() < 1000).forEach(System.out::print);

        System.out.print("\n\nVehiculos con precio mayor o igual a 1000:");
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getPrecio() >= 1000).forEach(System.out::print);

        System.out.println("\n\nPromedio:");
        double promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getPrecio).average().getAsDouble();
        System.out.println(promedio);
        
    }
}