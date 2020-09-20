package view.tablemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelDominio.Autonomo;
import factory.Funcoes;

public class AutoAprovPendTableModel extends AbstractTableModel {
    
    private final ArrayList<Autonomo> listaAutoAprovPend;

    public AutoAprovPendTableModel(ArrayList<Autonomo> listaAutoAprovPend) {
        this.listaAutoAprovPend = new ArrayList<>();
        this.listaAutoAprovPend.addAll(listaAutoAprovPend);
    }
    
    public ArrayList<Autonomo> getListaProximosServicos() {
        return this.listaAutoAprovPend;
    }
    
    public Autonomo getAutoAprovPend(int row) {
        return this.listaAutoAprovPend.get(row);
    }
    
    @Override
    public int getRowCount() {
        return this.listaAutoAprovPend.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autonomo autonomo = this.listaAutoAprovPend.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return Funcoes.formataCpf(autonomo.getCpf());
            case 1:
                return autonomo.getNome();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "CPF";
            case 1:
                return "Nome";
            default:
                return "NoName";
        }
    }
    
}
