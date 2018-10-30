package cadsockets;

import cadsocketsi.daosql.AlunoDAOSQL;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class Aluno implements Serializable{

    private static final long serialVersionUID = 1L;
    private AlunoDAOSQL alunoDAOSQL = new AlunoDAOSQL();
    
    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }
    
    public Aluno(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    private String nome;
    private String matricula;
    private String curso;
    
    public void toString(Aluno aluno){
        System.out.println("aluno: "+aluno.getNome()+ " matricula: "+ aluno.getMatricula() + " curso: "+aluno.getCurso());
    }

}
