/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.SousCommande;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface SousCommandeService extends CrudRepository<SousCommande, Long>{
    
    public List<SousCommande> findByCommandeId(Long cmdId);
    
}
