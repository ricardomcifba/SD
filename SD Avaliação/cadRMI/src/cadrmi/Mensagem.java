/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi;

import java.io.Serializable;

/**
 *
 * @author Ricardo
 */
public class Mensagem implements Serializable {
    
    private int id;
    private String texto;

    public Mensagem(int id, String texto) {
        this.id = id;
        this.texto = texto;
    }

}
