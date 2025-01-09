package org.bootcamp.contenedores;

import org.bootcamp.reservas.Reserva;
import org.bootcamp.usuario.Cliente;

import java.util.List;

public class Localizador {
    private org.bootcamp.usuario.Cliente cliente;
    private List<Reserva> reservas;
    private Double descuento;
    private Double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        total=reservas.stream().mapToDouble(Reserva::getTotal).sum();
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


    public void aplicarDescuentoTotal(Double descuento){
        this.descuento = descuento;
        if (descuento>=1 && descuento<=100){
            total=total*( 1 - (descuento / 100));
        }
        else if (descuento>0 && descuento<1){
            this.total = this.total *  (1- this.descuento);
        }
    }
    public void aplicarDescuentoReserva(Reserva reserva, Double descuento){
        reserva.aplicarDescuento(descuento);
        total=reservas.stream().mapToDouble(Reserva::getTotal).sum();
    }
    public void imprimirDetalles() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Reservas: ");
        for (Reserva reserva : reservas) {
            reserva.imprimirdetalles();
            System.out.println("--------------------------------------");
        }
        System.out.println("Total: " + total);
    }

}

