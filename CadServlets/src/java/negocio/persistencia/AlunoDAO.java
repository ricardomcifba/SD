/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.persistencia;

import java.util.Collection;
import negocio.entidade.Aluno;

/**
 *
 * @author Ricardo
 */
public interface AlunoDAO {
    
    public void save(Aluno aluno) throws Exception;
    public  Aluno find(String nome) throws Exception;
    public void delete (String nome) throws Exception; 
    
}
