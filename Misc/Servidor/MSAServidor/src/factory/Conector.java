package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    private static Connection con;

    public static Connection getConnection() {
        try {
            String timeserver = "?serverTimezone=America/Sao_Paulo";
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "MeSocorreAe";
            String usuario = "root";
            String senha = "";

            con = DriverManager.getConnection(url + banco + timeserver, usuario, senha);
            return con;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar no Banco de Dados: "
                    + e.getErrorCode() + "-" + e.getMessage() + ".");
            return null;
        }
    }
}
