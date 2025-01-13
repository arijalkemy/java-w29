import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void mostrarVehiculos(List<Vehiculo> vehiculos) {
        for(Vehiculo vehiculo: vehiculos){
            System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Precio: " + vehiculo.getCosto());
        }
    }

    public List<Vehiculo> getVehiculosOrdenadosPorPrecio(){
        List<Vehiculo> vehiculosCopia = new ArrayList<>(vehiculos);

        vehiculosCopia.sort((Vehiculo v1, Vehiculo v2) -> Integer.compare(v1.getCosto(), v2.getCosto()));

        return vehiculosCopia;
    }

    public List<Vehiculo> getVehiculosOrdenadosPorMarcaYPrecio(){
        List<Vehiculo> vehiculosCopia = new ArrayList<>(vehiculos);

        vehiculosCopia.sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto)
        );

        return vehiculosCopia;
    }

    public List<Vehiculo> getVehiculosPrecioNoMayorAMil(){
        List<Vehiculo> vehiculosCopia = new ArrayList<>(vehiculos);

        return vehiculosCopia.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosPrecioMayorIgualAMil(){
        List<Vehiculo> vehiculosCopia = new ArrayList<>(vehiculos);

        return vehiculosCopia.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
    }

    public Double getPromedioPrecio(){
        OptionalDouble costoPromedio = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();

        return costoPromedio.orElse(0.0);


    }
}
