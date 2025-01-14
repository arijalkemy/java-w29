package abs_series_numericas;

public class SerieEntera extends Serie<Integer> {
  private Integer calcIncremento(Integer valorInicial){
    if(valorInicial == 2) return 2;
    else if(valorInicial == 1) return 2;
    else return 3;
  }

  private Integer calcValorActual(Integer valorInicial){
    if(valorInicial == 2) return 0;
    else if(valorInicial == 1) return 1;
    else return 0;
  }
  
  public SerieEntera(Integer valorInicial){
    super(valorInicial);
    this.valorIncremento = calcIncremento(valorInicial);
    this.valorActual = calcValorActual(valorInicial);
  }

  public Integer valorSiguiente(){
    return this.valorActual += this.valorIncremento;
  }

  public void reiniciar(){
    this.valorActual = calcValorActual(this.valorInicial);
  }

  public void valorInicial(Integer valorInicial){
    this.valorInicial = valorInicial;
    this.valorIncremento = calcIncremento(valorInicial);
    this.valorActual = calcValorActual(valorInicial);
  }
}
