package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Autonomo;
import modelDominio.Cidade;
import modelDominio.Cliente;
import modelDominio.Endereco;
import modelDominio.Estado;
import modelDominio.Servico;

public class ServicoDAO {
    
    private final Connection con;

    public ServicoDAO() {
        this.con = Conector.getConnection();
    }
    
    public ArrayList<Servico> getListaProximosServicos(long codUsu){
        Statement stmt;
        ArrayList<Servico> listaProxServ = new ArrayList<>();
        try {
            stmt = con.createStatement();
            String sql = "SELECT servicos.pk_cod, usuarios.nome, servicos.data_hora_qua " +
                         "    FROM servicos " +
                         "    LEFT OUTER JOIN usuarios ON servicos.fk_cliente = usuarios.pk_cpf " +
                         "    WHERE servicos.data_hora_qua > CURRENT_TIMESTAMP() " +
                         "	AND servicos.situacao = 'A' " +
                         "	AND servicos.fk_autonomo = " + codUsu;
            try (ResultSet res = stmt.executeQuery(sql)) {
                while (res.next()) {
                    Cliente cliente = new Cliente(res.getString("nome"));
                    Servico servico = new Servico(res.getInt("pk_cod"), cliente, 
                            res.getString("data_hora_qua"));
                    listaProxServ.add(servico);
                }
            }
            stmt.close();
            con.close();
            return listaProxServ;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + " " + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Servico> getListaServicos(long codUsu, boolean exibePendentes, 
            boolean exibeAceitos, boolean exibeRecusados, boolean exibeConcluidos){
        PreparedStatement stmt = null;
        ArrayList<Servico> listaServicos = new ArrayList<>();
        
        String situacoes = "";
        if (exibePendentes) {
            if (!situacoes.equals("")) {
                situacoes = situacoes + ",";
            }
            situacoes = situacoes + "'E'";
        }
        if (exibeAceitos) {
            if (!situacoes.equals("")) {
                situacoes = situacoes + ",";
            }
            situacoes = situacoes + "'A'";
        }
        if (exibeRecusados) {
            if (!situacoes.equals("")) {
                situacoes = situacoes + ",";
            }
            situacoes = situacoes + "'N'";
        }
        if (exibeConcluidos) {
            if (!situacoes.equals("")) {
                situacoes = situacoes + ",";
            }
            situacoes = situacoes + "'C'";
        }
        if (situacoes.equals("")) {
            situacoes = "NULL";
        }
        
        try {
            String sql = "SELECT servicos.pk_cod, servicos.data_hora_qua, servicos.data_hora_reg, usuarios.nome, servicos.situacao " +
                         "FROM servicos " +
                         "LEFT JOIN usuarios ON servicos.fk_cliente = usuarios.pk_cpf " +
                         "WHERE servicos.situacao IN (" + situacoes + ") " +
                         "AND servicos.fk_autonomo = ? " +
                         "ORDER BY data_hora_reg DESC;";
            
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, codUsu);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    Cliente cliente = new Cliente(res.getString("nome"));
                    Servico servico = new Servico(res.getInt("pk_cod"), res.getString("situacao").charAt(0), 
                            cliente, res.getString("data_hora_reg"), res.getString("data_hora_qua"));
                    listaServicos.add(servico);
                }
            }
            stmt.close();
            con.close();
            return listaServicos;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public int inserirServico(Servico servico){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "INSERT INTO servicos(situacao, descricao, fk_cliente, "
                        + "fk_autonomo, data_hora_qua) VALUES (?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "E");
                stmt.setString(2, servico.getDescricao());
                stmt.setLong(3, servico.getCliente().getCpf());
                stmt.setLong(4, servico.getAutonomo().getCpf());
                stmt.setString(5, servico.getDataHoraQua());
                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException er) {
                    return er.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    public ArrayList<Servico> getAvaliacoesAutonomo(long codUsu){
        PreparedStatement stmt;
        ArrayList<Servico> listaAvalicacoes = new ArrayList<>();
        try {
            String sql = "SELECT usuarios.foto_perfil AS foto_perfil, usuarios.nome AS nome, servicos.opiniao AS opiniao, servicos.nota AS nota " +
                         "FROM servicos " +
                         "LEFT JOIN usuarios ON servicos.fk_cliente = usuarios.pk_cpf " +
                         "WHERE fk_autonomo = ? AND situacao = ? " +
                         "ORDER BY data_hora_reg DESC " +
                         "LIMIT 5;";
            
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, codUsu);
            stmt.setString(2, "C");
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    Cliente cliente = new Cliente(res.getString("nome"), res.getBytes("foto_perfil"));
                    Servico servico = new Servico(cliente, res.getInt("nota"), res.getString("opiniao"));
                    listaAvalicacoes.add(servico);
                }
            }
            stmt.close();
            con.close();
            return listaAvalicacoes;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Servico> getListaPedidosCliente(long codUsu){
        PreparedStatement stmt;
        ArrayList<Servico> listaPedidos = new ArrayList<>();
        try {
            String sql = "SELECT servicos.pk_cod AS cod, servicos.situacao AS situacao, servicos.data_hora_qua AS quando, usuarios.nome AS nome, usuarios.foto_perfil AS foto " +
                         "FROM servicos " +
                         "LEFT JOIN usuarios ON servicos.fk_autonomo = usuarios.pk_cpf " +
                         "WHERE fk_cliente = ? " +
                         "ORDER BY data_hora_reg DESC;";
            
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, codUsu);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    Autonomo autonomo = new Autonomo(res.getString("nome"), res.getBytes("foto"));
                    Servico servico = new Servico(res.getInt("cod"), res.getString("situacao").charAt(0), autonomo, res.getString("quando"));
                    listaPedidos.add(servico);
                }
            }
            stmt.close();
            con.close();
            return listaPedidos;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public Servico getServico(int codSer) {
        PreparedStatement stmt;
        Servico servico = null;
        try {
            String sql = "SELECT UsuTab1.pk_cpf AS autonomo_cpf, UsuTab1.nome AS autonomo_nome, UsuTab1.foto_perfil AS autonomo_foto, " +
                "	UsuTab2.pk_cpf AS cliente_cpf, UsuTab2.nome AS cliente_nome, UsuTab2.end_rua AS cliente_end_rua, "
                    + "UsuTab2.end_numero AS cliente_end_numero, UsuTab2.end_bairro AS cliente_end_bairro, Cidades.pk_cod AS cliente_end_cidade_id, "
                    + "Cidades.nome AS cliente_end_cidade, Estados.pk_cod AS cliente_end_estado_id, Estados.nome AS cliente_end_estado, "
                    + "Estados.uf AS cliente_end_estado_uf, UsuTab2.end_cep AS cliente_end_cep, " +
                "    servicos.situacao AS servico_situacao, Servicos.descricao AS servico_descricao, Servicos.resposta AS servico_resposta, "
                    + "Servicos.preco AS servico_preco, Servicos.data_hora_qua AS servico_data_quando, Servicos.nota AS servico_nota, "
                    + "Servicos.opiniao AS servico_opiniao " +
                "FROM Servicos " +
                "LEFT JOIN Usuarios AS UsuTab1 ON UsuTab1.pk_cpf = Servicos.fk_autonomo " +
                "LEFT JOIN Usuarios AS UsuTab2 ON UsuTab2.pk_cpf = Servicos.fk_cliente " +
                "LEFT JOIN Cidades ON UsuTab2.fk_cidade = Cidades.pk_cod " +
                "LEFT JOIN Estados ON Cidades.fk_estado = Estados.pk_cod " +
                "WHERE Servicos.pk_cod = ?;";
            
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, codSer);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    Autonomo autonomo = new Autonomo(res.getLong("autonomo_cpf"), res.getString("autonomo_nome"), res.getBytes("autonomo_foto"));
                    Estado estado = new Estado(res.getInt("cliente_end_estado_id"), res.getString("cliente_end_estado"), res.getString("cliente_end_estado_uf"));
                    Cidade cidade = new Cidade(res.getInt("cliente_end_cidade_id"), res.getString("cliente_end_cidade"), estado);
                    Endereco endereco = new Endereco(res.getString("cliente_end_rua"), res.getInt("cliente_end_numero"), res.getString("cliente_end_bairro"), null, cidade, res.getInt("cliente_end_cep"));
                    Cliente cliente = new Cliente(res.getLong("cliente_cpf"), res.getString("cliente_nome"), endereco);
                    servico = new Servico(codSer, res.getString("servico_situacao").charAt(0), res.getString("servico_descricao"), cliente, autonomo, res.getDouble("servico_preco"), 
                            null, res.getString("servico_data_quando"), res.getString("servico_opiniao"), res.getInt("servico_nota"), res.getString("servico_resposta"));
                }
            }
            stmt.close();
            con.close();
            return servico;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public int aceitarServico(int codSer, double preco, String resposta) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "UPDATE servicos SET " +
                        "    servicos.situacao = 'A', " +
                        "    servicos.resposta = ?, " +
                        "    servicos.preco = ? " +
                        "WHERE servicos.pk_cod = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, resposta);
                stmt.setDouble(2, preco);
                stmt.setInt(3, codSer);
                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException er) {
                    return er.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    public int recusarServico(int codSer, String resposta) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "UPDATE servicos SET " +
                        "    servicos.situacao = 'N', " +
                        "    servicos.resposta = ? " +
                        "WHERE servicos.pk_cod = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, resposta);
                stmt.setInt(2, codSer);
                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException er) {
                    return er.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    public int darFeedback(int codSer, int nota, String avaliacao) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "UPDATE servicos SET " +
                        "    servicos.situacao = 'C', " +
                        "    servicos.nota = ?, " +
                        "    servicos.opiniao = ? " +
                        "WHERE servicos.pk_cod = ?";
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, nota);
                stmt.setString(2, avaliacao);
                stmt.setInt(3, codSer);
                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException er) {
                    return er.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
}
