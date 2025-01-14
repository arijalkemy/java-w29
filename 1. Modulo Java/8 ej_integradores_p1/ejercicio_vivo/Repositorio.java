package integrador_p1;

import java.util.*;

public class Repositorio {
  private List<Localizador> localizadores;

  public void addLocalizador(Localizador localizador){
    localizadores.add(localizador);
    System.out.println("===================================");
    System.out.println(localizador);
  }

  public Integer numClienteCompras(Cliente cliente){
    return (int) localizadores.stream().filter(localizador -> localizador.getCliente().equals(cliente)).count();
  }

  public Repositorio() {
    this.localizadores = new ArrayList<>();
  }
  public Repositorio(List<Localizador> localizadores) {
    this.localizadores = localizadores;
  }

  public List<Localizador> getLocalizadores() {
    return localizadores;
  }

  public void setLocalizadores(List<Localizador> localizadores) {
    this.localizadores = localizadores;
  }

  public Integer totalLocalizadores(){
    return localizadores.size();
  }

  public Integer totalReservas(){
    return this.localizadores.stream()
      .mapToInt(localizador -> localizador.getReservas().size())
      .sum();
  }

  public Double totalVentas(){
    return this.localizadores.stream()
      .mapToDouble(Localizador::getTotal)
      .sum();
  }

  public Double averageVentas(){
    return this.totalVentas() / this.totalLocalizadores();
  }

  public Map<Producto.Tipo, List<Reserva>> getReservasPorTipo(){
    Map<Producto.Tipo, List<Reserva>> reservasPorTipo = new HashMap<>();
    Arrays.stream(Producto.Tipo.values())
      .forEach(tipo -> {
        reservasPorTipo.put(
          tipo,
          localizadores.stream()
            .map(Localizador::getReservas)
            .flatMap(List::stream)
            .filter(reserva -> reserva.hasProductType(tipo))
            .toList()
        );
      });
    return reservasPorTipo;
  }
}
