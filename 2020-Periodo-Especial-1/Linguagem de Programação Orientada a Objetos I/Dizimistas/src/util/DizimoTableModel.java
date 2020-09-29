/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Dizimo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lia
 */
public class DizimoTableModel extends AbstractTableModel{
 private String[] colunas=new String[]{"Valor mínimo","Valor", "Mês", "Ano"};

    private List<Dizimo> lista=new ArrayList();
    
    public List<Dizimo> getLista(){
       return lista;
    }

    
    public DizimoTableModel(List<Dizimo> lista){
        this.lista=lista;
    }

    public DizimoTableModel(){
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
        Dizimo dizimo = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return dizimo.getValorMinimo();//if column 0 (code)
            case 1: return dizimo.getValor();//if column 1 (name)
            case 2: return dizimo.getMes();//if column 2 (birthday)
            case 3: return dizimo.getAno();
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Dizimo dizimo = lista.get(row);
        switch (col) {
            case 0:
                dizimo.setValorMinimo((double) value); //if column 0 (code)
                break;
            case 1:
                dizimo.setValor((double) value);
                break;
            case 2:
                dizimo.setMes((String) value);
                break;
            case 3:
                dizimo.setAno((String) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeDizimo(Dizimo dizimo) {
        int linha = this.lista.indexOf(dizimo);
        boolean result = this.lista.remove(dizimo);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }
    
    public void atualizaTable(){
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void adicionaDizimo(Dizimo dizimo) {
        this.lista.add(dizimo);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaDizimo(List<Dizimo> dizimos) {
        this.lista = dizimos;
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

    public Dizimo getDizimo(int linha){
        return lista.get(linha);
    }

    public void removeDizimo(List<Dizimo> listaParaExcluir) {
        listaParaExcluir.forEach((dizimo) -> {
            removeDizimo(dizimo);
        });
    }
}
