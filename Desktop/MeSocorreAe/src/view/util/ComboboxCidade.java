package view.util;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelDominio.Cidade;

public class ComboboxCidade {
    
    private final String value;
    private final int key;

    public ComboboxCidade(int key, String value) {
        this.value = value;
        this.key = key;
    }

    public int getKey() {
        return key;
    }
    
    public static int getSelectedIndex(JComboBox combo) {
        Object obj = combo.getSelectedItem();
        if (obj == null) {
            return -1;
        } else {
            return ((ComboboxCidade) obj).getKey();
        }
    }
    
    public static void preencheComboboxCidade(int SelCodigo, JComboBox combo,
            ArrayList<Cidade> lista) {
        Vector vlista = new Vector();
        int x = 0;
        int y = -1;
        
        for (Cidade c : lista) {
            ComboboxCidade cmb = new ComboboxCidade(c.getId(), c.getNome());
            vlista.add(cmb);
            if (c.getId() == SelCodigo) {
                y = x;
            }
            x++;
        }
        DefaultComboBoxModel modeloCidade = new DefaultComboBoxModel(vlista);
        combo.setModel(modeloCidade);
        combo.setSelectedIndex(y);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
