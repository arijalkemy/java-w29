package model;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = aplicarDescuentos();
    }

    public Double aplicarDescuentos(){
        // Descuentods
        Double total = reservas.stream().mapToDouble(Reserva::getValor).sum();
        if (cliente.getTieneDescuento()){
            total *= 0.95;
        } else {
            cliente.setTieneDescuento(true);
        }
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
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


}
