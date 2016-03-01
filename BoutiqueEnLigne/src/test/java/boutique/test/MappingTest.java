/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.test;

import boutique.entity.Utilisateur;
import boutique.service.UtilisateurService;
import boutique.spring.SpringConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
    @Test
    public void test(){
        
//        Utilisateur u = new Utilisateur();
//        u.setNom("BlaBla");
//        utilisateurService.save(u);
        
//        for (Utilisateur u : utilisateurService.findAll()){
//            System.out.println(u);
        }
    }
    
    
   

