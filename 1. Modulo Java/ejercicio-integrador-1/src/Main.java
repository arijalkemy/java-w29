import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1, List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        )
        );

        System.out.println("-------Ordeno por precio------");

        List<Vehiculo> vehiculosOrdenados = garaje
                .getVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio)).toList();

        for(Vehiculo v : vehiculosOrdenados){
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println("-------Ordeno por marcas------");

        List<Vehiculo> vehiculosOrdenadosPorMarcaPrecio = vehiculosOrdenados
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .toList();

        for(Vehiculo v : vehiculosOrdenadosPorMarcaPrecio){
            System.out.println(v.toString());
        }

        System.out.println();
        System.out.println("-------Ordeno por precio no mayor a 1000-------");

        garaje
                .getVehiculos()
                .stream()
                .filter(v -> v.getPrecio() < 1000).toList();

        for(Vehiculo v : garaje.getVehiculos()){
            System.out.println(v.toString());
        }


        System.out.println();
        System.out.println("-------Ordeno por precio mayor a 1000-------");

        List<Vehiculo> listaDeVehiculosMayorA1000 = garaje
                .getVehiculos()
                .stream()
                .filter(v -> v.getPrecio() >= 1000).toList();

        for(Vehiculo v : listaDeVehiculosMayorA1000){
            System.out.println(v.toString());
        }

        Double promedioTotal = listaDeVehiculosMayorA1000
                .stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average().orElse(0.0);
        System.out.println("El pronedio es " + promedioTotal);

    }
}