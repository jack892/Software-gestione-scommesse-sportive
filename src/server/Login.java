/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import progettosas.*;

/**
 *
 * @author Michelino
 */
public class Login implements java.io.Serializable{

    private String nome;
    private String password;

    public Login(String nome, String password){
        this.nome=nome;
        this.password=password;
    }

    public String getNome(){
        return nome;
    }

    public String getPassword(){
        return password;
    }
}
