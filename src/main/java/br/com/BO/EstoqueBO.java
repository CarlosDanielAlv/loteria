package br.com.BO;

import br.com.model.EstoqueModel;
import br.com.persistence.EstoqueDAO;
import java.util.List;

/**
 * @author Carlo
 */
public class EstoqueBO {
    
    public EstoqueModel find(Integer id) throws Exception {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        
        return estoqueDAO.find(id);
    }
    
    public void save(EstoqueModel estoque) throws Exception {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        
        estoqueDAO.save(estoque);
    }
    
    public List<EstoqueModel> getAll() throws Exception {
        EstoqueDAO estoqueDAO = new EstoqueDAO();
        
        return estoqueDAO.getAll();
    }
    
}
