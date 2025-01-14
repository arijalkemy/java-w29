import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1, Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        System.out.println("Vehículos ordenados por costo:");
        garaje.getVehiculosSortedByCosto().forEach(System.out::println);

        System.out.println("\nVehículos ordenados por marca y costo:");
        garaje.getVehiculosSortedByMarcaYCosto().forEach(System.out::println);

        System.out.println("\nVehículos con costo menor o igual a 1000:");
        garaje.getVehiculosConCostoMaximo(1000).forEach(System.out::println);

        System.out.println("\nVehículos con costo mayor o igual a 1000:");
        garaje.getVehiculosConCostoMinimo(1000).forEach(System.out::println);

        System.out.println("\nPromedio total del costo: " + garaje.getPromedioCostos());
    }
}