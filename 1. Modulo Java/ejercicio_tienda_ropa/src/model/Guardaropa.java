package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropa {

    private static Integer contador = 0; // Contador compartido por todas las instancias
    private Map<Integer, List<Prenda>> registros;

    public Guardaropa() {
        this.registros = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        Integer codigo = contador;
        registros.put(codigo, listaDePrenda);
        contador++;
        return codigo;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : registros.entrySet()) {
            System.out.print("Codigo: " + entry.getKey() + ": Ropa: ");
            entry.getValue().forEach(System.out::println);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return registros.get(numero);
    }

    public Map<Integer, List<Prenda>> getRegistros() {
        return registros;
    }

    public void setRegistros(Map<Integer, List<Prenda>> registros) {
        this.registros = registros;
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        Guardaropa.contador = contador;
    }
}
