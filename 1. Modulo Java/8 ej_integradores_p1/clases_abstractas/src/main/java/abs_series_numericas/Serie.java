package abs_series_numericas;

import lombok.*;

public abstract class Serie<T extends Number> {
  protected T valorInicial;
  protected T valorActual;
  protected T valorIncremento;
  public Serie(T valorInicial){
    this.valorInicial = valorInicial;
  }
  public abstract T valorSiguiente();
  public abstract void reiniciar();
  public abstract void valorInicial(T valorInicial);
}