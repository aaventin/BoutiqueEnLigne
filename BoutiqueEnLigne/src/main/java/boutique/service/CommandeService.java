/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.Commande;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CommandeService extends CrudRepository<Commande, Long>{
    
    public List<Commande> findByUtilisateurIdOrderByDateCreationDesc(Long utilId);
    public List<Commande> findByLivree(Boolean livree);
    public List<Commande> findByPayee(Boolean payee);
    
}
