/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.GerenciadorDados;
import entity.Igreja;
import java.util.List;
import javax.swing.JOptionPane;
import util.IgrejaComboBoxModel;

/**
 *
 * @author Lia
 */
public class FrameInicial extends javax.swing.JFrame {

    List<Igreja> igrejaList = null;

    /**
     * Creates new form FrameInicial
     */
    public FrameInicial() {
        GerenciadorDados bd = GerenciadorDados.getInstance();
        igrejaList = bd.getIgrejaList();

        initComponents();

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

        panelTitulo = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        PanelIgreja = new javax.swing.JPanel();
        labelEscolhaIgreja = new javax.swing.JLabel();
        comboIgrejas = new javax.swing.JComboBox<>();
        btnIgreja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        labelTitulo.setText("Controle de Dizimistas");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addGap(85, 85, 85))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(labelTitulo)
                .addContainerGap())
        );

        labelEscolhaIgreja.setText("Escolha a Igreja desejada:");

        comboIgrejas.setModel(new IgrejaComboBoxModel(igrejaList));

        btnIgreja.setText("Entrar");
        btnIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgrejaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelIgrejaLayout = new javax.swing.GroupLayout(PanelIgreja);
        PanelIgreja.setLayout(PanelIgrejaLayout);
        PanelIgrejaLayout.setHorizontalGroup(
            PanelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIgrejaLayout.createSequentialGroup()
                .addGroup(PanelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIgrejaLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnIgreja))
                    .addGroup(PanelIgrejaLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(comboIgrejas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIgrejaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelEscolhaIgreja)
                .addGap(120, 120, 120))
        );
        PanelIgrejaLayout.setVerticalGroup(
            PanelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIgrejaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelEscolhaIgreja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboIgrejas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnIgreja)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelIgreja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgrejaActionPerformed
        try {
            Igreja item = (Igreja) comboIgrejas.getSelectedItem();

            String nome = item.getNome();

            GerenciadorDados bd = GerenciadorDados.getInstance();

            for (Igreja i : bd.getIgrejaList()) {
                if (i.getNome().equals(nome)) {
                    DizimistaFrame frame = new DizimistaFrame(item);
                    frame.setVisible(true);
                    this.dispose();
                    break;
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Escolha uma igreja antes de continuar." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIgrejaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelIgreja;
    private javax.swing.JButton btnIgreja;
    private javax.swing.JComboBox<Igreja> comboIgrejas;
    private javax.swing.JLabel labelEscolhaIgreja;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}
