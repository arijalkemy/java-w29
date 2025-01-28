package org.example;

import org.example.model.Cliente;
import org.example.repositiry.ClienteImp;


import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ClienteImp cliImp = new ClienteImp();

        Cliente cli1 = new Cliente(12365458L, "Holmes", "Ramirez");
        Cliente cli2 = new Cliente(65987456L, "Melita", "Ramirez");
        Cliente cli3 = new Cliente(123456789L, "Karen", "Gonzalez");
        Cliente cli4 = new Cliente(12L, "Yiyi", "Gon");


        cliImp.save(cli1); //Guardar un cliente

        cliImp.mostrarPantalla(); //Mostrar todos los clientes

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();
        cliImp.buscar(dniBuscado);

        System.out.println("Ingrese el dni para borrar");
        Long dniBorrado = teclado.nextLong();
        cliImp.eliminar(dniBorrado);

    }
}
