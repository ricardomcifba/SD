package cadsockets;

import cadsocketsi.daosql.AlunoDAOSQL;
import java.io.DataInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PORT = 7070;
    private AlunoDAOSQL alunoDAOSQL = new AlunoDAOSQL();
    Aluno a1 = new Aluno();

    public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
        new Servidor().run();

    }

    public void run() throws IOException, ClassNotFoundException, Exception {
        ServerSocket srv = new ServerSocket(PORT);
        System.out.println("Servidor Conectado");
        while (true) {
            Socket cliente = srv.accept();
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
                    inVar.close();
                    cliente.close();
                    break;
                case 2:
                    nome = (String) in.readObject();
                    out.writeObject(this.find(nome));
                    out.flush();
                    inVar.close();
                    cliente.close();
                    out.flush();
                    break;
                case 3:
                    nome = (String) in.readObject();
                    this.delete(nome);
                    out.flush();
                    out.writeChars("Apagado com sucesso.");
                    out.flush();
                    inVar.close();
                    cliente.close();
                    out.flush();
                    break;

            }

        }
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

}
