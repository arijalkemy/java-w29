public abstract class Prototipo <T>{
    T valorInicial;
    T valorActual;

    public void establecerValorInicial(T valor){
        this.valorInicial = valor;
        this.valorActual = valor;
    }

    public void reiniciarSerie(){
        this.valorActual = valorInicial;
    }

    public abstract T obtenerSiguienteValor();




}
