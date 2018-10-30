/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author E127787
 */
public abstract class GenericDAO {
    
    private static final String URI = "endereco da conexao";
    private static final String USER = "login";	
    private static final String PWD = "senha";
	
    private Connection conn = null;
	
    protected Connection getConnection() throws SQLException{
           
	if(this.conn != null)
            return this.conn;
        DriverManager.registerDriver(new org.postgresql.Driver());
	this.conn = DriverManager.getConnection(URI,USER,PWD);
	return this.conn;
                
    }
    
}
