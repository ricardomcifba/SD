/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadsockets;

import cadsocketsi.daosql.AlunoDAOSQL;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Aluno
 */
public class CadastroSessao implements Runnable {

    private Socket cliente;
    private AlunoDAOSQL alunoDAOSQL = new AlunoDAOSQL();
    Aluno a1 = new Aluno();

    public CadastroSessao(Socket cliente) {
        this.cliente = cliente;
    }

    public void save(Aluno aluno) throws Exception {
        alunoDAOSQL.save(aluno);
    }

    public Aluno find(String nome) throws Exception {
        Aluno aluno1 = alunoDAOSQL.find(nome);
        return aluno1;
    }

    public void delete(String nome) throws Exception {
        alunoDAOSQL.delete(nome);
    }

    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream inVar = new DataInputStream(cliente.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                byte op = inVar.readByte();
                System.out.println(op);
                String nome;

                switch (op) {
                    case 1:

                        a1 = (Aluno) in.readObject();
                        this.save(a1);
                        out.writeChars("Inserido com sucesso.");
                        out.flush();
                        inVar.reset();
                        cliente.close();

                        break;
                    case 2:
                        nome = (String) in.readObject();
                        out.writeObject(this.find(nome));
                        out.flush();
                        //inVar.reset();
                        //cliente.close();
                        out.flush();
                        break;
                    case 3:
                        nome = (String) in.readObject();
                        this.delete(nome);
                        out.flush();
                        out.writeChars("Apagado com sucesso.");
                        out.flush();
                        inVar.reset();
                        //cliente.close();
                        out.flush();
                        break;

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
