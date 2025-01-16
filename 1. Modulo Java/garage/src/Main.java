import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = Arrays.asList(
            new Vehicle("Ford", "Fiesta", 1000.0),
            new Vehicle("Ford", "Focus", 1200.0),
            new Vehicle("Ford", "Explorer", 2500.0),
            new Vehicle("Fiat", "Uno", 500.0),
            new Vehicle("Fiat", "Cronos", 1000.0),
            new Vehicle("Fiat", "Torino", 1250.0),
            new Vehicle("Chevrolet", "Aveo", 1250.0),
            new Vehicle("Chevrolet", "Spin", 2500.0),
            new Vehicle("Toyota", "Corola", 1200.0),
            new Vehicle("Toyota", "Fortuner", 3000.0),
            new Vehicle("Renault", "Logan", 950.0)
        );

        Garage garage = new Garage(1, vehicles);

        System.out.println("Sorted by price:");
        // vehicles.sort((v1, v2) -> Double.compare(v1.getPrice(), v2.getPrice()));
        vehicles.sort(Comparator.comparingDouble(Vehicle::getPrice));
        vehicles.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Sorted by price and brand:");

        vehicles.stream()
            .sorted(Comparator.comparing(Vehicle::getPrice))
            .sorted(Comparator.comparing(Vehicle::getBrand))
            .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Price less or equal than 1000:");

        vehicles
            .stream()
            .filter(v -> v.getPrice() <= 1000)
            .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Price greater or equal than 1000:");

        vehicles
            .stream()
            .filter(v -> v.getPrice() >= 1000)
            .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Average price:");

        System.out.println(
            "Average: " +
            vehicles
                .stream()
                .mapToDouble(Vehicle::getPrice)
                .average()
                .getAsDouble() +
            "."
        );
    }
}