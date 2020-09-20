package modelDominio;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable {
    private static final long serialVersionUID = 166L;

    public Cliente(long cpf, String nome, String email, String senha, String dataNasc, Endereco endereco, long telefone, String status) {
        super(cpf, nome, email, senha, dataNasc, endereco, telefone, status);
    }

    public Cliente(String nome) {
        super(nome);
    }
    
    public Cliente(long cpf, String nome){
        super(cpf, nome);
    }
    
    public Cliente(long cpf, String nome, Endereco endereco){
        super(cpf, nome, endereco);
    }

    public Cliente(long cpf, String nome, String dataNasc) {
        super(cpf, nome, dataNasc);
    }

    public Cliente(long cpf, String nome, String email, String senha, String dataNasc, String status) {
        super(cpf, nome, email, senha, dataNasc, status);
    }

    public Cliente(String nome, byte[] foto) {
        super(nome, foto);
    }

    public Cliente(long cpf) {
        super(cpf);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Cliente{" + '}';
    }
    
}
