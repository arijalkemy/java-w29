package services;

import models.Cliente;
import models.Localizador;
import models.Reserva;
import models.TipoReserva;
import repositories.LocalizadorRepository;

import java.util.*;
import java.util.stream.Collectors;

public class LocalizadorService {
    private final ClienteService clienteService;
    private final LocalizadorRepository localizadorRepository;

    public LocalizadorService(LocalizadorRepository localizadorRepository, ClienteService clienteService) {
        this.localizadorRepository = localizadorRepository;
        this.clienteService = clienteService;
    }

    public Localizador crearLocalizador(Cliente cliente, List<Reserva> reservas) {

        Cliente clienteEncontrado = this.clienteService.obtenerCliente(cliente);

        double total = calcularTotal(reservas, cliente);
        Localizador localizador = new Localizador(
                UUID.randomUUID().toString(),
                clienteEncontrado,
                reservas,
                total
        );

        localizadorRepository.guardar(localizador);
        return localizador;
    }

    public Integer getCantidadLocalizadoresVendidos() {
        return this.localizadorRepository.buscarTodos().size();
    }

    public Long getCantidadTotalReservas() {
        return this.localizadorRepository.buscarTodos().stream()
                .mapToLong(localizador -> localizador.getReservas().size())
                .sum();
    }

    public Map<TipoReserva, List<Reserva>> getReservasClasificadas() {
        List<Reserva> reservas = this.getReservas();
        Map<TipoReserva, List<Reserva>> reservasClasificadas = new HashMap<>();
        reservas.forEach(reserva -> {
           List<Reserva> reservasTipo = reservasClasificadas.getOrDefault(reserva.getTipo(), new ArrayList<>());
           reservasTipo.add(reserva);
           reservasClasificadas.put(reserva.getTipo(), reservasTipo);
        });

        return reservasClasificadas;
    }

    //Solucion interesante
    public Map<TipoReserva, List<Reserva>> getReservasClasificadasStreams() {
        return this.getReservas().stream()
                .collect(Collectors.groupingBy(Reserva::getTipo));
    }

    public Double getTotalVentas() {
        return this.localizadorRepository.buscarTodos().stream()
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public Double getPromedioVentas() {
        return this.localizadorRepository.buscarTodos().stream()
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0.0);
    }

    private double calcularTotal(List<Reserva> reservas, Cliente cliente) {
        double subtotal = reservas.stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();

        boolean tienePaqueteCompleto = (reservas.stream()
                .map(Reserva::getTipo)
                .distinct()
                .count()) == TipoReserva.values().length;

        boolean tieneDosHoteles = reservas.stream()
                .filter( r -> r.getTipo() == TipoReserva.HOTEL)
                .count() >= 2;

        boolean tieneDosBoletos = reservas.stream()
                .filter( r -> r.getTipo() == TipoReserva.BOLETOS)
                .count() >= 2;

        double descuento = 0;

        List<Localizador> localizadoresAnteriores = localizadorRepository.buscarPorCliente(cliente.getId());
        if (localizadoresAnteriores.size() >= 2) {
            descuento += 0.05;
        }

        if (tienePaqueteCompleto) {
            descuento += 0.10;
        }

        if (tieneDosHoteles || tieneDosBoletos) {
            descuento += 0.05;
        }

        return subtotal * (1 - descuento);
    }

    private List<Reserva> getReservas() {
        return this.localizadorRepository.buscarTodos().stream()
                .flatMap(localizador -> localizador.getReservas().stream())
                .toList();
    }
}
