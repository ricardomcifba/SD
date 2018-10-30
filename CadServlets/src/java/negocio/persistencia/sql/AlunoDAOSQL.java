/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.persistencia.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import negocio.entidade.Aluno;
import negocio.persistencia.AlunoDAO;
import negocio.persistencia.GenericDAO;

/**
 *
 * @author Ricardo
 */
public class AlunoDAOSQL extends GenericDAO implements AlunoDAO {
    
    private static final String INSERT = "insert into aluno(nome, matricula, curso) values (?,?,?)";
    private static final String SELECT = "select nome, matricula, curso from aluno";
    private static final String DELETE = "delete from aluno where nome = ?";

    @Override
    public void save(Aluno aluno) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(INSERT);
        pStmt.setString(1, aluno.getNome());
        pStmt.setString(2, aluno.getMatricula());
        pStmt.setString(3, aluno.getCurso());
        pStmt.executeUpdate();
    }

    @Override
    public Aluno find(String nome) throws Exception {
        
	Aluno aluno= null;
	PreparedStatement pStmt = this.getConnection().prepareStatement(SELECT);
        pStmt.setString(1, nome);
        ResultSet rSet = pStmt.executeQuery();
        rSet.close();
	pStmt.close();        
        if(aluno==null)
            throw new Exception(nome);
        return aluno;
    }

    @Override
    public void delete(String nome) throws Exception {
        PreparedStatement pStmt = this.getConnection().prepareStatement(DELETE);
        pStmt.setString(1, nome);
        pStmt.executeQuery();
    }
    
}
