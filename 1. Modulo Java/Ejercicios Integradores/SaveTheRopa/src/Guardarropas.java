import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropas {
    private Map<Integer, List<Prenda>> almacen = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        List<Prenda> listaGuardadas = new ArrayList<>(listaDePrenda);
        almacen.put(++contador, listaGuardadas);
        return contador;
    }

    public void mostrarPrendas() {
        almacen.forEach((id, prendas) ->
                prendas.forEach(prenda ->
                        System.out.println("ID: " + id + ", " + prenda)
                )
        );
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas = almacen.get(numero);
        if (prendas == null) {
            System.out.println("No se encontraron prendas para el código: " + numero);
            return new ArrayList<>(); // Devolver una lista vacía
        }
        return prendas;
    }
}