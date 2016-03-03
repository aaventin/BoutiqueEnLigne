/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface UtilisateurService extends CrudRepository<Utilisateur, Long>{
    
    public Utilisateur findByEmailAndMdp(String email, String mdp);
    
}
