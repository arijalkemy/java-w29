package repository;

import db.Db;
import model.Cliente;
import model.Localizador;
import model.TipoReserva;

import java.util.HashMap;
import java.util.Map;

public class ClienteRepository {
    public Cliente obtenerCliente(String clave) {
        return Db.clientes.get(clave);
    }

    public void agregarCliente(Cliente cliente) {
        Db.clientes.put(cliente.getNombre() + " " + cliente.getApellido(), cliente);
    }

    public int cantidadTotalLocalizadores() {
        return Db.clientes.values().stream()
                .mapToInt(c -> c.getLocalizadores().size())
                .sum();
    }
}
