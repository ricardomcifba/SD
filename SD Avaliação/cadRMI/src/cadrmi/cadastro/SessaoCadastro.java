/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi.cadastro;
import cadrmi.Mensagem;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ricardo
 */
public interface SessaoCadastro extends Remote {
    
    public void insert(Mensagem msg) throws RemoteException;
    public void remove (String nome) throws RemoteException;
    public Mensagem select(String nome)throws RemoteException;
    
}
