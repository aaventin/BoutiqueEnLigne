/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.Article;
import boutique.entity.Commande;
import boutique.entity.SousCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class GestionPanierService {

    @Autowired
    private PaiementService paiementService;

    @Autowired
    private SousCommandeService sousCommandeService;

    public void ajouterArticle(Article a, Commande cmd, Integer quantite) {

        //Vérifie que la cmd n'est pas payéé
        if (cmd.getPayee() == false) {
            //Parcours la commande
            for (SousCommande sscmd : cmd.getSousCommandes()) {
                //Si l'article existe déjà dans la cmd set la quantité (+)
                if (sscmd.getArticle() == a) {
                    sscmd.setQuantite(sscmd.getQuantite() + quantite);
                    sousCommandeService.save(sscmd);
                    paiementService.mAjPrixTotal(cmd);
                }
                //Si l'article n'existe pas dans la cmd crée une nouvelle sousCommande
                cmd.getSousCommandes().add(new SousCommande(a, cmd, quantite));
                sousCommandeService.save(sscmd);
                paiementService.mAjPrixTotal(cmd);
            }
        }
        return;
    }

    public void supprimerArticle(Article a, SousCommande sscmd, Integer quantite) {

        //Vérifie que la cmd n'est pas payéé
        if (sscmd.getCommande().getPayee() == false) {

            //Supprime la sousComande si elle est vide après suppression d'article 
            if ((sscmd.getQuantite() - quantite) <= 0) {
                sousCommandeService.delete(sscmd);
                paiementService.mAjPrixTotal(sscmd.getCommande());
            }
            //Supprime n article
            sscmd.setQuantite(sscmd.getQuantite() - quantite);
            sousCommandeService.save(sscmd);
            paiementService.mAjPrixTotal(sscmd.getCommande());

        }

        return;

    }

}
