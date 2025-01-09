import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {

    private Map<Cliente, List<Localizador>> listaClientes;

    public RepositorioCliente() {
        this.listaClientes = new HashMap<Cliente, List<Localizador>>();
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.put(cliente,new ArrayList<Localizador>());
    }

    public void agregarLocalizador(Cliente cliente, Localizador localizador) {
        if(listaClientes.containsKey(cliente)) {
            listaClientes.get(cliente).add(localizador);
            aplicarDescuento(cliente, localizador);
        }else {
            System.out.println("No existe el cliente en el sistema.");
        }
    }

    public void aplicarDescuento(Cliente cliente, Localizador localizador) {

        //Veo si tiene dos localizadores
        if(listaClientes.get(cliente).size() >= 2){
            localizador.setDescuento(localizador.getDescuento()+0.05);
        }

        //2 reservas hotel o 2 reservas viaje
        List<Reserva> res = localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(Reserva.TipoReserva.HOTEL)).toList();
        List<Reserva> res2 = localizador.getReservas().stream().filter(r -> r.getTipoReserva().equals(Reserva.TipoReserva.TRANSPORTE)).toList();

        if(res.size()>=2 || res2.size()>=2){
            localizador.setDescuento(localizador.getDescuento()+0.05);
        }

        //Paquete completo
        if(localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(Reserva.TipoReserva.HOTEL))
                && localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(Reserva.TipoReserva.TRANSPORTE))
                && localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(Reserva.TipoReserva.BOLETO)) &&
                localizador.getReservas().stream().anyMatch(r -> r.getTipoReserva().equals(Reserva.TipoReserva.COMIDA))
        ){
            localizador.setDescuento(localizador.getDescuento()+0.1);
        }

        localizador.setTotal(localizador.getTotal()-(localizador.getTotal()*localizador.getDescuento()));
    }




}
