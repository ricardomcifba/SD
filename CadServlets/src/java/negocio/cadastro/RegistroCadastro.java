/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cadastro;

import negocio.entidade.Aluno;
import negocio.persistencia.AlunoDAO;

/**
 *
 * @author Ricardo
 */
public class RegistroCadastro implements SessaoCadastro {

    public void setAlunodao(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }
    
    private AlunoDAO alunoDAO;

    @Override
    public void addAluno(String nome, String matricula, String curso) throws Exception {
        Aluno aluno = null;
            aluno = new Aluno(nome,matricula,curso);
        this.alunoDAO.save(aluno);
    }

    @Override
    public void removeAluno(String nome) throws Exception {
        alunoDAO.delete(nome);
    }
    
}
