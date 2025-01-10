package org.example.repositorios;

import org.example.clases.Cliente;
import org.example.clases.Localizador;
import org.example.clases.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ImplementacionRepositoryLocalizador implements RepositoryLocalizador {
    private List<Localizador> localizadores;

    public ImplementacionRepositoryLocalizador() {
        this.localizadores =new ArrayList<>();
    }

    @Override
    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    @Override
    public List<Localizador> obtenerLocalizadoresCliente(Cliente cliente) {
        return localizadores.stream().filter(localizador -> localizador.getCliente().equals(cliente)).toList();
    }

    @Override
    public Double calcularPrecio(Cliente cliente, List<Reserva> reservas) {
        List<Localizador> listloccliente = obtenerLocalizadoresCliente(cliente);

        double descuento = 0;

        //Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total
        // para futuras compras.
        if(listloccliente.size()>=2){
            descuento +=0.05;
        }

        //Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida,
        // boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
        if (reservas.stream().map(r -> r.getTipoReserva().getNombre()).distinct().count() == 4){
            descuento +=0.10;
        }

        //Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5%
        // en esas reservas.
        if(reservas.stream().filter(r -> r.getTipoReserva().getNombre().equals("Hotel")).count() >= 2 || reservas.stream().filter(r -> r.getTipoReserva().getNombre().equals("Boleto")).count() >= 2){
            descuento +=0.05;
        }

        Double totalLocalizador= reservas.stream().mapToDouble(Reserva::getTotal).sum();

        totalLocalizador-=totalLocalizador*descuento;

        return totalLocalizador ;
    }

    @Override
    public Integer localizadoresVendidos() {
        return localizadores.size();
    }

    @Override
    public Integer reservasVendidas() {
        Integer totalReservas = 0;
        for (Localizador localizador : localizadores) {
            totalReservas+=localizador.getListaReservas().size();
        }
        return totalReservas;
    }
}
