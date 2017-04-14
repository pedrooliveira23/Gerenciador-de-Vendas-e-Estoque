package model.beans;

import javax.persistence.Entity;

/**
 * Created by pedro on 14/04/17.
 */
@Entity
public class Usuario {
    private String username,
                   senha;

    public Usuario(String nomeUsuario, String senha) {
        this.username = nomeUsuario;
        this.senha = senha;
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
