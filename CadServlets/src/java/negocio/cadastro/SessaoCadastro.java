/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cadastro;

/**
 *
 * @author Ricardo
 */
public interface SessaoCadastro {
    
    public void addAluno(String nome, String matricula, String curso) throws Exception;
    public void removeAluno (String nome) throws Exception;
    
}
