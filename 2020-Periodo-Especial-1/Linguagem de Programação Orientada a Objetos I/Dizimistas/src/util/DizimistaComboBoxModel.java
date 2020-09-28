/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Dizimista;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Lia
 */
public class DizimistaComboBoxModel implements ComboBoxModel<Dizimista> {
    private List<Dizimista> lista;
    private Dizimista selecionado;

    public DizimistaComboBoxModel(List<Dizimista> lista) {
        this.lista = lista;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if( anItem instanceof Dizimista ) {
            selecionado = (Dizimista)anItem;
        }
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Dizimista getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
