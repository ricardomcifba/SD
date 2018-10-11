package entidades;

import blockchain.Block;
import static blockchain.NoobChain.blockchain;
import com.google.gson.GsonBuilder;
import interfaces.Sessao;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class No implements Serializable{
    
    int idNo;
    private Sessao rmiServer;
    Registry registry;
    int rmiPorta;
    String rmiAddress;
    String rmiNome;
    
    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }
    
    
    public No (int id){
       idNo = id; 
    }
    
    public No (int id, int porta, String ip, String nome ){        
        
        Registry registry;
        idNo = id;
        rmiPorta = porta;
        rmiAddress = ip;
        rmiNome = nome;
        
        try {
            // get the “registry” 
            registry = LocateRegistry.getRegistry(
                    rmiAddress,
                    rmiPorta
            );
            // look up the remote object 
            rmiServer = (Sessao) (registry.lookup(rmiNome));
            // chama método remoto
            //rmiServer.insert(m1);//Insere mensagem na base
            System.out.println("Conectato");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public void registrar() {
        
        Mensagem m1 = new Mensagem(1, "Teste de banco");
        Mensagem m2 = new Mensagem(2, "Teste de banco");
        Mensagem m3 = new Mensagem(3, "Teste de banco");
        ArrayList<String> selects = new ArrayList<String>();
        ArrayList<Block> blockchain = new ArrayList<Block>();
        
        String select;
        select = "insert into mensagem(id, mensagem) values (" + m1.getId() +",\" "+m1.getTexto()+"\") ";
        selects.add(select);
        
        
        
        
        System.out.println(select);
        blockchain.add(new Block(select, "0"));
        
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        
        System.out.println(blockchainJson);
        


    }
    
    public static void main (String args[]){        
        
        Scanner ler = new Scanner(System.in);
        No no = new No(1,1234,"localhost", "Teste" );
        int o = 1;
        while(o != 0){
            
            System.out.println("Digite um numero");
            o = ler.nextInt();
            
        }

    }
    
}
