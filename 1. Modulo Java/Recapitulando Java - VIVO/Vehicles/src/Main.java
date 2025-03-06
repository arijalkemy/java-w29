import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create vehicles
        List<Vehicle> vehicles = List.of(
            new Vehicle("Ford", "Fiesta", 1000),
            new Vehicle("Ford", "Focus", 1200),
            new Vehicle("Ford", "Explorer", 2500),
            new Vehicle("Fiat", "Uno", 500),
            new Vehicle("Fiat", "Cronos", 1000),
            new Vehicle("Fiat", "Torino", 1250),
            new Vehicle("Chevrolet", "Aveo", 1250),
            new Vehicle("Chevrolet", "Spin", 2500),
            new Vehicle("Toyota", "Corola", 1200),
            new Vehicle("Toyota", "Fortuner", 3000),
            new Vehicle("Renault", "Logan", 950)
        );

        Garage garage = new Garage("G1", vehicles);

        // Print vehicles sorting by price
        garage
                .getVehicles()
                .stream()
                .sorted((v1, v2) -> (int) (v1.getPrice() - v2.getPrice()))
                .forEach(System.out::println);

        // Print vehicles sorting by price and model
        garage
                .getVehicles()
                .stream()
                .sorted((v1, v2) -> (int) (v2.getPrice() - v1.getPrice()))
                .sorted((v1, v2) -> v1.getBrand().compareToIgnoreCase(v2.getBrand()))
                .forEach(System.out::println);

        // Print vehicles whose price is not greater than 1000
        garage
                .getVehicles()
                .stream()
                .filter(v -> v.getPrice() < 1000)
                .forEach(System.out::println);

        // Print vehicles whose price is equal or greater than 1000
        garage
                .getVehicles()
                .stream()
                .filter(v -> v.getPrice() >= 1000)
                .forEach(System.out::println);

        // Average price of vehicles
        garage
                .getVehicles()
                .stream()
                .map(Vehicle::getPrice)
                .reduce(Double::sum)
                .map(total -> total / vehicles.size())
                .ifPresent(System.out::println);
    }
}