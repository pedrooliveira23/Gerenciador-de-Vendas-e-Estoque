package persistence;

import model.beans.Usuario;
import utils.JpaUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 14/04/17.
 */
public class UsuarioDao {
    public List<Usuario> listar() {
        List<Usuario> result = new ArrayList<Usuario>();
        try {
            String jpql = "from Usuario";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }
}
