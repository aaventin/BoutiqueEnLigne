/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

import boutique.entity.Article;
import boutique.entity.CodePromo;
import boutique.entity.Commande;
import boutique.entity.SousCommande;
import boutique.enumeration.TypeCodePromo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PaiementService {

    @Autowired
    CommandeService commandeService;

    @Autowired
    CodePromoService codePromoService;

    @Autowired
    ArticleService articleService;

    public void mAjPrixTotal(Commande cmd) {

        Double total = 0.0;

        for (SousCommande sscmd : cmd.getSousCommandes()) {
            total = total + (sscmd.getArticle().getPrix() * sscmd.getQuantite());
        }

        cmd.setPrixTotal(total);
    }

    public Double calculPrixTotalCodePromo(String code, Commande cmd) {
        CodePromo codePromo = codePromoService.findByCode(code);
        Double reduction = 0.0;
        Double prixTotal = 0.0;

        //Si le code promo n'existe pas calcul du total sans remise
        if (codePromo == null) {
            System.out.println("Code Promo invalide");
            mAjPrixTotal(cmd);
        }
        //Calculs de la réduction selonn le typeCodePromo : Poucentage, Remise
        if (codePromo.getTypeCodePromo() == TypeCodePromo.Pourcentage) {
            mAjPrixTotal(cmd);
            reduction = cmd.getPrixTotal() * (codePromo.getValeur() / 100);
        }

        if (codePromo.getTypeCodePromo() == TypeCodePromo.Remise) {
            mAjPrixTotal(cmd);
            reduction = codePromo.getValeur();
        }

        return prixTotal = cmd.getPrixTotal() - reduction;

    }

    public void payerCommande(Commande cmd) {
        cmd.setPayee(Boolean.TRUE);

        //Mise à jour du stock article
        for (SousCommande sscmd : cmd.getSousCommandes()) {
            Article a = sscmd.getArticle();
            a.setStock(a.getStock() - sscmd.getQuantite());
            articleService.save(a);

        }
    }

}
