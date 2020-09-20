package modelDominio;

import java.io.Serializable;

public class Servico implements Serializable {
    private static final long serialVersionUID = 111L;
    
    private int cod;
    private char situacao;
    private String descricao;
    private Cliente cliente;
    private Autonomo autonomo;
    private double preco;
    private String dataHoraReg;
    private String dataHoraQua;
    private int nota;
    private String avaliacao;
    private String resposta;

    public Servico(int cod, char situacao, String descricao, Cliente cliente, Autonomo autonomo, double preco, String dataHoraReg, String dataHoraQua, String avaliacao, int nota, String resposta) {
        this.cod = cod;
        this.situacao = situacao;
        this.descricao = descricao;
        this.cliente = cliente;
        this.autonomo = autonomo;
        this.preco = preco;
        this.dataHoraReg = dataHoraReg;
        this.dataHoraQua = dataHoraQua;
        this.avaliacao = avaliacao;
        this.nota = nota;
        this.resposta = resposta;
    }

    public Servico(int cod, Cliente cliente, String dataHoraQua) {
        this.cod = cod;
        this.cliente = cliente;
        this.dataHoraQua = dataHoraQua;
    }

    public Servico(String descricao, Cliente cliente, Autonomo autonomo, String dataHoraQua) {
        this.descricao = descricao;
        this.cliente = cliente;
        this.autonomo = autonomo;
        this.dataHoraQua = dataHoraQua;
    }

    public Servico(Cliente cliente, int nota, String avaliacao) {
        this.cliente = cliente;
        this.nota = nota;
        this.avaliacao = avaliacao;
    }

    public Servico(int cod, char situacao, Autonomo autonomo, String dataHoraQua) {
        this.cod = cod;
        this.situacao = situacao;
        this.autonomo = autonomo;
        this.dataHoraQua = dataHoraQua;
    }

    public Servico(int cod, char situacao, Cliente cliente, String dataHoraReg, String dataHoraQua) {
        this.cod = cod;
        this.situacao = situacao;
        this.cliente = cliente;
        this.dataHoraReg = dataHoraReg;
        this.dataHoraQua = dataHoraQua;
    }

    public int getCod() {
        return cod;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Autonomo getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(Autonomo autonomo) {
        this.autonomo = autonomo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDataHoraReg() {
        return dataHoraReg;
    }

    public String getDataHoraQua() {
        return dataHoraQua;
    }

    public void setDataHoraQua(String dataHoraQua) {
        this.dataHoraQua = dataHoraQua;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getSituacaoLiteral(){
        switch(this.situacao) {
            case 'E': {
                return "Aguardando resp.";
            }
            case 'A': {
                return "Aceito";
            }
            case 'N': {
                return "Não aceito";
            }
            case 'C': {
                return "Concluído";
            }
            default: {
                return "";
            }
        }
    }
    
}
