package cadsockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Socket cliente = new Socket("127.0.0.1", 7070);
        DataOutputStream outVar = new DataOutputStream(cliente.getOutputStream());
        ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
        Aluno aluno = new Aluno();
        Scanner ler = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar novo aluno.");
            System.out.println("2 - Procurar um aluno.");
            System.out.println("3 - Remover um aluno.");
            System.out.println("0 - Sair.");
            op = ler.nextInt();
            String name;
            String resposta;
            Aluno retorno = null;

            if (op != 0) {
                switch (op) {
                    case 1:
                        System.out.println("Digite nome do aluno");
                        ler.nextLine();
                        aluno.setNome(ler.nextLine());
                        System.out.println("Digite a matricula do aluno");
                        aluno.setMatricula(ler.nextLine());
                        System.out.println("Digite curso do aluno");
                        aluno.setCurso(ler.nextLine());
                        aluno.toString(aluno);
                        outVar.write(op);
                        outVar.flush();
                        System.out.println(op);
                        System.out.println(aluno.getNome());
                        out.writeObject(aluno);
                        out.flush();
                        resposta = in.readLine();
                        System.out.println(resposta);
                        break;

                    case 2:
                        System.out.println("Digite o nome que você procura");
                        ler.nextLine();
                        name = ler.nextLine();
                        outVar.write(op);//tamanho
                        out.flush();
                        System.out.println(name);
                        out.writeObject(name);
                        out.flush();
                        retorno = (Aluno) in.readObject();
                        System.out.print("Aluno " + retorno.getNome() + " Matricula " + retorno.getMatricula() + " Curso " + retorno.getCurso()+"\n");
                        break;

                    case 3:
                        System.out.println("Digite o nome que você deseja deletar");
                        ler.nextLine();
                        name = ler.nextLine();
                        outVar.write(op);
                        out.flush();
                        out.writeObject(name);
                        resposta = in.readLine();
                        System.out.println(resposta);
                        break;

                    default:
                        System.out.println("Opção inválida!!!!");
                        System.out.println("Selecione uma opção:");
                        System.out.println("1 - Adicionar novo aluno.");
                        System.out.println("2 - Procurar um aluno.");
                        System.out.println("3 - Remover um aluno.");
                        System.out.println("0 - Sair.");
                        op = ler.nextInt();
                }
            }
            
        } while (op != 0);

    }

}
