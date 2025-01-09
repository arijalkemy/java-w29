import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

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
                    .sorted((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()))//Comparator.comparingDouble(Vehiculo::getMarca)
                    .forEach(System.out::println);
        
        System.out.println("\n----Por marca y precio----");
        vehiculos.stream()
                    .sorted((v1, v2) -> {
                        int cmp = v1.getMarca().compareTo(v2.getMarca());
                        if (cmp == 0){
                            cmp = v1.getCosto().compareTo(v2.getCosto());
                        }
                        return cmp;
                    })
                    .forEach(System.out::println);

        System.out.println("\n----No mayor a 1000----");
        vehiculos.stream().filter(v -> v.getCosto()<=1000).forEach(System.out::println);

        System.out.println("\n----Mayor o igual a 1000----");
        vehiculos.stream().filter(v -> v.getCosto()>=1000).forEach(System.out::println);

        System.out.println("\n----Promedio----");
        System.out.println(vehiculos.stream().mapToDouble(v->v.getCosto()).average().getAsDouble());
    }
}
