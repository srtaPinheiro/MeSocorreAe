package modelDominio;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 199L;
    
    protected long cpf;
    protected String nome;
    protected String email;
    protected String senha;
    protected byte[] foto;
    protected String dataNasc;
    protected Endereco endereco;
    protected long telefone;
    protected String status;

    //construtor sem foto
    public Usuario(long cpf, String nome, String email, String senha, String dataNasc, Endereco endereco, long telefone, String status) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
    }

    //construtor completo
    public Usuario(long cpf, String nome, String email, String senha, byte[] foto, String dataNasc, Endereco endereco, long telefone, String status) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
    }

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    public Usuario(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Usuario(long cpf, String nome, String dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    //usuario logado e administrador
    public Usuario(long cpf, String nome, String email, String senha, String dataNasc, String status) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.status = status;
    }
    
    //cadastro de autonomo
    public Usuario(long cpf, String nome, String email, String senha, String dataNasc, Endereco endereco, long telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Usuario(String nome, byte[] foto) {
        this.nome = nome;
        this.foto = foto;
    }

    public Usuario(long cpf) {
        this.cpf = cpf;
    }

    public Usuario(long cpf, String nome, byte[] foto) {
        this.cpf = cpf;
        this.nome = nome;
        this.foto = foto;
    }

    public Usuario(long cpf, String nome, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto + ", dataNasc=" + dataNasc + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }
    
}
