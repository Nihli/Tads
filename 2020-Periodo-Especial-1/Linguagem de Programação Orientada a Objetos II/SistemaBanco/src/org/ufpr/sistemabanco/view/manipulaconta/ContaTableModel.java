/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.view.manipulaconta;

import org.ufpr.sistemabanco.view.cliente.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.ContaCorrente;
import org.ufpr.sistemabanco.model.ContaI;
import org.ufpr.sistemabanco.model.ContaInvestimento;

/**
 *
 * @author Lia
 */
public class ContaTableModel extends AbstractTableModel{
 private String[] colunas=new String[]{"CPF","Numero", "Tipo"};

//    private class Conta {
//        private int id;
//        private double saldo;
//        private double depositoInicial;
//        private Cliente dono;
//        private int numero;
//        
//    }
// 
    private List<ContaI> lista=new ArrayList();

    
    public ContaTableModel(List<ContaI> lista){
        this.lista=lista;
    }

    public ContaTableModel(){
    }
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
      @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
        //if(column==0)
        //    return false;
        //return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (lista.get(rowIndex) instanceof ContaCorrente){
            ContaCorrente c = (ContaCorrente)lista.get(rowIndex);
            
            switch (columnIndex) {
                case 0: return c.getDono().getCpf();//if column 0 (code)
                case 1: return c.getNumero();//if column 1 (name)
                case 2: return "Corrente";//if column 2 (birthday)
                default : return null;
            }
        }else {
            ContaInvestimento c = (ContaInvestimento)lista.get(rowIndex);
            
            switch (columnIndex) {
                case 0: return c.getDono().getCpf();//if column 0 (code)
                case 1: return c.getNumero();//if column 1 (name)
                case 2: return "Investimento";//if column 2 (birthday)
                default : return null;
            }
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        if (lista.get(row) instanceof ContaCorrente){
            ContaCorrente c = (ContaCorrente)lista.get(row);
            
            switch (col) {
                case 0:
                    c.getDono().setCpf((String) value); //if column 0 (code)
                    break;
                case 1:
                    c.setNumero((int) value);
                    break;
                case 2:
//                    cliente.setRg((String) value);
                    break;
                default:
            }
        }else {
            ContaInvestimento c = (ContaInvestimento)lista.get(row);
            
            switch (col) {
                case 0:
                    c.getDono().setCpf((String) value); //if column 0 (code)
                    break;
                case 1:
                    c.setNumero((int) value);
                    break;
                case 2:
//                    cliente.setRg((String) value);
                    break;
                default:
            }
        }
        
        this.fireTableCellUpdated(row, col);
    }

    public void setListaConta(List<ContaI> contas) {
        this.lista = contas;
        this.fireTableDataChanged();
        //this.fireTableRowsInserted(0,contatos.size()-1);//update JTable
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        if(indice<0)
            indice=0;
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0,indice);//update JTable
    }

    public ContaI getConta(int linha){
        return lista.get(linha);
    }
}
