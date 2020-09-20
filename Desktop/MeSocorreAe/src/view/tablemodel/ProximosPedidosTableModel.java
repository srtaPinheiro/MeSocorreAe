package view.tablemodel;

import factory.Funcoes;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Servico;

public class ProximosPedidosTableModel extends AbstractTableModel {
    
    private final ArrayList<Servico> listaProximosServicos;

    public ProximosPedidosTableModel(ArrayList<Servico> listaProximosServicos) {
        this.listaProximosServicos = new ArrayList<>();
        this.listaProximosServicos.addAll(listaProximosServicos);
    }

    public ArrayList<Servico> getListaProximosServicos() {
        return listaProximosServicos;
    }
    
    public Servico getProximoServico(int row) {
        return listaProximosServicos.get(row);
    }

    @Override
    public int getRowCount() {
        return listaProximosServicos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servico servico = listaProximosServicos.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return servico.getCliente().getNome();
            case 1: {
                String data = Funcoes.dateSqlToNormal(servico.getDataHoraQua().substring(0, 10));
                String hora = servico.getDataHoraQua().substring(11, 16);

                return data + " " + hora;
            }
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
            default:
                return "NoName";
        }
    }
    
}
