package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Estado;

public class EstadoDAO {
    
    private final Connection con;

    public EstadoDAO() {
        this.con = Conector.getConnection();
    }
    
    public ArrayList<Estado> getListaEstados() {
        Statement stmt;
        ArrayList<Estado> listaEstados = new ArrayList<>();
        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM estados")) {
                while (res.next()) {
                    Estado estado = new Estado(res.getInt("pk_cod"),
                        res.getString("nome"), res.getString("uf"));
                    listaEstados.add(estado);
                }
            }
            stmt.close();
            con.close();
            return listaEstados;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            return null;
        }
    }
    
    public Estado getEstadoPorCod(int codEstado){
        Statement stmt;
        Estado estado = null;
        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM estados "
                    + "WHERE pk_cod = " + codEstado)) {
                while (res.next()) {
                    estado = new Estado(res.getInt("pk_cod"),
                        res.getString("nome"), res.getString("uf"));
                }
            }
            stmt.close();
            con.close();
            return estado;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            return null;
        }
    }
    
}