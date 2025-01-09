import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        
        vehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford","Focus",1200));
        vehiculos.add(new Vehiculo("Ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","Uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add(new Vehiculo("Renault","Logan",950));

        Garaje garaje = new Garaje(1, vehiculos);

        List<Vehiculo> vehiculoOrdernado =  garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getPrecio)).toList();
        vehiculoOrdernado.forEach(System.out::println);

        List<Vehiculo> vehiculoOrdenado2 = garaje.getVehiculos().
                                        stream().
                                        sorted(Comparator.comparing(Vehiculo::getPrecio).thenComparing(Vehiculo::getMarca))
                                        //sorted(Comparator.comparing(Vehiculo::getMarca))
                                       .toList();

        System.out.println("Lista 2");
        vehiculoOrdenado2.forEach(System.out::println);

        List<Vehiculo> vehiculoMenor1000 = garaje.getVehiculos().stream().filter((v)-> v.getPrecio() < 1000).toList();
        System.out.println("Lista < 1000");
        vehiculoMenor1000.forEach(System.out::println);

        List<Vehiculo> vehiculoMayor1000 = garaje.getVehiculos().stream().filter((v)-> v.getPrecio() >= 1000).toList();
        System.out.println("Lista >= 1000");
        vehiculoMayor1000.forEach(System.out::println);

        OptionalDouble promedio = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getPrecio)
                .average();

        System.out.println("Promedio = " + promedio.getAsDouble());






    }
}