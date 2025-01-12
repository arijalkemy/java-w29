package clases;

public abstract class Prototipo <T extends Number> {

    protected T valorActual;

    public Prototipo() {
        this.valorActual = null;
    }

    public T valorSiguiente(T incremento){
        if (valorActual instanceof Integer){
            valorActual = (T) Integer.valueOf(valorActual.intValue() + incremento.intValue());
        } else if (valorActual instanceof Double) {
            valorActual = (T) Double.valueOf(valorActual.doubleValue() + incremento.doubleValue());
        }
        return valorActual;
    }
    public void reiniciarSerie(){
        this.valorActual = null;
    }
    public abstract void establecerValorInicialSerie(T valorInicial);

}
