package view;

import controller.ConexaoController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MeSocorreAeCliente {
    
    public static ConexaoController conexaoController;
    
    public static void main(String[] args) {
        Socket socket;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;
        try {
            socket = new Socket("127.0.0.1", 12345);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Erro de conexão do cliente: "
                    + ex.getMessage() + ".");
        }
        conexaoController = new ConexaoController(in, out);
        formLogin form = new formLogin();
        form.setVisible(true);
    }
    
}
