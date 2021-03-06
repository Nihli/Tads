/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.view.livro;

import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.ufpr.lpooii.controller.LivroController;
import org.ufpr.lpooii.model.Autor;
import org.ufpr.lpooii.model.Livro;

/**
 *
 * @author Lia
 */
public class JanelaLivroView extends javax.swing.JFrame {

    private LivroTableModel livroTableModel = new LivroTableModel();    
    private LivroController livroController;
    private int linhaClicadoParaAtualizacao = -1;
    /**
     * Creates new form JanelaLivroView
     */
    public JanelaLivroView() {
        initComponents();
        formularioLivroView.setJanelaLivroView(this);
        
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botoesLivroView = new org.ufpr.lpooii.view.livro.BotoesLivroView();
        tabelaLivroView = new org.ufpr.lpooii.view.livro.TabelaLivroView();
        formularioLivroView = new org.ufpr.lpooii.view.livro.FormularioLivroView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botoesLivroView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaLivroView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(formularioLivroView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botoesLivroView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaLivroView, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formularioLivroView, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.ufpr.lpooii.view.livro.BotoesLivroView botoesLivroView;
    private org.ufpr.lpooii.view.livro.FormularioLivroView formularioLivroView;
    private org.ufpr.lpooii.view.livro.TabelaLivroView tabelaLivroView;
    // End of variables declaration//GEN-END:variables

    public void setController(LivroController controller) {
        botoesLivroView.setController(controller);
        livroController = controller;
        
        tabelaLivroView.getTabelaLivro().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                linhaClicadoParaAtualizacao = tabelaLivroView.getTabelaLivro().rowAtPoint(evt.getPoint());
                
                Livro livro = livroTableModel.getLivro(linhaClicadoParaAtualizacao);
                
                formularioLivroView.setLivro(livro);
            }
        });
    }

    public void initView() {
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
        
        tabelaLivroView.getTabelaLivro().setModel(livroTableModel);
    }

    public Livro getLivroFormulario() {
        String titulo = formularioLivroView.getTituloCampo().getText();
        String assunto = formularioLivroView.getAssuntoCampo().getText();
        String codigoIsbn = formularioLivroView.getCodigoIsbnCampo().getText();
        String[] arrayAutores = formularioLivroView.getAutoresCampo().getText().split(";");
        LocalDate dataPublicacao = LocalDate.parse(formularioLivroView.getDataPublicacaoCampo().getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        List<Autor> autores = new ArrayList();
        
        for(int i=0;i<arrayAutores.length;i++){
            arrayAutores[i] = arrayAutores[i].trim();
            if (arrayAutores[i]!=""&&arrayAutores[i].matches("[0-9]+")){
                Autor a = livroController.consultarAutor(Integer.parseInt(arrayAutores[i]));
                
                if (a!=null){
                    autores.add(a);
                }
            }
        }
    
        return new Livro(titulo, assunto, codigoIsbn, dataPublicacao, autores);
    }

    public void inserirLivroView(Livro livro) {
        livroTableModel.adicionaLivro(livro);
    }

    public void mostrarListaAutores(List<Livro> lista) {
        livroTableModel.setListaLivro(lista);
    }

    public List<Livro> getLivrosParaExcluir() {
        int[] linhasSelecionadas = this.tabelaLivroView.getTabelaLivro().getSelectedRows();
        
        List<Livro> listaExcluir = new ArrayList();
        
        for (int i=0;i<linhasSelecionadas.length;i++) {
            Livro livro = livroTableModel.getLivro(linhasSelecionadas[i]);
            listaExcluir.add(livro);
        }
        
        return listaExcluir;
    }

    public void excluirLivroView(List<Livro> listaParaExcluir) {
        livroTableModel.removeLivros(listaParaExcluir);
    }

    public Livro getLivroParaAtualizar() {
//        return formularioLivroView.getLivroSelecionadoParaAtualizacao();
        
        Livro livro = formularioLivroView.getLivroSelecionadoParaAtualizacao();
        System.out.println(livro.getListaAutores());
        String[] arrayAutores = livro.getListaAutores().split(";");
        
        List<Autor> autores = new ArrayList();
        
        for(int i=0;i<arrayAutores.length;i++){
            arrayAutores[i] = arrayAutores[i].trim();
            if (arrayAutores[i]!=""&&arrayAutores[i].matches("[0-9]+")){
                Autor a = livroController.consultarAutor(Integer.parseInt(arrayAutores[i]));
                System.out.println(a.getId());
                if (a!=null){
                    autores.add(a);
                }
            }
        }
        
        livro.setAutores(autores, 2);
        
        return livro;
    }

    public void atualizarLivro(Livro livro) {
        livroTableModel.fireTableRowsUpdated(linhaClicadoParaAtualizacao, linhaClicadoParaAtualizacao);
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
