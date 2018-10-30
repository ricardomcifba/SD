package cadsockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PORT = 7070;

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket srv = new ServerSocket(PORT);
            while (true) {
                System.out.println("Servidor Conectado");
                Socket cliente = srv.accept();
                Thread t = new Thread((Runnable) new CadastroSessao(cliente));
                t.start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
