package org.example;

import org.example.clases.Cliente;
import org.example.clases.Factura;
import org.example.clases.Item;
import org.example.repository.ClienteImp;
import org.example.repository.FacturaImp;
import org.example.repository.ItemImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteImp clienteImp = new ClienteImp();
        //Crear 3 clientes y guardarlos en una collection.

        Cliente c1 = new Cliente(1,"Franca", "Pairetti", "24356788");
        Cliente c2 = new Cliente(2,"Franco", "Quinteros", "43556789");
        Cliente c3 = new Cliente(3,"María", "Perez", "23190160");


        clienteImp.save(c1);
        clienteImp.save(c2);
        clienteImp.save(c3);


        // Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
         clienteImp.mostrarPorPantalla();

        //Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
        System.out.println("----- Eliminar un cliente y mostras los restantes -----");
        clienteImp.eliminar(2);
        clienteImp.mostrarPorPantalla();


        // Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se
        // encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha
        // situación.

        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese un DNI:");
        String dni = in.next();

        clienteImp.buscarPorDni(dni);


        //PARTE 2
        //Crear una nueva factura.
        Factura f1 = new Factura(1, c1);

        //Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
        FacturaImp facturaImp = new FacturaImp();

        //Será necesario validar si el cliente asociado a la factura se encuentra registrado en la
        // collection de clientes. En caso de que no, el mismo deberá ser creado.
        if(clienteImp.buscarPorID(c1.getId()).isPresent()){
            facturaImp.save(f1);

        }else{
            clienteImp.save(c1);
            facturaImp.save(f1);

        }

        //Será necesario crear una lista de items y asociarla a la factura creada.

        ItemImp itemImp = new ItemImp();

        Item i1 = new Item(1,"FT667895","Harina",3,930.0);
        Item i2 = new Item(1,"PK997895","Arroz",1,2360.0);
        Item i3 = new Item(1,"RT789000","Manteca",1,2800.0);
        Item i4 = new Item(1,"TE888909","Leche",5,2080.0);
        Item i5 = new Item(1,"EE454644","Fideos",1,1330.0);

        itemImp.save(i1);
        itemImp.save(i2);
        itemImp.save(i3);
        itemImp.save(i4);
        itemImp.save(i5);



        //asociar items a factura:
        f1.setItems(itemImp.trearTodos());


        //El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor
        // deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para
        // obtener el total.

        f1.calcularTotal(f1);

        //mostramos la factura final
       facturaImp.mostrarPorPantalla();










    }
}