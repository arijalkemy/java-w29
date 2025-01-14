package integrador_p1;

import java.util.List;

public class Localizador {
  private Cliente cliente;
  private List<Reserva> reservas;
  private Repositorio repositorio;

  public String toString(){
    return "Cliente: " + cliente + " Reservas: " + reservas;
  }

  public Localizador(Cliente cliente, List<Reserva> reservas, Repositorio repositorio) {
    this.cliente = cliente;
    this.reservas = reservas;
    this.repositorio = repositorio;
    this.repositorio.addLocalizador(this);
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<Reserva> getReservas() {
    return reservas;
  }

  public void setReservas(List<Reserva> reservas) {
    this.reservas = reservas;
  }

  public Double getTotal() {
    Double total = 0.0;
    if(repositorio.numClienteCompras(cliente) > 2){
      System.out.println("Descuento del 5% numero de compras");
      total = reservas.stream().mapToDouble(Reserva::getTotal).sum();
      return total * 0.95;
    }
    if(reservas.stream().anyMatch(Reserva::haveAllProductTypes)){
      System.out.println("Descuento del 10% todos los tipos de productos");
      total = reservas.stream().mapToDouble(Reserva::getTotal).sum(); 
      return total * 0.9;
    }
    Integer numReserva = reservas.stream().mapToInt(Reserva::numReservaProductType).sum();
    Integer numBoletos = reservas.stream().mapToInt(Reserva::numBoletosProductType).sum();
    if(numReserva >= 2 && numBoletos >= 2){
      System.out.println("Descuento del 5% mas de 2 reservas o 2 boletos");
      total += reservas.stream()
        .mapToDouble(reserva -> {
          if(reserva.numReservaProductType() > 0 || reserva.numBoletosProductType() > 0)
            return reserva.getTotal() * 0.95;
          else return reserva.getTotal();
        }).sum();
    }
    return total;
  }
}
