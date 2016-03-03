/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.test;

import boutique.entity.Utilisateur;
import boutique.enumeration.TypeUtil;
import boutique.service.ConnectionService;
import boutique.service.InscriptionService;
import boutique.service.UtilisateurService;
import boutique.spring.SpringConfig;
import java.sql.Connection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class MappingTest {

    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    InscriptionService inscriptionService;
    
    @Autowired
    ConnectionService connectionService;

//    @Test
    public void test() {

        Utilisateur u = new Utilisateur();
        u.setNom("BlaBla");
        u.setEmail("agathe");
        u.setMdp("agathe");
        utilisateurService.save(u);

        Utilisateur admin = new Utilisateur();
        u.setNom("admin");
        u.setEmail("admin");
        u.setMdp("admin");
        u.setTypeUtil(TypeUtil.Administrateur);
        utilisateurService.save(u);

        Utilisateur u5 = utilisateurService.findByEmailAndMdp("agathe", "agath");
        Assert.assertTrue(u5 == null);
//        System.out.println(utilisateurService.findByEmailAndMdp("agathe", "agath").getNom());

//        for (Utilisateur u : utilisateurService.findAll()){
//            System.out.println(u);
    }

    @Test
    public void inscriptionTestOk(){
      inscriptionService.inscription(TypeUtil.Client, "email", "mdp", "adresse", "33000", "ville", "telephone", "nom", "prenom");
        
    }
}
