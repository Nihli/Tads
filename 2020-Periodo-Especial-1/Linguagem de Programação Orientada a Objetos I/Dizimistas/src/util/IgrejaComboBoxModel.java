/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dizimistas.entity.Igreja;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Lia
 */
public class IgrejaComboBoxModel implements ComboBoxModel<Igreja> {
    private List<Igreja> lista;
    private Igreja selecionado;

    public IgrejaComboBoxModel(List<Igreja> lista) {
        this.lista = lista;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if( anItem instanceof Igreja ) {
            selecionado = (Igreja)anItem;
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
    public Igreja getElementAt(int index) {
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
