package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Categoria;

public class CategoriaDAO {
    
    private final Connection con;

    public CategoriaDAO() {
        con = Conector.getConnection();
    }
    
    public ArrayList<Categoria> getListaCategorias(){
        
        Statement stmt;
        ArrayList<Categoria> listaCategorias = new ArrayList<>();

        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM Categorias")) {
                while (res.next()) {
                    Categoria categoria = new Categoria(res.getInt("pk_cod"),
                            res.getString("nome"));
                    listaCategorias.add(categoria);
                }
            }
            stmt.close();
            con.close();
            return listaCategorias;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
        
    }
    
    public ArrayList<Categoria> getListaCategoriasFiltro(String filtro){
        
        Statement stmt;
        ArrayList<Categoria> listaCategorias = new ArrayList<>();

        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM categorias "
                    + "WHERE nome LIKE '%" + filtro + "%'")) {
                while (res.next()) {
                    Categoria categoria = new Categoria(res.getInt("pk_cod"),
                            res.getString("nome"));
                    listaCategorias.add(categoria);
                }
            }
            stmt.close();
            con.close();
            return listaCategorias;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
        
    }
    
    public Categoria getCategoria(int cod){
        
        Statement stmt;
        Categoria categoria = null;

        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT * FROM Categorias "
                    + "WHERE pk_cod = " + cod)) {
                while (res.next()) {
                    categoria = new Categoria(res.getInt("pk_cod"),
                            res.getString("nome"));
                }
            }
            stmt.close();
            con.close();
            return categoria;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
        
    }
    
}
