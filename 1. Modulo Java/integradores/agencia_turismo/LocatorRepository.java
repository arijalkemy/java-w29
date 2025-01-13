package com.example.demo.integradores.agencia_turismo;

import java.util.List;
import java.util.Map;

/*

    Parte II (Opcional)

    Agregar una clase que permita realizar las siguientes consultas sobre los localizadores vendidos,
    empleando diferentes métodos que muestren:

    Cantidad de localizadores vendidos.
    Cantidad total de reservas.
    Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
    Total de ventas.
    Promedio de todas las ventas.

 */
public class LocatorRepository {
    private Map<String, List<Locator>> locators;

    public LocatorRepository(Map<String, List<Locator>> locators) {
        this.locators = locators;
    }

    public List<Locator> getLocator(String id) {
        return this.locators.get(id);
    }

    public void setLocators(Map<String, List<Locator>> locators) {
        this.locators = locators;
    }

    public int getLocatorsSold(){
        return this.locators.values().stream().mapToInt(List::size).sum();
    }

    /*
     " 1 " , Locators[] = { getReservations }
     */
    public int getQuantityReservations(){

        /*
        lista.stream()
    .map(persona -> persona.getLista())
    .flatMap(viajes -> viajes.stream())
    .forEach(v->System.out.println(v.getPais());
         */

        return this.locators.values().stream().flatMapToInt(l -> l.stream().mapToInt( (a) -> a.getReservations().size())).sum();

        // return this.locators.values().stream().mapToInt( (a) -> a )  .sum();

    }
}
