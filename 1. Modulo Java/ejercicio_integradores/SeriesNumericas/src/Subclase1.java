public class Subclase1 extends  Prototipo<Integer> {
    Integer incremento;

    public Subclase1(Integer incremento) {
        this.incremento = incremento;
    }

    @Override
    public Integer obtenerSiguienteValor() {
        Integer siguienteValor =  valorActual;
        valorActual += incremento;
        return siguienteValor;
    }
}


