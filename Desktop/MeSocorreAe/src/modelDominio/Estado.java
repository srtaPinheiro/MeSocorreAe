package modelDominio;

import java.io.Serializable;

public class Estado implements Serializable {
    private static final long serialVersionUID = 188L;
    
    private int id;
    private String nome;
    private String uf;

    public Estado(int id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return nome + " / " + uf;
    }
    
}
