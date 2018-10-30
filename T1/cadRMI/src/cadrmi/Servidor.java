/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi;

import cadrmi.cadastro.SessaoCadastro;
import cadrmi.daosql.AlunoDAOSQL;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E127787
 */
public class Servidor extends UnicastRemoteObject implements SessaoCadastro {

    int porta;
    String ip;
    // rmi registry for lookup the remote objects.
    Registry registro;    

    // This method is called from the remote client by the RMI.
    // This is the implementation of the “ReceiveMessageInterface”.
    public Servidor(int porta) throws RemoteException {
        this.porta = porta;
        try {
            // get the address of this host.
         ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RemoteException("can't get inet address.");
        }
        //porta = 3231;  // this port(registry’s port)
        System.out.println("IP de endereço do servidor = " + ip + ", port= " + porta);
        try {
            // create the registry and bind the name and object.
            registro = LocateRegistry.createRegistry(porta);
            registro.rebind("rmiServer", this);
        } catch (RemoteException e) {
            throw e;
        }
    }

    /*static public void main(String args[]) {
        try {
            Servidor s = new Servidor();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }*/
    private AlunoDAOSQL alunoDAOSQL = new AlunoDAOSQL();

    @Override
    public void addAluno(Aluno aluno) throws RemoteException {
        try {
            alunoDAOSQL.save(aluno);
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeAluno(String nome) throws RemoteException {
        try {
            alunoDAOSQL.delete(nome);
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Aluno find(String nome) throws RemoteException {
        Aluno aluno = null;
        try {
            aluno = alunoDAOSQL.find(nome);
        } catch (Exception ex) { 
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }    
}
