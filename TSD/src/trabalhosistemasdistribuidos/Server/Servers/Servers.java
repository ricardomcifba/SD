/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosistemasdistribuidos.Server.Servers;

import java.util.ArrayList;
import trabalhosistemasdistribuidos.Server.RMIServer;

/**
 *
 * @author e127787
 */
public class Servers {
    
    private ArrayList<RMIServer> servers = new ArrayList<RMIServer>();
    
    public void addServer(RMIServer rmiserver){
        servers.add(rmiserver);
    }
    
    public void removeServer(RMIServer rmiserver){
        servers.remove(rmiserver);
    }
    
    public void eleicao(){
       
    }
}
