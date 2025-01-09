package integrador_p1;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Cliente cliente = new Cliente("Juan", "12345678");
    Repositorio repositorio_cliente = new Repositorio();
    Localizador localizador = new Localizador(
      cliente, 
      List.of(
        new Reserva(List.of(
          new Producto(100.0, Producto.Tipo.RESERVA),
          new Producto(200.0, Producto.Tipo.COMIDA),
          new Producto(300.0, Producto.Tipo.BOLETOS),
          new Producto(400.0, Producto.Tipo.TRANSPORTE)
        ))
      ), 
      repositorio_cliente
    );
    System.out.println("Localizador 1: " + localizador.getTotal());

    Localizador localizador2 = new Localizador(
      cliente,
      List.of(
        new Reserva(List.of(
          new Producto(100.0, Producto.Tipo.RESERVA)
        )),
        new Reserva(List.of(
          new Producto(300.0, Producto.Tipo.BOLETOS),
          new Producto(500.0, Producto.Tipo.BOLETOS),
          new Producto(700.0, Producto.Tipo.RESERVA)
        ))
      ),
      repositorio_cliente
    );
    System.out.println("Localizador 2: " + localizador2.getTotal());

    Localizador localizador3 = new Localizador(
      cliente,
      List.of(
        new Reserva(List.of(
          new Producto(1000.0, Producto.Tipo.RESERVA)
        ))
      ),
      repositorio_cliente
    );
    System.out.println("Localizador 3: " + localizador3.getTotal());
  }
  
}