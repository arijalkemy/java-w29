import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1);

        garage.agregarVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garage.agregarVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garage.agregarVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garage.agregarVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garage.agregarVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garage.agregarVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garage.agregarVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garage.agregarVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garage.agregarVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garage.agregarVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garage.agregarVehiculo(new Vehiculo("Logan", "Renault", 950));

        //System.out.println(garage.toString());

        garage.getVehiculos().sort((v1, v2) -> {
                int compMarca = v1.getMarca().compareTo(v2.getMarca());

                if (compMarca == 0) {
                    return Double.compare(v1.getCosto(), v2.getCosto());
                } else {
                    return compMarca;
                }
        });

        for (Vehiculo vehiculo : garage.getVehiculos()){
            System.out.println(vehiculo.toString());
        }

        List<Vehiculo> vehiculosBajos = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() < 1000)
                .collect(Collectors.toList());

        List<Vehiculo> vehiculosAltos = garage.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList());

        double promedio = garage.getVehiculos().stream()
                .collect(Collectors.averagingDouble(Vehiculo::getCosto));

        System.out.println("Vehículos con precio no mayor a 1000:");
        vehiculosBajos.forEach(Vehiculo::toString);

        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        vehiculosAltos.forEach(Vehiculo::toString);

        System.out.println("\nPromedio total de precios de todos los vehículos: $" + promedio);

    }
}
