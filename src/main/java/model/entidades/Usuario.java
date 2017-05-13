package model.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pedro on 14/04/17.
 */
@Entity
public class Usuario {
    @Id
    private String username;
    private String senha;

    public Usuario(String nomeUsuario, String senha) {
        this.username = nomeUsuario;
        this.senha = senha;
    }

    public Usuario() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }
}
