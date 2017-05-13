package persistence;

import model.entidades.Cliente;
import model.entidades.Cliente;
import utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedro on 14/04/17.
 */
public class ClienteDao {
    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("gve-persistence");
    private EntityManager em = emf.createEntityManager();

    public void adicionar(Cliente cliente) {
        try {
            em.getTransaction().begin();

            em.persist(cliente);

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

    public void remover(Cliente cliente) {
        em.getTransaction().begin();
        em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
        em.getTransaction().commit();
    }

    public List<Cliente> pesquisarPorCodigo(String codigo) {
        List<Cliente> result = new ArrayList<Cliente>();
        try {
            String jpql = "FROM Cliente WHERE codigo = " + codigo;
            return JpaUtil.getEntityManager()
                        .createQuery(jpql, Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Cliente> pesquisarPorNomeEstabelecimento(String nome) {
        List<Cliente> result = new ArrayList<Cliente>();
        try {
            String jpql = "FROM Cliente WHERE nomeEstabelecimento LIKE '%" + nome + "%'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Cliente> pesquisarPorEndereco(String endereco) {
        List<Cliente> result = new ArrayList<Cliente>();
        try {
            String jpql = "FROM Cliente WHERE endereco LIKE '%" + endereco + "%'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Cliente> pesquisarPorTelefone(String telefone) {
        List<Cliente> result = new ArrayList<Cliente>();
        try {
            String jpql = "FROM Cliente WHERE telefone LIKE '%" + telefone + "%'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Cliente> pesquisarPorResponsavel(String responsavel) {
        List<Cliente> result = new ArrayList<Cliente>();
        try {
            String jpql = "FROM Cliente WHERE responsavel LIKE '%" + responsavel + "%'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public List<Cliente> listar() {
        List<Cliente> result = new ArrayList<Cliente>();
        try {
            String jpql = "from Cliente";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Cliente.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }
}
