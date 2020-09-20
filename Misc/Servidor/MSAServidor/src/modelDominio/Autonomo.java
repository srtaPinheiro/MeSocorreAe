package modelDominio;

import java.io.Serializable;

public class Autonomo extends Usuario implements Serializable {
    private static final long serialVersionUID = 133L;
    private double avaliacao;
    private Categoria categoria;
    private String descricao;

    //construtor sem foto
    public Autonomo(long cpf, String nome, String email, String senha, String dataNasc, Endereco endereco, long telefone, String status, Categoria categoria, String descricao) {
        super(cpf, nome, email, senha, dataNasc, endereco, telefone, status);
        this.categoria = categoria;
        this.descricao = descricao;
    }
    
    //construtor completo
    public Autonomo(long cpf, String nome, String email, String senha, byte[] foto, String dataNasc, Endereco endereco, long telefone, String status, Categoria categoria, String descricao, double avaliacao) {
        super(cpf, nome, email, senha, foto, dataNasc, endereco, telefone, status);
        this.categoria = categoria;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
    }

    public Autonomo(long cpf, String nome, String email, String senha, String dataNasc, Endereco endereco, long telefone, String status, String descricao) {
        super(cpf, nome, email, senha, dataNasc, endereco, telefone, status);
        this.descricao = descricao;
    }

    //autonomo aprov pendente
    public Autonomo(long cpf, String nome) {
        super(cpf, nome);
    }

    public Autonomo(long cpf, String nome, String dataNasc) {
        super(cpf, nome, dataNasc);
    }

    public Autonomo(long cpf, String nome, String email, String senha, String dataNasc, String status) {
        super(cpf, nome, email, senha, dataNasc, status);
    }

    public Autonomo(long cpf, String nome, String email, String senha, String dataNasc, Endereco endereco, long telefone) {
        super(cpf, nome, email, senha, dataNasc, endereco, telefone);
    }

    public Autonomo(String nome, byte[] foto) {
        super(nome, foto);
    }

    public Autonomo(long cpf, String nome, byte[] foto) {
        super(cpf, nome, foto);
    }

    public Autonomo(long cpf) {
        super(cpf);
    }

    public Autonomo(double avaliacao, long cpf, String nome, byte[] foto) {
        super(cpf, nome, foto);
        this.avaliacao = avaliacao;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autonomo{" + "avaliacao=" + avaliacao + ", categoria=" + categoria + ", descricao=" + descricao + '}';
    }
    
}