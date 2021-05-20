package br.com.BO;

import br.com.model.LoteriaModel;
import br.com.persistence.LoteriaDAO;
import java.util.List;

/**
 * @author Carlo
 */
public class LoteriaBO {
    
    public LoteriaModel find(Integer id) throws Exception {
        LoteriaDAO ldao = new LoteriaDAO();
        
        return ldao.find(id);
    }
    
    public void save(LoteriaModel estoque) throws Exception {
        LoteriaDAO ldao = new LoteriaDAO();
        
        ldao.save(estoque);
    }
    
    public List<LoteriaModel> getAll() throws Exception {
        LoteriaDAO ldao = new LoteriaDAO();
        
        return ldao.getAll();
    }
    
    public void delete(Integer id) throws Exception {
        LoteriaDAO ldao = new LoteriaDAO();
        
        ldao.delete(id);
    }
    
    public LoteriaModel update(LoteriaModel sModel) throws Exception {
        LoteriaDAO ldao = new LoteriaDAO();
        
        
        return ldao.update(sModel);
    }
    
}
