package view;

import controller.TrataClienteController;
import factory.Conector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

public class Principal {

    public static void main(String[] args) {
        Connection con;
        con = Conector.getConnection();

        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor inicializado. Aguardando conexão...");
            ConectaServidor conectaServidor
                    = new ConectaServidor(servidor, con);
            System.out.println("Classe principal executada: "
                    + conectaServidor.toString());
        } catch (IOException e) {
            System.out.println("Erro na classe Principal (main): "
                    + e.getMessage() + ".");
        }
    }
}

class ConectaServidor extends Thread {

    private final ServerSocket servidor;
    private int idUnico;
    private final Connection con;

    public ConectaServidor(ServerSocket servidor, Connection con) {
        this.servidor = servidor;
        this.con = con;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket cliente = this.servidor.accept();
                System.out.println("Um novo cliente conectou: " + cliente.toString() + ".");

                ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                idUnico++;
                System.out.println("Iniciando uma nova Thread para o Cliente: " + idUnico + ".");
                TrataClienteController trataClienteController = new TrataClienteController(cliente, in, out, idUnico);
            }
        } catch (IOException e) {
            System.out.println("ERRO na classe Principal (run): " + e.getMessage() + ".");
        }
    }
}
