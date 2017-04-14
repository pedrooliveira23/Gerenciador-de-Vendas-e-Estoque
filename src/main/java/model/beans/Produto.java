package model.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pedro on 14/04/17.
 */
@Entity
public class Produto {
    @Id
    private int codigo;
    private String nome;
    private long valorUnitario;

    public Produto(int codigo, String nome, long valorUnitario) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
    }

    public Produto() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
