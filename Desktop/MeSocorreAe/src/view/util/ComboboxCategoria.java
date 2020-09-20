package view.util;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelDominio.Categoria;

public class ComboboxCategoria {
    
    private final String value;
    private final int key;

    public ComboboxCategoria(int key, String value) {
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
            return ((ComboboxCategoria) obj).getKey();
        }
    }
    
    public static void preencheComboboxCategoria(int SelCodigo, JComboBox combo,
            ArrayList<Categoria> lista) {
        Vector vlista = new Vector();
        int x = 0;
        int y = -1;
        
        for (Categoria c : lista) {
            ComboboxCategoria cmb = new ComboboxCategoria(c.getId(), c.getNome());
            vlista.add(cmb);
            if (c.getId() == SelCodigo) {
                y = x;
            }
            x++;
        }
        DefaultComboBoxModel modeloCategoria = new DefaultComboBoxModel(vlista);
        combo.setModel(modeloCategoria);
        combo.setSelectedIndex(y);
    }
    
    @Override
    public String toString() {
        return value;
    }
    
}
