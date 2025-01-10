package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prendas>> prendas;
    private Integer contador = 0;

    // constructor

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    //getters y setters
    public Map<Integer, List<Prendas>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prendas>> prendas) {
        this.prendas = prendas;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    //Guardar prenda
    //Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda), en la Clase GuardaRopa,
    // que recibe una lista de prendas y devuelve el número identificador en donde quedaron asignadas las
    // prendas, es decir la clave del diccionario en donde guardamos las mismas.
     public Integer guardarPrendas(List<Prendas> listaDePrenda){

        contador++;
        prendas.put(contador,listaDePrenda);
        return contador;

     }

     //mostrar prendas
    //Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla todas
    // las prendas que quedan en el guardarropas junto con el número que les corresponde.
     public void mostrarPrendas(){
         System.out.println("LISTADO DE PRENDAS:");

         for (Integer key : prendas.keySet()) {
             System.out.print("ID: " + key);
             System.out.println(" | Prendas: " + prendas.get(key));
         }
     }

     //eliminar prenda
    //Crear el método public List<Prenda> devolverPrendas(Integer numero), en la Clase GuardaRopa que
    // devuelve la lista de prendas que están guardadas bajo ese número.

    public List<Prendas> devolverPrendas(Integer numero){
        return prendas.remove(numero);
    }
}
