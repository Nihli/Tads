/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.view.livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.ufpr.lpooii.model.Livro;

/**
 *
 * @author Lia
 */
public class LivroTableModel extends AbstractTableModel{
 private String[] colunas=new String[]{"id","Titulo", "Publicacao", "Assunto","Cod Isbn", "Autores"};

    private List<Livro> lista=new ArrayList();

    
    public LivroTableModel(List<Livro> lista){
        this.lista=lista;
    }

    public LivroTableModel(){
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
        Livro livro = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return livro.getId();//if column 0 (code)
            case 1: return livro.getTitulo();//if column 1 (name)
            case 2: return livro.getDataPublicacao();//if column 2 (birthday)
            case 3: return livro.getAssunto();
            case 4: return livro.getCodigoIsbn() ;
            case 5: return livro.getListaLivros();
            default : return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Livro livro = lista.get(row);
        switch (col) {
            case 0:
                livro.setId((int) value); //if column 0 (code)
                break;
            case 1:
                livro.setTitulo((String) value);
                break;
            case 2:
                LocalDate data = LocalDate.parse((String)value);
                livro.setDataPublicacao(data);
                break;
            case 3:
                livro.setAssunto((String) value);
                break;
            case 4:
                livro.setCodigoIsbn((String) value);
                break;
            case 5:
//                for (Livro l : autor.getLivros()){
//                    autor.setListaLivros(autor.getListaLivros()+String.valueOf(l.getId()));
//                }
                livro.setListaLivros();
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public boolean removeLivro(Livro livro) {
        int linha = this.lista.indexOf(livro);
        boolean result = this.lista.remove(livro);
        this.fireTableRowsDeleted(linha,linha);//update JTable
        return result;
    }

    public void adicionaLivro(Livro livro) {
        this.lista.add(livro);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lista.size()-1,lista.size()-1);//update JTable
    }

    public void setListaLivro(List<Livro> livros) {
        this.lista = livros;
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

    public Livro getLivro(int linha){
        return lista.get(linha);
    }

    void removeAutores(List<Livro> listaParaExcluir) {
        listaParaExcluir.forEach((Livro) -> {
            removeLivro(Livro);
        });
    }
}
