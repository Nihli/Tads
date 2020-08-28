/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.lpooii.view.autor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import org.ufpr.lpooii.model.Autor;

/**
 *
 * @author Lia
 */
public class FormularioAutorView extends javax.swing.JPanel {

    private Autor autorSelecionadoParaAtualizacao;
    /**
     * Creates new form FormularioAutorView
     */
    public FormularioAutorView() {
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

        nomeLabel = new javax.swing.JLabel();
        nomeCampo = new javax.swing.JTextField();
        dataNascimentoLabel = new javax.swing.JLabel();
        dataNascimentoCampo = new javax.swing.JFormattedTextField();
        documentoLabel = new javax.swing.JLabel();
        documentoCampo = new javax.swing.JTextField();
        naturalidadeLabel = new javax.swing.JLabel();
        naturalidadeCampo = new javax.swing.JTextField();
        livrosLabel = new javax.swing.JLabel();
        livrosCampo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        nomeLabel.setText("Nome:");

        dataNascimentoLabel.setText("Data de Nascimento:");

        try {
            dataNascimentoCampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        documentoLabel.setText("Documento:");

        naturalidadeLabel.setText("Naturalidade:");

        livrosLabel.setText("Livros:");

        jLabel2.setText("*separe por virgula se tiver mais de um livro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataNascimentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNascimentoCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(documentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(documentoCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(naturalidadeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(naturalidadeCampo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 119, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(livrosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(livrosCampo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataNascimentoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataNascimentoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(documentoLabel)
                    .addComponent(documentoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(naturalidadeLabel)
                    .addComponent(naturalidadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livrosLabel)
                    .addComponent(livrosCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public JFormattedTextField getDataNascimentoCampo() {
        return dataNascimentoCampo;
    }

    public JTextField getDocumentoCampo() {
        return documentoCampo;
    }

    public JTextField getLivrosCampo() {
        return livrosCampo;
    }

    public JTextField getNaturalidadeCampo() {
        return naturalidadeCampo;
    }

    public JTextField getNomeCampo() {
        return nomeCampo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataNascimentoCampo;
    private javax.swing.JLabel dataNascimentoLabel;
    private javax.swing.JTextField documentoCampo;
    private javax.swing.JLabel documentoLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField livrosCampo;
    private javax.swing.JLabel livrosLabel;
    private javax.swing.JTextField naturalidadeCampo;
    private javax.swing.JLabel naturalidadeLabel;
    private javax.swing.JTextField nomeCampo;
    private javax.swing.JLabel nomeLabel;
    // End of variables declaration//GEN-END:variables

    void setAutor(Autor autor) {
        autorSelecionadoParaAtualizacao = autor;
        
        dataNascimentoCampo.setText(autor.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        documentoCampo.setText(autor.getDocumento());
        naturalidadeCampo.setText(autor.getNacionalidade());
        nomeCampo.setText(autor.getNome());
        livrosCampo.setText(autor.getListaLivros());
    }

    public Autor getAutorSelecionadoParaAtualizacao() {
        if (autorSelecionadoParaAtualizacao==null) {
            return null;
        }
        
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoCampo.getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        autorSelecionadoParaAtualizacao.setDataNascimento(dataNascimento);
        autorSelecionadoParaAtualizacao.setDocumento(documentoCampo.getText());
        autorSelecionadoParaAtualizacao.setNacionalidade(naturalidadeCampo.getText());
        autorSelecionadoParaAtualizacao.setNome(nomeCampo.getText());
        autorSelecionadoParaAtualizacao.setListaLivros(livrosCampo.getText());
        
        return autorSelecionadoParaAtualizacao;
    }
    
    
}
