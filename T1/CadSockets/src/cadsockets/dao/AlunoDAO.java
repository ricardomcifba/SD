/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadsockets.dao;

import cadsockets.Aluno;

/**
 *
 * @author Ricardo
 */
public interface AlunoDAO {
    
    public void save(Aluno aluno) throws Exception;
    public  Aluno find(String nome) throws Exception;
    public void delete (String nome) throws Exception; 
    
}
