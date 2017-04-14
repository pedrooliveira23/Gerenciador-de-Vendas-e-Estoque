package model.bo;

import model.beans.Usuario;
import persistence.UsuarioDao;

/**
 * Created by pedro on 14/04/17.
 */
public class UsuarioBo {
    private UsuarioDao dao = new UsuarioDao();

    public boolean validar(Usuario usuario) {
        for (Usuario u : dao.listar()) {
            if (u.getUsername().equals(usuario.getUsername())
                    && u.getSenha().equals(usuario.getSenha())) {
                return true;
            }
        }
        return false;
    }
}
