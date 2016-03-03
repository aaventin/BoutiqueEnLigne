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
public class MailServiceMockImpl implements MailService{

    @Override
    public void envoieMail(String emailEmetteur, String emailDestinataire, String titre, String message) {
        System.out.println("******* Mail de "+emailEmetteur+" vers "+emailDestinataire+" - "+titre+" : "+message);
    }
    
    
}
