package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelDominio.Autonomo;
import modelDominio.Categoria;
import modelDominio.Cidade;
import modelDominio.Estado;
import modelDominio.Servico;
import modelDominio.Usuario;
import view.Criptografia;
import factory.Funcoes;

public class ConexaoController {

    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private Usuario usuarioLogado;

    public ConexaoController(ObjectInputStream in, ObjectOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }    
    
    public Usuario fazerLogin(long cpf, String senha){
        Usuario usuario = null;
        try {
            out.writeObject("UsuarioPorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(cpf);
                usuario = (Usuario) in.readObject();
            } else {
                return null;
            }
            
            if (usuario != null) {
                int alfabeto = Funcoes.montaAlfabetoCrip(cpf);
                String chave = Funcoes.montaChaveCrip(usuario.getDataNasc(), cpf);
                Criptografia criptografia = new Criptografia(alfabeto, chave);
                String senhaCrip = criptografia.crypto(senha);
                
                if (usuario.getSenha().equals(senhaCrip)) {
                    return usuario;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao fazer login: " + ex.getMessage());
            return null;
        }
    }
    
    public Boolean autonomoInserir(Autonomo autonomo){
        try {
            out.writeObject("CadastrarAutonomo");
            if ((boolean) in.readObject()) {
                out.writeObject(autonomo);
                return (boolean) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir um autônomo: " + ex.getMessage());
            return false;
        }
    }
    
    public Boolean autonomoAlterar(Autonomo autonomo){
        try {
            out.writeObject("AlterarAutonomo");
            if ((boolean) in.readObject()) {
                out.writeObject(autonomo);
                return (boolean) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao alterar um autônomo: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<Estado> getListaEstados(){
        try {
            out.writeObject("ListaEstados");
            if ((boolean) in.readObject()) {
                out.writeObject(null);
                return (ArrayList<Estado>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os estados: " + ex.getMessage());
            return null;
        }
    }
    
    public Estado getEstadoPorCod(int codEst){
        try {
            out.writeObject("EstadoPorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(codEst);
                return (Estado) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao pegar estado por código: " + ex.getMessage());
            return null;
        }
    }
    
    public Cidade getCidadePorCod(int codCid){
        try {
            out.writeObject("CidadePorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(codCid);
                return (Cidade) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao pegar cidade por código: " + ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Cidade> getListaCidades(int codEst){
        try {
            out.writeObject("ListaCidades");
            if ((boolean) in.readObject()) {
                out.writeObject(codEst);
                return (ArrayList<Cidade>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar as cidades: " + ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Servico> getListaProximosServicos(long codUsu){
        try {
            out.writeObject("ListaProximosPedidos");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (ArrayList<Servico>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os serviços: " + ex.getMessage());
            return null;
        }
    }
    
    public Usuario getUsuario(long codUsu){
        try {
            out.writeObject("UsuarioPorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (Usuario) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao consultar o usuário: " + ex.getMessage());
            return null;
        }
    }
    
    public Usuario getUsuarioCompleto(long codUsu){
        try {
            out.writeObject("UsuarioCompletoPorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (Usuario) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao consultar o usuário: " + ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Categoria> getListaCategorias(){
        try {
            out.writeObject("ListaCategorias");
            if ((boolean) in.readObject()) {
                out.writeObject(null);
                return (ArrayList<Categoria>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar as categorias: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean recuperarSenha(long codUsu) {
        try {
            out.writeObject("RecuperarSenha");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (boolean) in.readObject();
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao recuperar a senha: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean alterarSenha(long cpf, String senha) {
        try {
            out.writeObject("AlterarSenha");
            if ((boolean) in.readObject()) {
                out.writeObject(cpf);
                if ((boolean) in.readObject()) {
                    out.writeObject(senha);

                    return (boolean) in.readObject();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao alterar a senha: " + ex.getMessage());
            return false;
        }
    }
    
    public Categoria getCategoriaPorCod(int cod) {
        try {
            out.writeObject("CategoriaPorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(cod);
                return (Categoria) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao consultar uma categoria por código: " + ex.getMessage());
            return null;
        }
    }
    
    public ArrayList<Autonomo> getListaAutoAprovPend() {
        try {
            out.writeObject("ListaAutoAprovPend");
            if ((boolean) in.readObject()) {
                out.writeObject(null);
                return (ArrayList<Autonomo>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar autonomos com aprovação pendente: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean aprovarAutonomo(long codUsu) {
        try {
            out.writeObject("AprovarAutonomo");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (boolean) in.readObject();
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao aprovar o cadastro do autonômo: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean reprovarAutonomo(long codUsu) {
        try {
            out.writeObject("ReprovarAutonomo");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (boolean) in.readObject();
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao reprovar o cadastro do autonômo: " + ex.getMessage());
            return false;
        }
    }
    
    public ArrayList<Servico> getListaServicos(long codUsu, boolean exibePendentes, 
            boolean exibeAceitos, boolean exibeRecusados, boolean exibeConcluidos){
        try {
            out.writeObject("ListaPedidos");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                
                if ((boolean) in.readObject()) {
                    out.writeObject(exibePendentes);
                    
                    if ((boolean) in.readObject()) {
                        out.writeObject(exibeAceitos);

                        if ((boolean) in.readObject()) {
                            out.writeObject(exibeRecusados);
                            
                            if ((boolean) in.readObject()) {
                                out.writeObject(exibeConcluidos);
                                
                                return (ArrayList<Servico>) in.readObject();
                                
                            } else {
                                return null;
                            }
                
                        } else {
                            return null;
                        }
                        
                    } else {
                        return null;
                    }
                    
                } else {
                    return null;
                }
                
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar serviços: " + ex.getMessage());
            return null;
        }
    }
    
    public Servico getServicoPorCod(int codSer) {
        try {
            out.writeObject("ServicoPorCod");
            if ((boolean) in.readObject()) {
                out.writeObject(codSer);
                return (Servico) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao pegar serviço: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean aceitarServico(int codSer, double preco, String resposta) {
        try {
            out.writeObject("AceitarServico");
            if ((boolean) in.readObject()) {
                out.writeObject(codSer);
                if ((boolean) in.readObject()){
                    out.writeObject(preco);
                    if ((boolean) in.readObject()){
                        out.writeObject(resposta);

                        return (boolean) in.readObject();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao aceitar serviço: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean recusarServico(int codSer, String resposta) {
        try {
            out.writeObject("RecusarServico");
            if ((boolean) in.readObject()) {
                out.writeObject(codSer);
                if ((boolean) in.readObject()){
                    out.writeObject(resposta);

                    return (boolean) in.readObject();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao recusar serviço: " + ex.getMessage());
            return false;
        }
    }
            
    public void fim() {
        try {
            out.writeObject("fim");
            in.close();
            out.close();
        } catch (IOException ex) {
            System.out.println("Erro ao finalizar a conexão com o servidor: "
                    + ex.getMessage() + ".");
        }
    }
    
}