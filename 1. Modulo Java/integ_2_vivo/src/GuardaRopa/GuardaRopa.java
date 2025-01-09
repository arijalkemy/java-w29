package GuardaRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map<Integer, List<Prenda>> diccionario = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        diccionario.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Clave = " + entry.getKey() + ", Valor = " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return diccionario.get(numero);
    }

    public Map<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(Map<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }
}
