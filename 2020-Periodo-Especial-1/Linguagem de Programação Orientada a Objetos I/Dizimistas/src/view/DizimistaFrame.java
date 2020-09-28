/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.GerenciadorDados;
import entity.Dizimista;
import entity.Igreja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import util.DizimistaComboBoxModel;
import util.DizimistaTableModel;

/**
 *
 * @author Lia
 */
public class DizimistaFrame extends javax.swing.JFrame implements ActionListener {

    private List<Dizimista> entregadorList = new ArrayList();
    private Igreja igreja = null;
    private DizimistaTableModel dizimistaTableModel = new DizimistaTableModel();

    /**
     * Creates new form DizimistaFrame
     */
    public DizimistaFrame() {
        initComponents();

        setLocationRelativeTo(null);

        tabelaDizimista.setModel(dizimistaTableModel);

        btnCriar.addActionListener(this);
        btnListar.addActionListener(this);
        btnExcluir.addActionListener(this);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotoes = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        panelFormulario = new javax.swing.JPanel();
        labelNome = new javax.swing.JLabel();
        nomeText = new javax.swing.JTextField();
        labelEndereco = new javax.swing.JLabel();
        enderecoText = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        labelEntregador = new javax.swing.JLabel();
        comboEntregador = new javax.swing.JComboBox<>();
        cpfText = new javax.swing.JTextField();
        scrollPanel = new javax.swing.JScrollPane();
        tabelaDizimista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setActionCommand("atualizarDizimista");

        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("excluirDizimista");

        btnListar.setText("Listar");
        btnListar.setActionCommand("listarDizimista");

        btnCriar.setText("Criar");
        btnCriar.setActionCommand("criarDizimista");

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir)
                    .addComponent(btnListar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelNome.setText("Nome:");

        labelEndereco.setText("Endereço:");

        labelCpf.setText("CPF:");

        labelEntregador.setText("Entregador do dízimo:");

        comboEntregador.setModel(new DizimistaComboBoxModel(entregadorList));

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(labelEntregador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEntregador, 0, 302, Short.MAX_VALUE))
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEndereco)
                            .addComponent(labelNome)
                            .addComponent(labelCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpfText)
                            .addComponent(nomeText)
                            .addComponent(enderecoText))))
                .addContainerGap())
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEndereco)
                    .addComponent(enderecoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCpf)
                    .addComponent(cpfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEntregador)
                    .addComponent(comboEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tabelaDizimista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPanel.setViewportView(tabelaDizimista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DizimistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DizimistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DizimistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DizimistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DizimistaFrame().setVisible(true);
            }
        });
    }

    public void setIgreja(Igreja igreja) {
        this.igreja = igreja;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnListar;
    private javax.swing.JComboBox<Dizimista> comboEntregador;
    private javax.swing.JTextField cpfText;
    private javax.swing.JTextField enderecoText;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelEntregador;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField nomeText;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JTable tabelaDizimista;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        GerenciadorDados bd = GerenciadorDados.getInstance();

        switch (cmd) {
            case "criarDizimista":
                Dizimista dizimista = getDizimistaFormulario();

                bd.setDizimistaIgreja(igreja, dizimista);

                atualizaComboEntregador(dizimista);
                dizimistaTableModel.adicionaDizimista(dizimista);
                break;
            case "listarDizimista":
                dizimistaTableModel.setListaDizimista(igreja.getDizimistas());
                break;
            case "excluirDizimista":
                List<Dizimista> dizimistas = getDizimistasParaExcluir();
                
                bd.removeDizimistaIgreja(dizimistas, igreja);
                
                dizimistaTableModel.removeDizimistas(dizimistas);
                break;
        }
    }

    private List<Dizimista> getDizimistasParaExcluir() {
        int[] linhasSelecionadas = this.tabelaDizimista.getSelectedRows();
        List<Dizimista> listaExcluir = new ArrayList();

        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Dizimista dizimista = dizimistaTableModel.getDizimista(linhasSelecionadas[i]);
            listaExcluir.add(dizimista);
        }

        return listaExcluir;
    }

    private Dizimista getDizimistaFormulario() {
//      String matricula = formularioClienteView.getNomeCampo().getText();
        String nome = nomeText.getText();
        String endereco = enderecoText.getText();
        String cpf = cpfText.getText();
        Dizimista entregador = (Dizimista) comboEntregador.getSelectedItem();

        return new Dizimista(nome, endereco, cpf, entregador);
    }

    private void atualizaComboEntregador(Dizimista dizimista) {
        GerenciadorDados bd = GerenciadorDados.getInstance();
        int index = bd.getIgrejaList().indexOf(igreja);
        entregadorList = bd.getIgrejaList().get(index).getDizimistas();
        comboEntregador.setModel(new DizimistaComboBoxModel(entregadorList));
    }
}
