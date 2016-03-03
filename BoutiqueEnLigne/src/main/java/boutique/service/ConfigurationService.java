/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigurationService {
    
    private String emailBoutiqueEnLigne= "BoutiqueEnLigne.com";

    public String getEmailBoutiqueEnLigne() {
        return emailBoutiqueEnLigne;
    }

    public void setEmailBoutiqueEnLigne(String emailBoutiqueEnLigne) {
        this.emailBoutiqueEnLigne = emailBoutiqueEnLigne;
    }
    
}
