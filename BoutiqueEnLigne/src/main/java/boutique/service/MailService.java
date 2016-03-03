/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.service;

/**
 *
 * @author admin
 */
public interface MailService {
    
    public void envoieMail(String emailEmetteur, String emailDestinataire, String titre, String message);
    
}
