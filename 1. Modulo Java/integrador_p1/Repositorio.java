package integrador_p1;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
  private List<Localizador> localizadores;

  public void addLocalizador(Localizador localizador){
    localizadores.add(localizador);
    System.out.println("===================================");
    System.out.println(localizador);
  }

  public Integer numClienteCompras(Cliente cliente){
    return (int) localizadores.stream().filter(localizador -> localizador.getCliente().equals(cliente)).count();
  }

  public Repositorio() {
    this.localizadores = new ArrayList<>();
  }
  public Repositorio(List<Localizador> localizadores) {
    this.localizadores = localizadores;
  }

  public List<Localizador> getLocalizadores() {
    return localizadores;
  }

  public void setLocalizadores(List<Localizador> localizadores) {
    this.localizadores = localizadores;
  }
}
