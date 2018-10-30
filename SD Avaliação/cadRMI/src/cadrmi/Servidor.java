/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi;

import cadrmi.cadastro.SessaoCadastro;
import cadrmi.dao.MensagemDAO;
import cadrmi.daosql.MensagemDAOSQL;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
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
public class Servidor extends UnicastRemoteObject {

    int porta;
    String ip;
    Registry registro;    // rmi registry for lookup the remote objects.

    private MensagemDAOSQL msgalunoDAOSQL = new MensagemDAOSQL();

        public Servidor(int porta) throws RemoteException {
        this.porta = porta;
        try {

            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            throw new RemoteException("can't get inet address.");
        }

        System.out.println("IP de endereço do servidor = " + ip + ", port= " + porta);
        try {

            registro = LocateRegistry.createRegistry(porta);
            registro.rebind("rmiServer", this);
        } catch (RemoteException e) {
            throw e;
        }
    }

}
