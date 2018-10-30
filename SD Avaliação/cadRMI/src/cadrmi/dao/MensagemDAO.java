/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi.dao;

import cadrmi.Mensagem;

/**
 *
 * @author Ricardo
 */
    public interface MensagemDAO {
    
    public void save(String insert) throws Exception;
    public  Mensagem select(String select) throws Exception;
    public void delete(String delete) throws Exception; 
    
}
