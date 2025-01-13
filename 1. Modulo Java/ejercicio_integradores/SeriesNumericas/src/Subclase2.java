public class Subclase2 extends Prototipo<Integer>{
    Integer incremento;

    public Subclase2(Integer numero) {
        this.incremento = numero;
    }

    @Override
    public Integer obtenerSiguienteValor() {
        Integer siguientevalor = valorActual;
        valorActual += incremento;
        return siguientevalor;
    }
}
