package br.com.persistence;

import br.com.model.LoteriaModel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.graalvm.compiler.nodes.BreakpointNode;

/**
 * @author Carlo
 */
public class LoteriaDAO {

    public void save(LoteriaModel estoque) throws Exception {
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

    public LoteriaModel find(Integer id) throws Exception {
        EntityManager em = HibernateUtil.getEntityManager();
        LoteriaModel estoque = null;
        try {
            estoque = em.find(LoteriaModel.class, id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception(e);
        } finally {
            em.close();
        }
        return estoque;
    }
    
    public LoteriaModel update(LoteriaModel sModel) throws Exception {
		EntityManager em = HibernateUtil.getEntityManager();
		LoteriaModel estoqueAtualizado = null;
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
			LoteriaModel Funcionario = em.find(LoteriaModel.class, id);
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
    public ArrayList<LoteriaModel> getAll() throws Exception {
        EntityManager em = HibernateUtil.getEntityManager();
        List<LoteriaModel> produtos = new ArrayList<>();
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
        return (ArrayList<LoteriaModel>) produtos;
    }

}
