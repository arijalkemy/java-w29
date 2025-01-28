package org.example;

import org.example.model.Cliente;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente(12365458L, "Holmes", "Ramirez");
        Cliente cli2 = new Cliente(65987456L, "Melita", "Ramirez");
        Cliente cli3 = new Cliente(123456789L, "Karen", "Gonzalez");
        Cliente cli4 = new Cliente(12L, "Yiyi", "Gon");


        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);
        listaClientes.add(cli4);

        for (Cliente c : listaClientes) {
            System.out.println("Dni = " + c.getDni());
            System.out.println("Nombre = " + c.getNombre());
            System.out.println("Apellido = " + c.getApellido());
        }

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite dni de cliente a eliminar: ");
        Long dniBorrado = teclado.nextLong();
        Boolean bandera = false;

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBorrado)) {
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (bandera==false) {
            System.out.println("El cliente a eliminar no existe");
        }else {
            System.out.println("El cliente se a eliminado");
        }


        System.out.println("Digite dni de cliente a buscar: ");
        Long dniBuscado = teclado.nextLong();

        bandera = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("------------- Cliente encontrado, sus datos son: ---------");
                System.out.println("DNI = " + c.getDni());
                System.out.println("Nombre = " + c.getNombre());
                System.out.println("Apellido = " + c.getApellido());
                break;
            }
        }

        if (bandera==false) {
            System.out.println("El cliente no se ha encontrado");
        }
        }
    }
