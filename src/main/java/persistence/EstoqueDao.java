package persistence;

import model.entidades.Estoque;
import utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 13/05/17.
 */
public class EstoqueDao {
    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("gve-persistence");
    private EntityManager em = emf.createEntityManager();

    public void adicionar(Estoque estoque) {
        try {
            em.getTransaction().begin();

            em.persist(estoque);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }

    public void remover(Estoque estoque) {
        em.getTransaction().begin();
        em.remove(em.contains(estoque) ? estoque : em.merge(estoque));
        em.getTransaction().commit();
    }

    public void editar(Estoque estoque, Estoque estoqueAnterior) {
        remover(estoqueAnterior);
        adicionar(estoque);
    }

    public List<Estoque> pesquisarPorCodigo(String codigo) {
        List<Estoque> result = new ArrayList<Estoque>();
        try {
            String jpql = "FROM Estoque WHERE codigoItem = " + codigo;
            return JpaUtil.getEntityManager()
                    .createQuery(jpql, Estoque.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Estoque> pesquisarPorNome(String nome) {
        List<Estoque> result = new ArrayList<Estoque>();
        try {
            String jpql = "FROM Estoque WHERE nome LIKE '%" + nome + "%'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Estoque.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Estoque> listar() {
        List<Estoque> result = new ArrayList<Estoque>();
        try {
            String jpql = "from Estoque";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Estoque.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }
}
