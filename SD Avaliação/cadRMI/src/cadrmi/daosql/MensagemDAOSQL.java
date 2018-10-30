/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi.daosql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cadrmi.Mensagem;
import cadrmi.dao.MensagemDAO;
import cadrmi.dao.GenericDAO;
import java.sql.SQLException;

/**
 *
 * @author Ricardo
 */
public class MensagemDAOSQL extends GenericDAO implements MensagemDAO {
    
    private static final String INSERT = "insert into aluno(nome, matricula, curso) values (?,?,?)";
    private static final String SELECT = "select nome, matricula, curso from aluno where nome = ?";
    private static final String DELETE = "delete from aluno where nome = ?";

    @Override
    public void save(String insert) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(MensagemDAOSQL.INSERT);
        pStmt.setString(1, insert);

        pStmt.executeUpdate();
    }

    @Override
    public Mensagem select(String nome) throws Exception {
        Mensagem aluno= null;
	PreparedStatement pStmt = this.getConnection().prepareStatement(MensagemDAOSQL.SELECT);
        pStmt.setString(1, nome);
        ResultSet rSet = pStmt.executeQuery();
        //aluno = this.createAluno(rSet);
        rSet.close();
	pStmt.close();        
        if(aluno==null)
            throw new Exception(nome);
        return aluno;
    }

    @Override
    public void delete(String delete) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(MensagemDAOSQL.DELETE);
        pStmt.setString(1, delete);
        pStmt.executeUpdate();
    }
    
    public Mensagem createMensagem(ResultSet rSet) throws SQLException{
        Mensagem aluno = null;
        if(rSet.next()){
            String texto = rSet.getString(1);
            int id = rSet.getInt(2);
            //String curso = rSet.getString(3);
            aluno = new Mensagem(id, texto);
        }
        return aluno;
    }
    
}
