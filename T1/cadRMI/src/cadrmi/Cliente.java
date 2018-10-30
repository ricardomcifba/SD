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
        //String text="Rick";
        //Aluno a1 = new Aluno("Ricardo", "123", "ads");
        //String nome = "Ricardo";

        //System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
        try {
            // get the “registry” 
            registry = LocateRegistry.getRegistry(
                    serverAddress,
                    serverPort
            );
            // look up the remote object 
            rmiServer = (SessaoCadastro) (registry.lookup("rmiServer"));
            // call the remote method
            //rmiServer.addAluno(a1);//Adiciona A,luno
            //rmiServer.find(nome);// Procura pelo nome
            //rmiServer.removeAluno(nome); //remove aluno pelo nome
            
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
    
    public void Cadastrar(Aluno aluno) throws RemoteException{
        rmiServer.addAluno(aluno);
    }
    
    public void apagar(String nome) throws RemoteException{
        rmiServer.removeAluno(nome);
    }
    
    public Aluno procurar(String nome) throws RemoteException{
        return rmiServer.find(nome);
    }

    /*static public void main(String args[]) throws NotBoundException, Exception
    {
       SessaoCadastro rmiServer;
       Registry registry;
       String serverAddress="localhost";
       int serverPort=3231;
       String text="Rick";
       Aluno a1 = new Aluno("Ricardo", "123", "ads");
       String nome = "Ricardo";
       
       System.out.println("sending "+text+" to "+serverAddress+":"+serverPort);
       try{
           // get the “registry” 
           registry=LocateRegistry.getRegistry(
               serverAddress,
               serverPort
           );
           // look up the remote object 
           rmiServer = (SessaoCadastro)(registry.lookup("rmiServer"));
           // call the remote method
           //rmiServer.addAluno(a1);//Adiciona A,luno
           rmiServer.find(nome);// Procura pelo nome
           //System.out.println(a2.getMatricula()+a2.getMatricula()+a2.getCurso());
           //rmiServer.removeAluno(nome); //remove aluno pelo nome
           
       }
       catch(RemoteException e){
           e.printStackTrace();
       }
       catch(NotBoundException e){
           e.printStackTrace();
       }
    }*/
}
