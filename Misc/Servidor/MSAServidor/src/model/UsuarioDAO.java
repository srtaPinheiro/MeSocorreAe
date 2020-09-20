package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Autonomo;
import modelDominio.Categoria;
import modelDominio.Cidade;
import modelDominio.Cliente;
import modelDominio.Endereco;
import modelDominio.Estado;
import modelDominio.Servico;
import modelDominio.Usuario;

public class UsuarioDAO {
    
    private final Connection con;

    public UsuarioDAO() {
        this.con = Conector.getConnection();
    }
    
    public int inserirAutonomo(Autonomo autonomo){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "INSERT INTO usuarios (pk_cpf, email, tipo, status, "
                        + "nome, senha, data_nasc, telefone, fk_cidade, end_rua, "
                        + "end_numero, end_bairro, end_complemento, end_cep) " +
                        "VALUES (?, ?, 'A', 'I', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setLong(1, autonomo.getCpf());
                stmt.setString(2, autonomo.getEmail());
                stmt.setString(3, autonomo.getNome());
                stmt.setString(4, autonomo.getSenha());
                stmt.setString(5, autonomo.getDataNasc());
                stmt.setLong(6, autonomo.getTelefone());
                stmt.setInt(7, autonomo.getEndereco().getCidade().getId());
                stmt.setString(8, autonomo.getEndereco().getRua());
                stmt.setInt(9, autonomo.getEndereco().getNumero());
                stmt.setString(10, autonomo.getEndereco().getBairro());
                stmt.setString(11, autonomo.getEndereco().getComplemento());
                stmt.setInt(12, autonomo.getEndereco().getCep());
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
    
    public int alterarAutonomo(Autonomo autonomo){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "UPDATE usuarios " +
                        "SET email = ?, " +
                        "status = ?, " +
                        "fk_categoria = ?, " +
                        "nome = ?, " +
                        "senha = ?, " +
                        "telefone = ?, " +
                        "fk_cidade = ?, " +
                        "end_rua = ?, " +
                        "end_numero = ?, " +
                        "end_bairro = ?, " +
                        "end_complemento = ?, " +
                        "end_cep = ?, " +
                        "descricao = ?, " +
                        "foto_perfil = ? " +
                        "WHERE pk_cpf = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, autonomo.getEmail());
                stmt.setString(2, autonomo.getStatus());
                stmt.setInt(3, autonomo.getCategoria().getId());
                stmt.setString(4, autonomo.getNome());
                stmt.setString(5, autonomo.getSenha());
                stmt.setLong(6, autonomo.getTelefone());
                stmt.setInt(7, autonomo.getEndereco().getCidade().getId());
                stmt.setString(8, autonomo.getEndereco().getRua());
                stmt.setInt(9, autonomo.getEndereco().getNumero());
                stmt.setString(10, autonomo.getEndereco().getBairro());
                stmt.setString(11, autonomo.getEndereco().getComplemento());
                stmt.setInt(12, autonomo.getEndereco().getCep());
                stmt.setString(13, autonomo.getDescricao());
                stmt.setBytes(14, autonomo.getFoto());
                stmt.setLong(15, autonomo.getCpf());
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
    
    public int excluirAutonomo(Autonomo autonomo) {
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "DELETE FROM usuarios " +
                        "WHERE pk_cpf = ?";
                stmt = con.prepareStatement(sql);
                stmt.setLong(1, autonomo.getCpf());
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
    
    public ArrayList<Autonomo> getListaAutonomos(int codCat, long codUsu){
        PreparedStatement stmt;
        ArrayList<Autonomo> listaAutonomos = new ArrayList<>();
        try {
            String sql = "SELECT usuarios.pk_cpf AS cpf, usuarios.nome AS nome, usuarios.foto_perfil AS foto, TRUNCATE(AVG(servicos.nota),2) AS media " +
                         "FROM usuarios " +
                         "LEFT JOIN servicos ON servicos.fk_autonomo = usuarios.pk_cpf " +
                         "WHERE usuarios.tipo = ? AND usuarios.status = ? AND usuarios.fk_categoria = ? " +
                         "AND usuarios.end_cep = (SELECT usuarios.end_cep FROM usuarios WHERE usuarios.pk_cpf = ?) " +
                         "GROUP BY usuarios.pk_cpf;";
            
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "A");
            stmt.setString(2, "N");
            stmt.setInt(3, codCat);
            stmt.setLong(4, codUsu);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    Autonomo autonomo = new Autonomo(res.getDouble("media"), res.getLong("cpf"), res.getString("nome"), res.getBytes("foto"));
                    listaAutonomos.add(autonomo);
                }
            }
            stmt.close();
            con.close();
            return listaAutonomos;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public Usuario getUsuario(long codUsu){
        Statement stmt;
        Usuario usuario = null;
        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT pk_cpf, email, nome, data_nasc, senha, tipo, status " +
                "FROM usuarios " +
                "WHERE pk_cpf = " + codUsu)) {
                while (res.next()) {
                    switch (res.getString("tipo")) {
                        case "A": {
                            usuario = new Autonomo(res.getLong("pk_cpf"), 
                                    res.getString("nome"), res.getString("email"), 
                                    res.getString("senha"), res.getString("data_nasc"),
                                    res.getString("status"));
                            break;
                        }
                        case "C": {
                            usuario = new Cliente(res.getLong("pk_cpf"), 
                                    res.getString("nome"), res.getString("email"), 
                                    res.getString("senha"), res.getString("data_nasc"),
                                    res.getString("status"));
                            break;
                        }
                        case "S" : {
                            usuario = new Administrador(res.getLong("pk_cpf"), 
                                    res.getString("nome"), res.getString("email"), 
                                    res.getString("senha"), res.getString("data_nasc"),
                                    res.getString("status"));
                            break;
                        }
                    }
                }
            }
            stmt.close();
            con.close();
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public Usuario getUsuarioCompleto(long codUsu) {
        PreparedStatement stmt;
        Usuario usuario = null;
        try {
            String sql = "SELECT usuarios.pk_cpf AS usu_cpf,  " +
                    "	 usuarios.email AS usu_email, " +
                    "    usuarios.tipo AS usu_tipo, " +
                    "    usuarios.status AS usu_status, " +
                    "    usuarios.fk_categoria AS cat_cod, " +
                    "    categorias.nome AS cat_nome, " +
                    "    usuarios.foto_perfil AS usu_foto_perfil, " +
                    "    usuarios.nome AS usu_nome, " +
                    "    usuarios.senha AS usu_senha, " +
                    "    usuarios.data_nasc AS usu_data_nasc, " +
                    "    usuarios.telefone AS usu_telefone, " +
                    "    usuarios.fk_cidade AS cid_cod, " +
                    "    cidades.nome AS cid_nome, " +
                    "    cidades.fk_estado AS est_cod, " +
                    "    estados.nome AS est_nome, " +
                    "    estados.uf AS est_uf, " +
                    "    usuarios.end_rua AS usu_end_rua, " +
                    "    usuarios.end_numero AS usu_end_numero, " +
                    "    usuarios.end_bairro AS usu_end_bairro, " +
                    "    usuarios.end_complemento AS usu_end_complemento, " +
                    "    usuarios.end_cep AS usu_end_cep, " +
                    "    usuarios.descricao AS usu_descricao, " +
                    "    (SELECT TRUNCATE(AVG(nota),2) as media " +
                    "       FROM servicos WHERE fk_autonomo = ?) AS media " +
                    "FROM usuarios " +
                    "LEFT JOIN cidades ON usuarios.fk_cidade = cidades.pk_cod " +
                    "LEFT JOIN estados ON cidades.fk_estado = estados.pk_cod " +
                    "LEFT JOIN categorias ON usuarios.fk_categoria = categorias.pk_cod " +
                    "WHERE usuarios.pk_cpf = ?";
            
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, codUsu);
            stmt.setLong(2, codUsu);
            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    switch (res.getString("usu_tipo")) {
                        case "A": {
                            Estado estado = new Estado(res.getInt("est_cod"),
                                    res.getString("est_nome"), res.getString("est_uf"));
                            Cidade cidade = new Cidade(res.getInt("cid_cod"),
                                    res.getString("cid_nome"), estado);
                            Endereco endereco = new Endereco(res.getString("usu_end_rua"),
                                    res.getInt("usu_end_numero"), res.getString("usu_end_bairro"),
                                    res.getString("usu_end_complemento"), cidade,
                                    res.getInt("usu_end_cep"));
                            Categoria categoria = new Categoria(res.getInt("cat_cod"),
                                    res.getString("cat_nome"));
                            usuario = new Autonomo(res.getLong("usu_cpf"),
                                    res.getString("usu_nome"), res.getString("usu_email"),
                                    res.getString("usu_senha"), res.getBytes("usu_foto_perfil"),
                                    res.getString("usu_data_nasc"),
                                    endereco, res.getLong("usu_telefone"),
                                    res.getString("usu_status"), categoria,
                                    res.getString("usu_descricao"),
                                    res.getDouble("media"));
                            break;
                        }
                        case "C": {
                            Estado estado = new Estado(res.getInt("est_cod"),
                                    res.getString("est_nome"), res.getString("est_uf"));
                            Cidade cidade = new Cidade(res.getInt("cid_cod"),
                                    res.getString("cid_nome"), estado);
                            Endereco endereco = new Endereco(res.getString("usu_end_rua"),
                                    res.getInt("usu_end_numero"), res.getString("usu_end_bairro"),
                                    res.getString("usu_end_complemento"), cidade,
                                    res.getInt("usu_end_cep"));
                            usuario = new Cliente(res.getLong("usu_cpf"), res.getString("usu_nome"),
                                    res.getString("usu_email"), res.getString("usu_senha"),
                                    res.getString("usu_data_nasc"), endereco,
                                    res.getLong("usu_telefone"), res.getString("usu_status"));
                            break;
                        }
                        case "S": {
                            usuario = new Administrador(res.getLong("usu_cpf"),
                                    res.getString("usu_nome"), res.getString("usu_email"),
                                    res.getString("usu_senha"), res.getString("usu_data_nasc"),
                                    res.getString("usu_status"));
                            break;
                        }
                    }
                }
            }
            stmt.close();
            con.close();
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Autonomo> getListaAutoAprovPend(){
        Statement stmt;
        ArrayList<Autonomo> listaAutonomos = new ArrayList<>();

        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT pk_cpf, nome " +
                "FROM usuarios " +
                "WHERE tipo = 'A' AND status = 'P'")) {
                while (res.next()) {
                    Autonomo autonomo = new Autonomo(res.getLong("pk_cpf"),
                            res.getString("nome"));
                    listaAutonomos.add(autonomo);
                }
            }
            stmt.close();
            con.close();
            return listaAutonomos;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }
    }
    
    public int inserirCliente(Cliente cliente){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "INSERT INTO usuarios (pk_cpf, email, tipo, status, "
                        + "nome, senha, data_nasc, telefone, fk_cidade, end_rua, "
                        + "end_numero, end_bairro, end_complemento, end_cep) " +
                        "VALUES (?, ?, 'C', 'N', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setLong(1, cliente.getCpf());
                stmt.setString(2, cliente.getEmail());
                stmt.setString(3, cliente.getNome());
                stmt.setString(4, cliente.getSenha());
                stmt.setString(5, cliente.getDataNasc());
                stmt.setLong(6, cliente.getTelefone());
                stmt.setInt(7, cliente.getEndereco().getCidade().getId());
                stmt.setString(8, cliente.getEndereco().getRua());
                stmt.setInt(9, cliente.getEndereco().getNumero());
                stmt.setString(10, cliente.getEndereco().getBairro());
                stmt.setString(11, cliente.getEndereco().getComplemento());
                stmt.setInt(12, cliente.getEndereco().getCep());
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
    public int alterarSenha(long cpf, String senha){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "UPDATE usuarios SET senha = ? " +
                        "WHERE pk_cpf = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, senha);
                stmt.setLong(2, cpf);
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
    
    public int alterarCliente(Cliente cliente){
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "UPDATE usuarios " +
                        "SET email = ?, " +
                        "nome = ?, " +
                        "telefone = ?, " +
                        "fk_cidade = ?, " +
                        "end_rua = ?, " +
                        "end_numero = ?, " +
                        "end_bairro = ?, " +
                        "end_complemento = ?, " +
                        "end_cep = ? " +
                        "WHERE pk_cpf = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, cliente.getEmail());
                stmt.setString(2, cliente.getNome());
                stmt.setLong(3, cliente.getTelefone());
                stmt.setInt(4, cliente.getEndereco().getCidade().getId());
                stmt.setString(5, cliente.getEndereco().getRua());
                stmt.setInt(6, cliente.getEndereco().getNumero());
                stmt.setString(7, cliente.getEndereco().getBairro());
                stmt.setString(8, cliente.getEndereco().getComplemento());
                stmt.setInt(9, cliente.getEndereco().getCep());
                stmt.setLong(10, cliente.getCpf());
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
    
    /*public double getMediaAutonomo(long cpf) {
        Statement stmt;
        double media = 0;

        try {
            stmt = con.createStatement();
            try (ResultSet res = stmt.executeQuery("SELECT AVG(nota) as media " +
                    "FROM servicos WHERE fk_autonomo = " + cpf)) {
                while (res.next()) {
                    media = res.getDouble("media");
                }
            }
            stmt.close();
            con.close();
            return media;
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return 0;
        }
    }*/
}
