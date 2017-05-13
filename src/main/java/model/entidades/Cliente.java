package model.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pedro on 14/04/17.
 */
@Entity
public class Cliente {
    @Id
    private int codigo;
    private String nomeEstabelecimento;
    private String endereco;
    private String telefone;
    private String responsavel;

    public Cliente(int codigo, String nomeEstabelecimento, String endereco, String telefone, String responsavel) {
        this.codigo = codigo;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.responsavel = responsavel;
    }

    public Cliente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

}
