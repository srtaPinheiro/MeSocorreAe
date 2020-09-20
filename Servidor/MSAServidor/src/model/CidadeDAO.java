package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Cidade;

public class CidadeDAO {
    
    private final Connection con;

    public CidadeDAO() {
        this.con = Conector.getConnection();
    }
    
    public ArrayList<Cidade> getListaCidades(int codEstado) {
        Statement stmt;
        ArrayList<Cidade> listaCidades = new ArrayList<>();
        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM cidades "
                    + "WHERE fk_estado = " + codEstado)) {
                while (res.next()) {
                    Cidade cidade = new Cidade(res.getInt("pk_cod"),
                        res.getString("nome"));
                    listaCidades.add(cidade);
                }
            }
            stmt.close();
            con.close();
            return listaCidades;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            return null;
        }
    }
    
    public Cidade getCidadePorCod(int codCidade) {
        Statement stmt;
        Cidade cidade = null;
        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM cidades "
                    + "WHERE pk_cod = " + codCidade)) {
                while (res.next()) {
                    cidade = new Cidade(res.getInt("pk_cod"),
                        res.getString("nome"));
                }
            }
            stmt.close();
            con.close();
            return cidade;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            return null;
        }
    }
    
}
