package org.example.clases;

import java.util.List;

public class Localizador {
    private Integer id;
    private Cliente cliente;
    private List<Reserva> listaReservas;
    private Double valorTotal;

    //Constructores

    public Localizador() {
    }

    public Localizador(Integer id, Cliente cliente, List<Reserva> listaReservas) {
        this.id = id;
        this.cliente = cliente;
        this.listaReservas = listaReservas;
    }

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //to string

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", " + cliente.toString()+
                ", " + listaReservas.toString() +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
