package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("12345", "Jhon", "Zuñiga");
        Cliente cliente2 = new Cliente("98765", "Matias", "Perez");
        Cliente cliente3 = new Cliente("57843", "Sara", "Lopez");

        List<Cliente> listaClientes = new ArrayList<Cliente>();

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        for(Cliente cliente : listaClientes) {
            System.out.println("DNI: " + cliente.getDni());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
        }

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona que quiere borrar");
        String dniBorrado = entrada.next();

        Boolean bandera = false;

        for(Cliente cliente : listaClientes) {
            if(cliente.getDni().equals(dniBorrado)){
                listaClientes.remove(cliente);
                bandera = true;
                break;
            }
        }

        if(bandera.equals(false)){
            System.out.println("No se encontro a la persona con dni: " + dniBorrado);
        }else {
            System.out.println("Cliente borrado correctamente");
        }

        System.out.println("Ingrese el dni del cliente: ");
        String dniBuscado = entrada.next();

        bandera = false;
        for(Cliente cliente : listaClientes) {
            if(cliente.getDni().equals(dniBuscado)){
                System.out.println("___________________________");
                System.out.println("DNI: " + cliente.getDni());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Apellido: " + cliente.getApellido());
                bandera = true;
                break;
            }
        }

        if(bandera.equals(false)){
            System.out.println("Cliente no encontrado");
        }
    }
}