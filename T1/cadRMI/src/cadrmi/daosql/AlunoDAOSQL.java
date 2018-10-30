/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadrmi.daosql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cadrmi.Aluno;
import cadrmi.dao.AlunoDAO;
import cadrmi.dao.GenericDAO;
import java.sql.SQLException;

/**
 *
 * @author Ricardo
 */
public class AlunoDAOSQL extends GenericDAO implements AlunoDAO {
    
    private static final String INSERT = "insert into aluno(nome, matricula, curso) values (?,?,?)";
    private static final String SELECT = "select nome, matricula, curso from aluno where nome = ?";
    private static final String DELETE = "delete from aluno where nome = ?";

    @Override
    public void save(Aluno aluno) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(AlunoDAOSQL.INSERT);
        pStmt.setString(1, aluno.getNome());
        pStmt.setString(2, aluno.getMatricula());
        pStmt.setString(3, aluno.getCurso());
        pStmt.executeUpdate();
    }

    @Override
    public Aluno find(String nome) throws Exception {
        Aluno aluno= null;
	PreparedStatement pStmt = this.getConnection().prepareStatement(AlunoDAOSQL.SELECT);
        pStmt.setString(1, nome);
        ResultSet rSet = pStmt.executeQuery();
        aluno = this.createAluno(rSet);
        rSet.close();
	pStmt.close();        
        if(aluno==null)
            throw new Exception(nome);
        return aluno;
    }

    @Override
    public void delete(String nome) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(AlunoDAOSQL.DELETE);
        pStmt.setString(1, nome);
        pStmt.executeUpdate();
    }
    
    public Aluno createAluno(ResultSet rSet) throws SQLException{
        Aluno aluno = null;
        if(rSet.next()){
            String nome = rSet.getString(1);
            String matricula = rSet.getString(2);
            String curso = rSet.getString(3);
            aluno = new Aluno(nome,matricula,curso);
        }
        return aluno;
    }
    
}
