/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi;

import cadrmi.cadastro.SessaoCadastro;
import java.net.InetAddress;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author E127787
 */
public class Cliente {
        SessaoCadastro rmiServer;
        
    public Cliente(String server, int porta) {
        
        Registry registry;
        String serverAddress = server;
        int serverPort = porta;
        
        try {
            registry = LocateRegistry.getRegistry(
                    serverAddress,
                    serverPort
            );
            rmiServer = (SessaoCadastro) (registry.lookup("rmiServer"));
            
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
    
    public void inserir(Mensagem msg) throws RemoteException{
        rmiServer.insert(msg);
    }
    
    public void delete(String delete) throws RemoteException{
        rmiServer.remove(delete);
    }
    
    public Mensagem select(String select) throws RemoteException{
        return rmiServer.select(select);
    }
    
}
