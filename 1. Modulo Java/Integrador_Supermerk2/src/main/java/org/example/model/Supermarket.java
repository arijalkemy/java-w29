package org.example.model;

import java.util.List;
import java.util.Objects;

/* Esta clase la use para resolver la parte 1 del ejercicio
public class Supermarket {

    private List<Client> clientes;

    public Supermarket(List<Client> clientes) {
        this.clientes = clientes;
    }

    public List<Client> getClientes() {
        return clientes;
    }

    public void printClients(){
        this.clientes.forEach(System.out::println);
    }

    public void deleteClient(Client client){
        this.clientes.remove(client);
    }

    public Client findClientByDni(int dni) throws Exception {

        Client client = this.clientes.stream().filter(c -> c.getDni() == dni).findFirst().orElse(null);
        if (Objects.isNull(client)) {
            throw new Exception("Cliente no encontrado");
        }
        return client;
    }

    public int totalCost(List<Item> items){

        return items.stream()
                    .mapToInt(i -> i.getCantBuy()*i.getCostUnit())
                    .sum();
    }

    public Invoice makeInvoice(Client client, List<Item> items){

        if (!clientes.contains(client)){
            clientes.add(client);
        }

        return new Invoice(client,items, totalCost(items));
    }
}*/
