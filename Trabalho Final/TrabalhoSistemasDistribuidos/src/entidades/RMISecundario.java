/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import dao.sql.MensagemDAOSQL;
import interfaces.Sessao;
import java.io.Serializable;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e127787
 */
public class RMISecundario extends UnicastRemoteObject  implements Sessao {

    private RMIServer rs;
    private int porta;
    private String ip;
    private Registry registro;    // rmi registry for lookup the remote objects.
    private int id;
    private String nomeServer;
    Scanner ler = new Scanner(System.in);

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Registry getRegistro() {
        return registro;
    }

    public void setRegistro(Registry registro) {
        this.registro = registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RMISecundario(String nome, int id, int porta) throws RemoteException {

        //System.out.println("Digite o nome para o servidor:");
        this.nomeServer = nome;
        this.porta = porta;
        this.id = id;
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
            registro.rebind(nomeServer, this);
        } catch (RemoteException e) {
            throw e;
        }

    }

    public void enviar(Serializable data) {

    }

//    static public void main(String args[]) {
//        Scanner ler = new Scanner(System.in);
//        int id = 1;
//        System.out.println("Digite o numero da porta:");
//        int porta = ler.nextInt();
//        System.out.println("Digite o nome do servidor:");
//        String nome = ler.nextLine();
//        try {
//            RMIServer s = new RMIServer(nome, id, porta);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.exit(1);
//        }
//    }

    private MensagemDAOSQL mensagemDAOSQL = new MensagemDAOSQL();

    @Override
    public void insert(Mensagem mensagem) {

        try {
            mensagemDAOSQL.insert(mensagem);
        } catch (Exception ex) {
            Logger.getLogger(RMISecundario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
