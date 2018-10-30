/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import negocio.entidade.Aluno;
import negocio.persistencia.sql.AlunoDAOSQL;

/**
 *
 * @author Ricardo
 */
@Named(value = "alunoManagedBean")
@Dependent
public class AlunoManagedBean {

    private AlunoDAOSQL inserir;
    private ArrayList <Aluno> consultar;
    private AlunoDAOSQL apagar;
    
    
    public AlunoManagedBean() {
        inserir = new AlunoDAOSQL();
        consultar = new ArrayList<Aluno>();
        apagar = new AlunoDAOSQL();
    }
    
        public void insereAluno(){
        
        FacesContext  context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Remedio Adicionado!", ""));
        
    }
    
    public void apagaAluno(){
        
        FacesContext  context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Remedio Vendido!", ""));
    }
    
}
