/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servers;

import java.util.ArrayList;
import entidades.RMISecundario;

/**
 *
 * @author e127787
 */
public class Servers {
    
    private ArrayList<RMISecundario> servers = new ArrayList<RMISecundario>();

    
    public void addServer(RMISecundario rmiserver){
        servers.add(rmiserver);
    }
    
    public void removeServer(RMISecundario rmiserver){
        servers.remove(rmiserver);
    }
    
    public void eleicao(){
       if(servers.get(0).getId() == 0){// pegar id dos clientes - id = 0 primeiro lider
           
       }
    }
}
