package Models;

import java.util.List;

public class Cliente {
    private int id;
    private String dni;
    private String nome;
    private String lastname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Cliente(String dni, String nome, String lastname) {
        this.dni = dni;
        this.nome = nome;
        this.lastname = lastname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Models.Cliente{" +
                "id=" + id + '\'' +
                "dni='" + dni + '\'' +
                ", nome='" + nome + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
