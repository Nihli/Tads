/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.view.livro;

import org.ufpr.lpooii.view.autor.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import org.ufpr.lpooii.model.Autor;
import org.ufpr.lpooii.model.Livro;

/**
 *
 * @author Lia
 */
public class FormularioLivroView extends javax.swing.JPanel {

    private Livro livroSelecionadoParaAtualizacao;
    /**
     * Creates new form FormularioAutorView
     */
    public FormularioLivroView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloLabel = new javax.swing.JLabel();
        tituloCampo = new javax.swing.JTextField();
        dataPublicacaoLabel = new javax.swing.JLabel();
        dataPublicacaoCampo = new javax.swing.JFormattedTextField();
        assuntoLabel = new javax.swing.JLabel();
        assuntoCampo = new javax.swing.JTextField();
        codIsbnLabel = new javax.swing.JLabel();
        codigoIsbnCampo = new javax.swing.JTextField();
        autoresLabel = new javax.swing.JLabel();
        autoresCampo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        tituloLabel.setText("Titulo:");

        dataPublicacaoLabel.setText("Data de Publicação:");

        try {
            dataPublicacaoCampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        assuntoLabel.setText("Assunto:");

        codIsbnLabel.setText("Código Isbn:");

        autoresLabel.setText("Autores:");

        jLabel2.setText("*separe por ponto e virgula se tiver mais de um livro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tituloCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataPublicacaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataPublicacaoCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(assuntoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assuntoCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codIsbnLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoIsbnCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 72, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(autoresLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoresCampo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloLabel)
                    .addComponent(tituloCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataPublicacaoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataPublicacaoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assuntoLabel)
                    .addComponent(assuntoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codIsbnLabel)
                    .addComponent(codigoIsbnCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoresLabel)
                    .addComponent(autoresCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getAssuntoCampo() {
        return assuntoCampo;
    }

    public JTextField getAutoresCampo() {
        return autoresCampo;
    }

    public JTextField getCodigoIsbnCampo() {
        return codigoIsbnCampo;
    }

    public JFormattedTextField getDataPublicacaoCampo() {
        return dataPublicacaoCampo;
    }

    public JTextField getTituloCampo() {
        return tituloCampo;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField assuntoCampo;
    private javax.swing.JLabel assuntoLabel;
    private javax.swing.JTextField autoresCampo;
    private javax.swing.JLabel autoresLabel;
    private javax.swing.JLabel codIsbnLabel;
    private javax.swing.JTextField codigoIsbnCampo;
    private javax.swing.JFormattedTextField dataPublicacaoCampo;
    private javax.swing.JLabel dataPublicacaoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tituloCampo;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables

    void setLivro(Livro livro) {
        livroSelecionadoParaAtualizacao = livro;
        
        dataPublicacaoCampo.setText(livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        assuntoCampo.setText(livro.getAssunto());
        codigoIsbnCampo.setText(livro.getCodigoIsbn());
        tituloCampo.setText(livro.getTitulo());
        autoresCampo.setText(livro.getListaAutores());
    }


    public Livro getLivroSelecionadoParaAtualizacao() {
        if (livroSelecionadoParaAtualizacao==null) {
            return null;
        }
        
        LocalDate dataNascimento = LocalDate.parse(dataPublicacaoCampo.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        livroSelecionadoParaAtualizacao.setDataPublicacao(dataNascimento);
        livroSelecionadoParaAtualizacao.setAssunto(assuntoCampo.getText());
        livroSelecionadoParaAtualizacao.setCodigoIsbn(codigoIsbnCampo.getText());
        livroSelecionadoParaAtualizacao.setTitulo(tituloCampo.getText());
        livroSelecionadoParaAtualizacao.setListaAutores(autoresCampo.getText());
        
        return livroSelecionadoParaAtualizacao;
    }
    
}
