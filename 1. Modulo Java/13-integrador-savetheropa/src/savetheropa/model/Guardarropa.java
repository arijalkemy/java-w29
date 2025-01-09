package savetheropa.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Guardarropa {
    private Integer contadorId;
    private Map<Integer, List<Prenda>> guardarropa;

    public Guardarropa(){
        this.contadorId = 0;
        this.guardarropa = new HashMap<>();
    }

    public Integer guardarPrenda(List<Prenda> listaDePrenda){
        this.guardarropa.put(++this.contadorId, listaDePrenda);
        return contadorId;
    }

    public void mostrarPrendas(){
        guardarropa.forEach((id, prendas) -> {
            System.out.println("ID: " + id);
            System.out.println("Prendas:");
            prendas.forEach(prenda -> System.out.println("  - " + prenda));
        });
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return guardarropa.get(id);
    }
}
