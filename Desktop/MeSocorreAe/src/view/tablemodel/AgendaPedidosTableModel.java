package view.tablemodel;

import factory.Funcoes;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Servico;

public class AgendaPedidosTableModel extends AbstractTableModel {
    
    private final ArrayList<Servico> listaServicos;

    public AgendaPedidosTableModel(ArrayList<Servico> listaServicos) {
        this.listaServicos = new ArrayList<>();
        this.listaServicos.addAll(listaServicos);
    }

    public ArrayList<Servico> getListaServicos() {
        return listaServicos;
    }
    
    public Servico getServico(int row) {
        return listaServicos.get(row);
    }

    @Override
    public int getRowCount() {
        return listaServicos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servico servico = listaServicos.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return servico.getCliente().getNome();
            case 1: {
                String data = Funcoes.dateSqlToNormal(servico.getDataHoraQua().substring(0, 10));
                String hora = servico.getDataHoraQua().substring(11, 16);

                return data + " " + hora;
            }
            case 2: {
                String data = Funcoes.dateSqlToNormal(servico.getDataHoraReg().substring(0, 10));
                String hora = servico.getDataHoraReg().substring(11, 16);

                return data + " " + hora;
            }
            case 3:
                return servico.getSituacaoLiteral();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Quem pediu";
            case 1:
                return "Pra quando";
            case 2:
                return "Quando pediu";
            case 3:
                return "Situação";
            default:
                return "NoName";
        }
    }
    
}
