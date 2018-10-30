/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosistemasdistribuidos.Server;

import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author e127787
 */
public class RMIServer implements Remote {
    
    int porta;
    String ip;
    Registry registro;    // rmi registry for lookup the remote objects.

    public RMIServer(int porta) throws RemoteException {
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
        
        /*static public void main(String args[]) {
        try {
            Servidor s = new Servidor();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }*/
    }
    
}
