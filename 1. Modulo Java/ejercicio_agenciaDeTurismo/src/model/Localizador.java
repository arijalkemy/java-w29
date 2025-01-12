package model;

import java.util.*;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;

    private Double PrecioTotalConDescuento;
    private Double PrecioTotalSinDescuento;
    private TipoPaquete tipoPaquete;
    Map<String, Integer> cantidadReservas;



    public Double getPrecioTotalLocalizador() {
        return PrecioTotalConDescuento;
    }



    public Localizador(Cliente cliente) {
        this.PrecioTotalConDescuento = 0.0;
        this.PrecioTotalSinDescuento = 0.0;
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
        this.cantidadReservas = new HashMap<>();
    }



    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        cantidadReservas.put(
                reserva.getNombre(),
                cantidadReservas.getOrDefault(reserva.getNombre(), 0) + 1
        );
    }

    private void aplicarDescuentoDobleLocalizador() {
        this.PrecioTotalConDescuento *= 0.95;
    }

    private void aplicarDescuentoDoblePaquete() {
        this.PrecioTotalConDescuento *= 0.95;
    }

    private void aplicarDescuentoPaqueteCompleto() {
        this.PrecioTotalConDescuento *= 0.90;
    }

    public TipoPaquete getTipoPaquete() {
        return tipoPaquete;
    }

    private void aplicarDescuento(Integer cantidadLocalizadores) {

        if (tipoPaquete == TipoPaquete.DOBLE) {
            aplicarDescuentoDoblePaquete();
        }else if (tipoPaquete == TipoPaquete.COMPLETO) {
            aplicarDescuentoPaqueteCompleto();
        } else if(tipoPaquete == TipoPaquete.DOBLEYCOMPLETO){
            aplicarDescuentoDoblePaquete();
            aplicarDescuentoPaqueteCompleto();
        } else if(cantidadLocalizadores>=2){
            aplicarDescuentoDobleLocalizador();
        }


    }

    public void analizarTipoPaquete() {
        int hoteles = cantidadReservas.getOrDefault(TipoReserva.HOTEL.getDescripcion(), 0);
        int boletos = cantidadReservas.getOrDefault(TipoReserva.BOLETO_DE_VIAJE.getDescripcion(), 0);

        if ((hoteles >= 2 || boletos >= 2)&&(cantidadReservas.size() == 4)) {
            tipoPaquete = TipoPaquete.DOBLEYCOMPLETO;
        } else if (cantidadReservas.size() == 4) {
            tipoPaquete = TipoPaquete.COMPLETO;
        }  else if (hoteles >= 2 || boletos >= 2) {
            tipoPaquete = TipoPaquete.DOBLE;
        }
        else {
            tipoPaquete = TipoPaquete.NORMAL;
        }
    }

    public void calcularTotal(Integer cantidadLocalizadores) {
        analizarTipoPaquete();
        this.PrecioTotalSinDescuento = reservas.stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();

        this.PrecioTotalConDescuento = reservas.stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();

        aplicarDescuento(cantidadLocalizadores);
    }

    public int totalDeReservas(){
        return reservas.size();
    }

    public Map<String, Integer> getCantidadReservas() {
        return cantidadReservas;
    }

    @Override
    public String toString() {
        return "Tipo de Paquete: " + (tipoPaquete != null ? tipoPaquete : "No definido") + "\n" +
                "Precio Total Sin Descuento: " + String.format("%.2f", PrecioTotalSinDescuento) + "\n" +
                "Precio Total Con Descuento: " + String.format("%.2f", PrecioTotalConDescuento);
    }




}
