package model.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by pedro on 13/05/17.
 */
@Entity
public class Estoque {
    @Id
    private int codigoItem;
    private String nome;
    private long quantidade;

    public Estoque(int codigoItem, long quantidade) {
        this.codigoItem = codigoItem;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Estoque() {
    }

    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }
}
