/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.view.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.ufpr.sistemabanco.controller.ClienteController;

/**
 *
 * @author Lia
 */
public class botoesClienteView extends javax.swing.JPanel {

    /**
     * Creates new form botoesClienteView
     */
    public botoesClienteView() {
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

        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();

        btnAtualizar.setText("Atualizar");

        btnExcluir.setText("Excluir");

        btnListar.setText("Listar");

        btnCriar.setText("Criar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnListar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListar;
    // End of variables declaration//GEN-END:variables

    void setController(ClienteController controller) {
      this.btnCriar.addActionListener(e -> controller.criarCliente());
      this.btnAtualizar.addActionListener(e -> controller.atualizarCliente());
      this.btnExcluir.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse cliente?\nAo excluir um cliente, todas as contas vinculadas a ele serão excluídas também." + "\n", "Confirmar exclusão", JOptionPane.OK_CANCEL_OPTION);
          
            if (resposta == JOptionPane.OK_OPTION) {
                controller.excluirCliente();
            }
          }
      });
      this.btnListar.addActionListener(e -> controller.listarCliente());
    }
}
