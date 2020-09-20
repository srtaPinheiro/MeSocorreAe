package controller;

import factory.Funcoes;
import factory.JavaMail;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.CategoriaDAO;
import model.CidadeDAO;
import model.EstadoDAO;
import model.ServicoDAO;
import model.UsuarioDAO;
import modelDominio.Autonomo;
import modelDominio.Categoria;
import modelDominio.Cidade;
import modelDominio.Estado;
import modelDominio.Servico;
import modelDominio.Usuario;
import factory.Criptografia;
import modelDominio.Cliente;

public class TrataClienteController extends Thread {

    private final ObjectInputStream in;
    private final ObjectOutputStream out;
    private final Socket s;
    private final int idUnico;

    public TrataClienteController(Socket s, ObjectInputStream in, ObjectOutputStream out, int idUnico) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.idUnico = idUnico;
        this.start();
    }

    @Override
    public void run() {
        String comando;
        System.out.println("Esperando comandos do cliente... ");
        try {
            comando = (String) in.readObject();
            while (!comando.equals("fim")) {
                System.out.println("Cliente " + idUnico + " enviou comando: "
                        + comando);
                switch (comando) {
                    case "CadastrarAutonomo": {
                        out.writeObject(true);
                        Autonomo autonomo = (Autonomo) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.inserirAutonomo(autonomo) == -1){
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "AlterarAutonomo": {
                        out.writeObject(true);
                        Autonomo autonomo = (Autonomo) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.alterarAutonomo(autonomo) == -1){
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "ListaEstados": {
                        out.writeObject(true);
                        in.readObject();
                        EstadoDAO estadoDAO = new EstadoDAO();
                        ArrayList<Estado> listaEst = estadoDAO.getListaEstados();
                        out.writeObject(listaEst);
                        break;
                    }
                    case "EstadoPorCod": {
                        out.writeObject(true);
                        int codEst = (int) in.readObject();
                        EstadoDAO estadoDAO = new EstadoDAO();
                        Estado estado = estadoDAO.getEstadoPorCod(codEst);
                        out.writeObject(estado);
                        break;
                    }
                    case "CidadePorCod": {
                        out.writeObject(true);
                        int codCid = (int) in.readObject();
                        CidadeDAO cidadeDAO = new CidadeDAO();
                        Cidade cidade = cidadeDAO.getCidadePorCod(codCid);
                        out.writeObject(cidade);
                        break;
                    }
                    case "ListaCidades": {
                        out.writeObject(true);
                        int codEst = (int) in.readObject();
                        CidadeDAO cidadeDAO = new CidadeDAO();
                        ArrayList<Cidade> listaCid = cidadeDAO.getListaCidades(codEst);
                        out.writeObject(listaCid);
                        break;
                    }
                    case "ListaProximosPedidos": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        ArrayList<Servico> listaPed = servicoDAO.getListaProximosServicos(codUsu);
                        out.writeObject(listaPed);
                        break;
                    }
                    case "ListaPedidos": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        out.writeObject(true);
                        boolean exibePendentes = (boolean) in.readObject();
                        out.writeObject(true);
                        boolean exibeAceitos = (boolean) in.readObject();
                        out.writeObject(true);
                        boolean exibeRecusados = (boolean) in.readObject();
                        out.writeObject(true);
                        boolean exibeConcluidos = (boolean) in.readObject();
                        
                        ServicoDAO servicoDAO = new ServicoDAO();
                        ArrayList<Servico> listaPed = servicoDAO.getListaServicos(
                                codUsu, exibePendentes, exibeAceitos, exibeRecusados, exibeConcluidos);
                        out.writeObject(listaPed);
                        break;
                    }
                    case "ListaCategorias": {
                        out.writeObject(true);
                        in.readObject();
                        CategoriaDAO categoriaDAO = new CategoriaDAO();
                        ArrayList<Categoria> listaCat = categoriaDAO.getListaCategorias();
                        out.writeObject(listaCat);
                        break;
                    }
                    case "ListaCategoriasFiltro": {
                        out.writeObject(true);
                        String filtro = (String) in.readObject();
                        CategoriaDAO categoriaDAO = new CategoriaDAO();
                        ArrayList<Categoria> listaCat = categoriaDAO.getListaCategoriasFiltro(filtro);
                        out.writeObject(listaCat);
                        break;
                    }
                    case "ListaAutonomos": {
                        out.writeObject(true);
                        int codCat = (int) in.readObject();
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        ArrayList<Autonomo> listaAut = usuarioDAO.getListaAutonomos(codCat, codUsu);
                        out.writeObject(listaAut);
                        break;
                    }
                    case "UsuarioPorCod": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Usuario usuario = usuarioDAO.getUsuario(codUsu);
                        out.writeObject(usuario);
                        break;
                    }
                    case "UsuarioCompletoPorCod": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Usuario usuario = usuarioDAO.getUsuarioCompleto(codUsu);
                        out.writeObject(usuario);
                        break;
                    }
                    case "RecuperarSenha": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Usuario usuario = usuarioDAO.getUsuario(codUsu);
                        
                        if (usuario != null) {
                            int alfabeto = Funcoes.montaAlfabetoCrip(codUsu);
                            String chave = Funcoes.montaChaveCrip(usuario.getDataNasc(), codUsu);
                            Criptografia criptografia = new Criptografia(alfabeto, chave);
                            String senhaDesc = criptografia.decrypto(usuario.getSenha());
                            
                            JavaMail javaMail = new JavaMail();
                            javaMail.setDestinatario(usuario.getEmail());
                            javaMail.setAssunto("Esqueceu sua senha?");
                            javaMail.setMensagem("Sua senha em nosso sistema é: " + senhaDesc);
                            if (javaMail.enviar()) {
                                out.writeObject(true);
                            } else {
                                out.writeObject(false);
                            }
                        } else {
                            out.writeObject(false);
                        }
                        
                        break;
                    }
                    case "CategoriaPorCod": {
                        out.writeObject(true);
                        int cod = (int) in.readObject();
                        CategoriaDAO categoriaDAO = new CategoriaDAO();
                        out.writeObject(categoriaDAO.getCategoria(cod));
                        break;
                    }
                    case "ListaAutoAprovPend": {
                        out.writeObject(true);
                        in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        out.writeObject(usuarioDAO.getListaAutoAprovPend());
                        break;
                    }
                    case "AprovarAutonomo": {
                        out.writeObject(true);
                        long cpf = (long) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Autonomo autonomo = (Autonomo) usuarioDAO.getUsuarioCompleto(cpf);
                        autonomo.setStatus("O");
                        usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.alterarAutonomo(autonomo) == -1){
                            JavaMail javaMail = new JavaMail();
                            javaMail.setDestinatario(autonomo.getEmail());
                            javaMail.setAssunto("Seu cadastro foi aprovado!");
                            javaMail.setMensagem("Olá, " + autonomo.getNome() + "!\n" +
                                    "Seu cadastro em nossa plataforma foi aprovado!");
                            if (javaMail.enviar()) {
                                out.writeObject(true);
                            } else {
                                out.writeObject(false);
                            }
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "ReprovarAutonomo": {
                        out.writeObject(true);
                        long cpf = (long) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        Autonomo autonomo = (Autonomo) usuarioDAO.getUsuario(cpf);
                        usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.excluirAutonomo(autonomo) == -1) {
                            JavaMail javaMail = new JavaMail();
                            javaMail.setDestinatario(autonomo.getEmail());
                            javaMail.setAssunto("Seu cadastro foi reprovado!");
                            javaMail.setMensagem("Olá, " + autonomo.getNome() + "!\n" +
                                    "Seu cadastro em nossa plataforma foi reprovado! "
                                    + "Tente se cadastrar novamente.");
                            if (javaMail.enviar()) {
                                out.writeObject(true);
                            } else {
                                out.writeObject(false);
                            }
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "CadastrarCliente": {
                        out.writeObject(true);
                        Cliente cliente = (Cliente) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.inserirCliente(cliente) == -1){
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "InserirServico": {
                        out.writeObject(true);
                        Servico servico = (Servico) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        if (servicoDAO.inserirServico(servico) == -1) {
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "ServicoPorCod": {
                        out.writeObject(true);
                        int codSer = (int) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        out.writeObject(servicoDAO.getServico(codSer));
                        break;
                    }
                    case "ListaAvaliacoesAutonomo": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        out.writeObject(servicoDAO.getAvaliacoesAutonomo(codUsu));
                        break;
                    }
                    case "ListaPedidosCliente": {
                        out.writeObject(true);
                        long codUsu = (long) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        out.writeObject(servicoDAO.getListaPedidosCliente(codUsu));
                        break;
                    }
                    case "AlterarSenha": {
                        out.writeObject(true);
                        long cpf = (long) in.readObject();
                        out.writeObject(true);
                        String senha = (String) in.readObject();
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.alterarSenha(cpf, senha) == -1){
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "AceitarServico": {
                        out.writeObject(true);
                        int codSer = (int) in.readObject();
                        out.writeObject(true);
                        double preco = (double) in.readObject();
                        out.writeObject(true);
                        String resposta = (String) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        if (servicoDAO.aceitarServico(codSer, preco, resposta) == -1) {
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "RecusarServico": {
                        out.writeObject(true);
                        int codSer = (int) in.readObject();
                        out.writeObject(true);
                        String resposta = (String) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        if (servicoDAO.recusarServico(codSer, resposta) == -1) {
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "DarFeedback": {
                        out.writeObject(true);
                        int codSer = (int) in.readObject();
                        out.writeObject(true);
                        int nota = (int) in.readObject();
                        out.writeObject(true);
                        String avaliacao = (String) in.readObject();
                        ServicoDAO servicoDAO = new ServicoDAO();
                        if (servicoDAO.darFeedback(codSer, nota, avaliacao) == -1) {
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    case "AlterarCliente": {
                        out.writeObject(true);
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.alterarCliente((Cliente) in.readObject()) == -1) {
                            out.writeObject(true);
                        } else {
                            out.writeObject(false);
                        }
                        break;
                    }
                    default: {
                        out.writeObject(false);
                        break;
                    }  
                }
                comando = (String) in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao tratar clientes: " + e.getMessage());
        }

        try {
            System.out.println("Cliente " + idUnico + " finalizou a conexão.");
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            System.out.println("Erro ao tratar clientes (fechamento): "
                    + e.getMessage());
        }
    }
}

