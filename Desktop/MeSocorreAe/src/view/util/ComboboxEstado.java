package view.util;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelDominio.Estado;

public class ComboboxEstado {
    
    private final String value;
    private final int key;

    public ComboboxEstado(int key, String value) {
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
            return ((ComboboxEstado) obj).getKey();
        }
    }
    
    public static void preencheComboboxEstado(int SelCodigo, JComboBox combo,
            ArrayList<Estado> lista) {
        Vector vlista = new Vector();
        int x = 0;
        int y = -1;
        
        for (Estado c : lista) {
            ComboboxEstado cmb = new ComboboxEstado(c.getId(), c.getNome());
            vlista.add(cmb);
            if (c.getId() == SelCodigo) {
                y = x;
            }
            x++;
        }
        DefaultComboBoxModel modeloEstado = new DefaultComboBoxModel(vlista);
        combo.setModel(modeloEstado);
        combo.setSelectedIndex(y);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
