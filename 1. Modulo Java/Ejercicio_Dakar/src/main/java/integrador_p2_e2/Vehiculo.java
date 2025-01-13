package integrador_p2_e2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public abstract class Vehiculo {
    private Double velocidad;
    private Double aceleracion;
    private Double anguloDeGiro;
    private String patente;
    private Double peso;
    private Integer ruedas;

    public Double calculateScore() {
        return this.getVelocidad() * 0.5 * this.getAceleracion() / (this.getAnguloDeGiro() * (this.getPeso() - this.getRuedas() * 100));
    }
}
