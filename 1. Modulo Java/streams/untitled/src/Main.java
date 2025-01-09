import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        // Print the details of the garage and its vehicles
        System.out.println("Garaje ID: " + garaje.getId());
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() + ", Costo: " + vehiculo.getCosto());
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Vehiculos ordenados por costo:");
        garaje.getVehiculos().stream()
                .toList()
                .stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("Vehiculos ordenados por precio y marca:");
        garaje.getVehiculos().stream()
                .toList()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("Vehiculos menores a 1000");
        garaje.getVehiculos().stream()
                .toList()
                .stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("Vehiculos mayores o iguales a 1000");
        garaje.getVehiculos().stream()
                .toList()
                .stream().filter(v->v.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println("Pormedio de precios");
        double promedio = garaje.getVehiculos().stream()
                .toList()
                .stream().find
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
        System.out.println("El promedio es: "+ promedio);
    }
}