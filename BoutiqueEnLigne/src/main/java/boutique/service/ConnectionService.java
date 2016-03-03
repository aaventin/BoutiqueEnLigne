/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.Utilisateur;
import boutique.execption.ErreurMotDePasseOuEmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConnectionService {

    @Autowired
    private UtilisateurService utilisateurService;

    public void connection(String email, String mdp) throws ErreurMotDePasseOuEmailException {

        Utilisateur u = utilisateurService.findByEmailAndMdp(email, mdp);

        if (u == null) {
            throw new ErreurMotDePasseOuEmailException();
        }
        u.setConnecte(Boolean.TRUE);
        System.out.println("Bienvenue "+u.getPrenom());

    }

}
