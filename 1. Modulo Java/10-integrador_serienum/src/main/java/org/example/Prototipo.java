package org.example;

public abstract class Prototipo {
    /// La clase prototipo contendrá tres métodos. El primero de los métodos es el encargado de devolver un
    ///número que corresponderá al valor siguiente a la serie progresiva. Otro método para reiniciar la serie,
    ///y un último que recibirá un valor que servirá para establecer el valor inicial de la serie.
    private Number valorinicial;
    public abstract Number siguiente();
    public abstract void reiniciar();

    public Number getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(Number valorinicial) {
        this.valorinicial = valorinicial;
    }
}
