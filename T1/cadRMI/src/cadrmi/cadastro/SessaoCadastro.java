/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi.cadastro;
import cadrmi.Aluno;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ricardo
 */
public interface SessaoCadastro extends Remote {
    
    public void addAluno(Aluno aluno) throws RemoteException;
    public void removeAluno (String nome) throws RemoteException;
    public Aluno find(String nome)throws RemoteException;
    
}
