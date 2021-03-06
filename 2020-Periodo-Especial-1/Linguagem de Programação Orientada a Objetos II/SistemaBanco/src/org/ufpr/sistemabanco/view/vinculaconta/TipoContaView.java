/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.view.vinculaconta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lia
 */
public class TipoContaView extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form TipoContaView
     */
    public TipoContaView() {
        initComponents();
        
        btnSelecionaConta.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoContaLabel = new javax.swing.JLabel();
        tipoContaCombo = new javax.swing.JComboBox<>();
        btnSelecionaConta = new javax.swing.JButton();

        tipoContaLabel.setText("Tipo de conta:");

        tipoContaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta Corrente", "Conta Investimento" }));

        btnSelecionaConta.setText("Selecionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tipoContaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipoContaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnSelecionaConta)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoContaLabel)
                    .addComponent(tipoContaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionaConta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionaConta;
    private javax.swing.JComboBox<String> tipoContaCombo;
    private javax.swing.JLabel tipoContaLabel;
    // End of variables declaration//GEN-END:variables

    private JanelaVinculaContaView view;

    public void setView(JanelaVinculaContaView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tipoContaCombo.getSelectedIndex()==0){
            view.mudarPanelCorrente();
        } else if (tipoContaCombo.getSelectedIndex()==1){
            view.mudarPanelInvestimento();
        }
    }
}
