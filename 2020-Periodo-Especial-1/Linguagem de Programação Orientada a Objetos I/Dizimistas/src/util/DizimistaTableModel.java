/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Dizimista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lia
 */
public class DizimistaTableModel extends AbstractTableModel{
 private String[] colunas=new String[]{"Matricula","Nome", "Endereço", "CPF","Entregador"};

    private List<Dizimista> lista=new ArrayList();

    
    public DizimistaTableModel(List<Dizimista> lista){
        this.lista=lista;
    }

    public DizimistaTableModel(){
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
        Dizimista dizimista = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return dizimista.getMatricula();//if column 0 (code)
            case 1: return dizimista.getNome();//if column 1 (name)
            case 2: return dizimista.getEndereco();//if column 2 (birthday)
            case 3: return dizimista.getCPF();
            case 4: return dizimista.getEntregadorDizimo();
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Dizimista dizimista = lista.get(row);
        switch (col) {
            case 0:
                dizimista.setMatricula((int) value); //if column 0 (code)
                break;
            case 1:
                dizimista.setNome((String) value);
                break;
            case 2:
                dizimista.setEndereco((String) value);
                break;
            case 3:
                dizimista.setCPF((String) value);
                break;
            case 4:
                dizimista.setEntregadorDizimo((Dizimista) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeDizimista(Dizimista dizimista) {
        int linha = this.lista.indexOf(dizimista);
        boolean result = this.lista.remove(dizimista);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaDizimista(Dizimista dizimista) {
        this.lista.add(dizimista);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaDizimista(List<Dizimista> dizimistas) {
        this.lista = dizimistas;
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

    public Dizimista getDizimista(int linha){
        return lista.get(linha);
    }

    void removeDizimistas(List<Dizimista> listaParaExcluir) {
        listaParaExcluir.forEach((cliente) -> {
            removeDizimista(cliente);
        });
    }
}
