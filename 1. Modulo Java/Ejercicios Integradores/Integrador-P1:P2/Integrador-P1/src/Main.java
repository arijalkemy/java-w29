import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //parte 1
        Cliente cliente = new Cliente(1,"Nicolas", "Fiore");
        Cliente cliente1 = new Cliente(2,"Aixa","Castillo");
        Cliente cliente2 = new Cliente(3,"Federico", "Fiore");
        Cliente cliente3 = new Cliente(4, "Diego", "Fiore");

        List<Cliente> clientes = new ArrayList<>(Arrays.asList(cliente,cliente1,cliente2));

        for (Cliente c: clientes){
            System.out.println(c);
        }
        /*
        System.out.println("Eliminando al ultimo cliente agregado");
        clientes.removeLast();
        for (Cliente c: clientes){
            System.out.println(c);
        }
        System.out.println("Agregando al ultimo cliente eliminado");
        clientes.add(cliente2);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a buscar");
        Integer dniBuscado = teclado.nextInt();
        Boolean bandera = false;

        for (Cliente c: clientes){
            if (c.getDni() == dniBuscado) {
                System.out.println(c);
                bandera = true;
                break;
            }
        }
        if(bandera == false){
            System.out.println("DNI inexistente");
        }

         */

        //parte 2
        //creo items
        Item item = new Item(101L, "Laptop", 5, 1000.00);
        Item item1 =new Item(102L, "Smartphone", 2, 800.00);
        Item item2 =new Item(103L, "Tablet", 3, 500.00);
        Item item3 =new Item(104L, "Headphones", 5, 250.00);
        Item item4 =new Item(105L, "Mouse", 20, 100.00);

        //los agrego a una lista
        List<Item> lista = new ArrayList<>(Arrays.asList(item,item2,item3));

        //pasa el cliente a validar
        Cliente clienteValidacion = cliente3;

        //valida si el cliente asociado a la factura se encuentra registrado en la collection de clientes.
        //en caso de que no, el mismo deberá ser creado.
        if (clientes.contains(clienteValidacion)){
            Factura factura = new Factura(clienteValidacion, lista);
            System.out.println(factura.toString());
        }
        else {
            Cliente cliente0 = new Cliente(000,"Error", "Cliente inexistente");
            Factura factura = new Factura(cliente0, lista);
            System.out.println(factura.toString());
        }




    }
}
