package ej_integrador_p1;

import java.util.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public class Cliente {
  public static List<Cliente> clientes = new ArrayList<>();
  private String dni;
  private String nombre;
}
