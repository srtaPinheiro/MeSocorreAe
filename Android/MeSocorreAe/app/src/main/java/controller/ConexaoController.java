package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import factory.Criptografia;
import factory.Funcoes;
import modelDominio.Autonomo;
import modelDominio.Categoria;
import modelDominio.Cidade;
import modelDominio.Cliente;
import modelDominio.Estado;
import modelDominio.Servico;
import modelDominio.Usuario;

public class ConexaoController {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    //Classe que é responsável por fazer a conexão com o SERVIDOR O SERVIDOOOOOOOR
    //inteiração com ele

    public boolean conectar() {
        try {
            socket = new Socket("10.0.2.2", 12345); //10.0.2.2
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            return true;
        } catch (IOException ioe) {
            return false;
        }
    }

    public Usuario fazerLogin(long cpf, String senha) {
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

    public ArrayList<Autonomo> getListaAutonomos(int idCategoria, long idUsuario) {
        try {
            out.writeObject("ListaAutonomos");
            if ((boolean) in.readObject()) {
                out.writeObject(idCategoria);
                if ((boolean) in.readObject()) {
                    out.writeObject(idUsuario);
                    return (ArrayList<Autonomo>) in.readObject();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar os autonomos: " + ex.getMessage());
            return null;
        }
    }

    public ArrayList<Categoria> getListaCategorias() {
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

    public ArrayList<Servico> getListaServicos(long codUsu) {
        try {
            out.writeObject("ListaPedidosCliente");
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

    public ArrayList<Categoria> getListaCategoriasFiltro(String filtro) {
        try {
            out.writeObject("ListaCategoriasFiltro");
            if ((boolean) in.readObject()) {
                out.writeObject(filtro);
                return (ArrayList<Categoria>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar as categorias: " + ex.getMessage());
            return null;
        }
    }

    public ArrayList<Estado> getListaEstados() {
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

    public ArrayList<Cidade> getListaCidades(int codEst) {
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

    public boolean clienteInserir(Cliente cliente) {
        try {
            out.writeObject("CadastrarCliente");
            if ((boolean) in.readObject()) {
                out.writeObject(cliente);
                return (boolean) in.readObject();
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir um autônomo: " + ex.getMessage());
            return false;
        }
    }

    public Usuario getUsuario(long codUsu) {
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

    public Usuario getUsuarioCompleto(long codUsu) {
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

    public boolean servicoInserir(Servico servico) {
        try {
            out.writeObject("InserirServico");
            if ((boolean) in.readObject()) {
                out.writeObject(servico);
                return (boolean) in.readObject();
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao inserir um serviço: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Servico> getAvaliacoesAutonomo(long codUsu) {
        try {
            out.writeObject("ListaAvaliacoesAutonomo");
            if ((boolean) in.readObject()) {
                out.writeObject(codUsu);
                return (ArrayList<Servico>) in.readObject();
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar as avaliações: " + ex.getMessage());
            return null;
        }
    }

    public boolean recuperarSenha(long codUsu) {
        try {
            out.writeObject("RecuperarSenha");
            if ((boolean) in.readObject()){
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

    public boolean darFeedback(int codSer, int nota, String avaliacao) {
        try {
            out.writeObject("DarFeedback");
            if ((boolean) in.readObject()) {
                out.writeObject(codSer);
                if ((boolean) in.readObject()) {
                    out.writeObject(nota);
                    if ((boolean) in.readObject()) {
                        out.writeObject(avaliacao);

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
            System.out.println("Erro ao pegar serviço: " + ex.getMessage());
            return false;
        }
    }

    public boolean alterarCliente(Cliente cliente) {
        try {
            out.writeObject("AlterarCliente");
            if ((boolean) in.readObject()) {
                out.writeObject(cliente);

                return (boolean) in.readObject();
            } else {
                return false;
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao alterar cliente: " + ex.getMessage());
            return false;
        }
    }

}
