import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Map<Integer, List<Prenda>> prendas = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        prendas.put(contador, listaDePrenda);
        return contador++;
    }
    public void mostrarPrendas(){
        prendas.forEach((key, value) -> {
            System.out.println("Prendas en el guardarropa " + (contador + 1));
            value.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendas.get(numero);
    }
}
