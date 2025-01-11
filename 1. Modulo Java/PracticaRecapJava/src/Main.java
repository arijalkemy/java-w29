import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje("1", Arrays.asList(
                new Vehiculo("Fiesta", "Ford", 1000),
                new Vehiculo("Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat", 500),
                new Vehiculo("Cronos", "Fiat", 1000),
                new Vehiculo("Torino", "Fiat", 1250),
                new Vehiculo("Aveo", "Chevrolet",1250),
                new Vehiculo("Spin", "Chevrolet", 2500),
                new Vehiculo("Corola", "Toyota", 1200),
                new Vehiculo("Fortuner", "Toyota", 30000),
                new Vehiculo("Logan", "Renault", 950)
        ));

        List<Vehiculo> vehiculos =  garaje.getVehiculos();

        System.out.println("\n----Por precio----");
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n----Por marca y precio----");
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n----No mayor a 1000----");
        vehiculos.stream().filter(v -> v.getCosto()<=1000).forEach(System.out::println);

        System.out.println("\n----Mayor o igual a 1000----");
        vehiculos.stream().filter(v -> v.getCosto()>=1000).forEach(System.out::println);

        System.out.println("\n----Promedio----");
        System.out.println(vehiculos.stream().mapToDouble(v->v.getCosto()).average().getAsDouble());
    }
}