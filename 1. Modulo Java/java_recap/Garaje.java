package java_recap;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Garaje {
  private Integer id;
  List<Vehiculo> vehiculos;

  public List<Vehiculo> sortPrice(){
    return vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
  }

  public List<Vehiculo> sortBrandPrice(){
    return vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).toList();
  }

  public List<Vehiculo> selectPrice(Function<Double, Boolean> validator){
    return vehiculos.stream().filter(vehiculo -> validator.apply(vehiculo.getCosto())).toList();
  }

  public Double getAveragePrice(){
    return vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
  }

  public Garaje(Integer id, List<Vehiculo> vehiculos) {
    this.id = id;
    this.vehiculos = vehiculos;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }
  public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }
}
