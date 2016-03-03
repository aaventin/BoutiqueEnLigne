/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.Utilisateur;
import boutique.enumeration.TypeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {

    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private MailService mailService;
    
    @Autowired
    private ConfigurationService configurationService;

    public void inscription(TypeUtil typeUtil, String email, String mdp, String adresse,
            String codePostal, String ville, String telephone, String nom, String prenom) {

        Utilisateur u = new Utilisateur(typeUtil, email, mdp, adresse, codePostal, ville, telephone, nom, prenom);
        
          utilisateurService.save(u);  
          
          mailService.envoieMail(configurationService.getEmailBoutiqueEnLigne(), email, "Validation inscription", "Votre inscription a bien été prise en compte, bienvenue su BoutiqueEnLigne");
        
        
    }

}
