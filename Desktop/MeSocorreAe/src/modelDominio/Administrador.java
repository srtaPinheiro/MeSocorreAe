package modelDominio;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
    private static final long serialVersionUID = 122L;
    
    public Administrador(long cpf, String nome, String email, String senha, String dataNasc, String status) {
        super(cpf, nome, email, senha, dataNasc, status);
    }
    
}
