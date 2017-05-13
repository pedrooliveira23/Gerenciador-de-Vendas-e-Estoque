package persistence;

import model.entidades.Produto;
import utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 14/04/17.
 */
public class ProdutoDao {
    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("gve-persistence");
    private EntityManager em = emf.createEntityManager();

    public void adicionar(Produto produto) {
        try {
            em.getTransaction().begin();

            em.persist(produto);

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

    public void remover(Produto produto) {
        em.getTransaction().begin();
        em.remove(em.contains(produto) ? produto : em.merge(produto));
        em.getTransaction().commit();
    }

    public void editar(Produto produto, Produto produtoAnterior) {
        remover(produtoAnterior);
        adicionar(produto);
    }

    public List<Produto> pesquisarPorCodigo(String codigo) {
        List<Produto> result = new ArrayList<Produto>();
        try {
            String jpql = "FROM Produto WHERE codigo = " + codigo;
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Produto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Produto> pesquisarPorNome(String nome) {
        List<Produto> result = new ArrayList<Produto>();
        try {
            String jpql = "FROM Produto WHERE nome LIKE " + nome;
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Produto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Produto> pesquisarPorValor(String valor) {
        List<Produto> result = new ArrayList<Produto>();
        try {
            String jpql = "FROM Produto WHERE valorUnitario = " + valor;
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Produto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Produto> listar() {
        List<Produto> result = new ArrayList<Produto>();
        try {
            String jpql = "from Produto";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Produto.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }
}
