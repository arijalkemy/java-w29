package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private static Integer idCount = 1;

    private final Integer id;
    private Cliente cliente;
    private Double total;
    private List<Reserva> reservas;
    private Double descuentoTotal;
    private final List<Descuento> descuentosAplicados;

    public Localizador(Cliente cliente) {
        this.id = idCount++;
        this.cliente = cliente;
        this.total = (double) 0;
        this.reservas = new ArrayList<>();
        this.descuentosAplicados = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(Double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void calcularTotal(boolean descuentoLocalizadores) {
        descuentoTotal = 0.0;

        if (esPaqueteCompleto()) {
            System.out.println("Se aplica 10% de descuento a total por compra paquete completo");
            descuentosAplicados.add(new Descuento("10", "Se aplica 10% de descuento a total por compra paquete completo"));
            descuentoTotal += 0.1;
        }

        if (descuentoLocalizadores) {
            System.out.println("Se aplica 5% de descuento a total por haber comprado más de dos localizadores anteriormente");
            descuentosAplicados.add(new Descuento("5", "Se aplica 5% de descuento a total por haber comprado más de dos localizadores anteriormente"));
            descuentoTotal += 0.05;
        }

        aplicarDescuento2Reservas();

        total = reservas.stream().mapToDouble(Reserva::getPrecio).sum() * (1 - descuentoTotal);
    }

    private boolean esPaqueteCompleto(){
        boolean tieneReservaBoleto = reservas.stream().anyMatch(r -> r instanceof ReservaBoleto);
        boolean tieneReservaHotel = reservas.stream().anyMatch(r -> r instanceof ReservaHotel);
        boolean tieneReservaComida = reservas.stream().anyMatch(r -> r instanceof ReservaComida);
        boolean tieneReservaTransporte = reservas.stream().anyMatch(r -> r instanceof ReservaTransporte);

        return tieneReservaBoleto && tieneReservaComida && tieneReservaTransporte && tieneReservaHotel;
    }



    private void validarDescuento2ReservasBoletos(){
        List<ReservaBoleto> reservaBoletos = reservas.stream()
                .filter(r -> r instanceof ReservaBoleto)
                .map(rb -> (ReservaBoleto) rb)
                .toList();

        if(reservaBoletos.size() >=2){
            System.out.println("Se aplica 5% de descuento a las reservas de boletos por compra de dos reservas de boletos");
            descuentosAplicados.add(new Descuento("5", "Se aplica 5% de descuento a las reservas de boletos por compra de dos reservas de boletos"));
            reservaBoletos.forEach(reserva -> reserva.setPrecio(reserva.getPrecio() * 0.95));
        }

    }

    private void validarDescuento2ReservasHotel(){
        List<ReservaHotel> reservaHoteles = reservas.stream()
                .filter(r -> r instanceof ReservaHotel)
                .map(rb -> (ReservaHotel) rb)
                .toList();

        if(reservaHoteles.size() >=2){
            System.out.println("Se aplica 5% de descuento a las reservas de hotel por compra de dos reservas de hotel");
            descuentosAplicados.add(new Descuento("5", "Se aplica 5% de descuento a las reservas de hotel por compra de dos reservas de hotel"));
            reservaHoteles.forEach(reserva -> reserva.setPrecio(reserva.getPrecio() * 0.95));
        }

    }

    private <T> void validarDescuento2Reservas(List<?> reservas, Class<T> Reserva, String mensajeDescuento){
        List<T> reservasFiltradas = reservas.stream()
                .filter(Reserva::isInstance)
                .map(Reserva::cast)
                .toList();

        if (reservasFiltradas.size() >=2){
            System.out.println(mensajeDescuento);
            reservasFiltradas.forEach(reserva -> {
                if (reserva instanceof Reserva r){
                    r.setPrecio(r.getPrecio() * 0.95);
                    descuentosAplicados.add(new Descuento("5", mensajeDescuento));
                }
            });
        }
    }

    private void aplicarDescuento2Reservas(){
        validarDescuento2Reservas(reservas, ReservaBoleto.class, "Se aplica 5% de descuento a la reserva de boleto por compra de dos reservas de boletos");
        validarDescuento2Reservas(reservas, ReservaHotel.class, "Se aplica 5% de descuento a la reserva de hotel por compra de dos reservas de hotel");
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                "\nDescuentosAplicados=" + descuentosAplicados +
                '}';
    }
}
