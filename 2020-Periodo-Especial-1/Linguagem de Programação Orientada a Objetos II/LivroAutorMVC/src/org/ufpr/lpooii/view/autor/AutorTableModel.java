/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.view.autor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.ufpr.lpooii.model.Autor;
import org.ufpr.lpooii.model.Livro;

/**
 *
 * @author Lia
 */
public class AutorTableModel extends AbstractTableModel{
 private String[] colunas=new String[]{"id","Nome", "Nascimento", "Documento","Nacionalidade", "Livros"};

    private List<Autor> lista=new ArrayList();

    
    public AutorTableModel(List<Autor> lista){
        this.lista=lista;
    }

    public AutorTableModel(){
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
        Autor autor = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return autor.getId();//if column 0 (code)
            case 1: return autor.getNome();//if column 1 (name)
            case 2: return autor.getDataNascimento();//if column 2 (birthday)
            case 3: return autor.getDocumento();
            case 4: return autor.getNacionalidade() ;
            case 5: return autor.getListaLivros();
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Autor autor = lista.get(row);
        switch (col) {
            case 0:
                autor.setId((int) value); //if column 0 (code)
                break;
            case 1:
                autor.setNome((String) value);
                break;
            case 2:
                LocalDate data = LocalDate.parse((String)value);
                autor.setDataNascimento(data);
                break;
            case 3:
                autor.setDocumento((String) value);
                break;
            case 4:
                autor.setNacionalidade((String) value);
                break;
            case 5:
//                for (Livro l : autor.getLivros()){
//                    autor.setListaLivros(autor.getListaLivros()+String.valueOf(l.getId()));
//                }
                autor.setListaLivros();
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeAutor(Autor autor) {
        int linha = this.lista.indexOf(autor);
        boolean result = this.lista.remove(autor);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaAutor(Autor autor) {
        this.lista.add(autor);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaAutor(List<Autor> autores) {
        this.lista = autores;
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

    public Autor getAutor(int linha){
        return lista.get(linha);
    }

    void removeAutores(List<Autor> listaParaExcluir) {
        listaParaExcluir.forEach((autor) -> {
            removeAutor(autor);
        });
    }
}
