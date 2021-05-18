package br.com.persistence;

import br.com.model.EstoqueModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.graalvm.compiler.nodes.BreakpointNode;

/**
 * @author Carlo
 */
public class EstoqueDAO {

    public void save(EstoqueModel estoque) throws Exception {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(estoque);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
    }

    public EstoqueModel find(Integer id) throws Exception {
        EntityManager em = HibernateUtil.getEntityManager();
        EstoqueModel estoque = null;
        try {
            estoque = em.find(EstoqueModel.class, id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
        return estoque;
    }
    
    public EstoqueModel update(EstoqueModel sModel) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		EstoqueModel estoqueAtualizado = null;
		try {
			em.getTransaction().begin();
			estoqueAtualizado = em.merge(sModel);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}
		return estoqueAtualizado;
	}

	public void delete(Integer id) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			EstoqueModel Funcionario = em.find(EstoqueModel.class, id);
			em.remove(Funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new Exception(e);
		} finally {
			em.close();
		}

	}

    /**
	 * Get all Users
	 * @return
	 */
    @SuppressWarnings("unchecked")
    public ArrayList<EstoqueModel> getAll() throws Exception {
        EntityManager em = HibernateUtil.getEntityManager();
        List<EstoqueModel> produtos = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT c FROM EstoqueModel c");
            produtos = query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro no GetAll:  " + e.getMessage());
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
            
        }
        return (ArrayList<EstoqueModel>) produtos;
    }

}
