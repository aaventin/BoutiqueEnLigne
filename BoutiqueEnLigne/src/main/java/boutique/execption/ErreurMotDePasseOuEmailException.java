/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutique.execption;

/**
 *
 * @author admin
 */
public class ErreurMotDePasseOuEmailException extends Exception {

    /**
     * Creates a new instance of <code>ErreurMotDePasseOuEmailException</code>
     * without detail message.
     */
    public ErreurMotDePasseOuEmailException() {
    }

    /**
     * Constructs an instance of <code>ErreurMotDePasseOuEmailException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ErreurMotDePasseOuEmailException(String msg) {
        super(msg);
    }
}
