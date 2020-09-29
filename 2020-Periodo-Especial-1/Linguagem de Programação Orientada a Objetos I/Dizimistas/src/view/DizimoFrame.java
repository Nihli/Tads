/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.GerenciadorDados;
import dao.IODadosXML;
import entity.Dizimista;
import entity.Dizimo;
import entity.Igreja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.DizimoTableModel;

/**
 *
 * @author Lia
 */
public class DizimoFrame extends javax.swing.JFrame implements ActionListener {

    private Igreja igreja;
    private Dizimista dizimista;
    private DizimoTableModel dizimoTableModel = new DizimoTableModel();

    /**
     * Creates new form DizimoFrame
     */
    public DizimoFrame(Igreja igreja, Dizimista dizimista) {
        this.igreja = igreja;
        this.dizimista = dizimista;

//        dizimistaText.setText(this.dizimista.getNome());
        GerenciadorDados bd = GerenciadorDados.getInstance();
        dizimoTableModel.setListaDizimo(bd.getDizimos(igreja, dizimista));

        initComponents();

        setLocationRelativeTo(null);

        tabelaDizimo.setModel(dizimoTableModel);

        btnCriar.addActionListener(this);
//        btnListar.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnVoltar.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        btnExcluir = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaDizimo = new javax.swing.JTable();
        panelFormulario = new javax.swing.JPanel();
        labelValor = new javax.swing.JLabel();
        valorText = new javax.swing.JTextField();
        labelValorMin = new javax.swing.JLabel();
        valorMinText = new javax.swing.JTextField();
        labelMes = new javax.swing.JLabel();
        comboMes = new javax.swing.JComboBox<>();
        labelAno = new javax.swing.JLabel();
        anoText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dizimistaText = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("excluirDizimo");

        btnCriar.setText("Criar");
        btnCriar.setActionCommand("criarDizimo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnCriar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaDizimo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaDizimo);

        labelValor.setText("Valor:");

        labelValorMin.setText("Valor mínimo:");

        labelMes.setText("Mês:");

        comboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        labelAno.setText("Ano:");

        anoText.setEditable(false);
        anoText.setText("2020");

        javax.swing.GroupLayout panelFormularioLayout = new javax.swing.GroupLayout(panelFormulario);
        panelFormulario.setLayout(panelFormularioLayout);
        panelFormularioLayout.setHorizontalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelValorMin)
                    .addComponent(labelValor)
                    .addComponent(labelMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorText)
                    .addComponent(valorMinText)
                    .addGroup(panelFormularioLayout.createSequentialGroup()
                        .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(labelAno)
                        .addGap(112, 112, 112)
                        .addComponent(anoText, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelFormularioLayout.setVerticalGroup(
            panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor)
                    .addComponent(valorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValorMin)
                    .addComponent(valorMinText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMes)
                    .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAno)
                    .addComponent(anoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Dizimista:");

        dizimistaText.setEditable(false);
        dizimistaText.setText(this.dizimista.getNome());

        btnVoltar.setText("< Voltar");
        btnVoltar.setActionCommand("voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dizimistaText, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dizimistaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DizimoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DizimoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DizimoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DizimoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DizimoFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anoText;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> comboMes;
    private javax.swing.JTextField dizimistaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelMes;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelValorMin;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JTable tabelaDizimo;
    private javax.swing.JTextField valorMinText;
    private javax.swing.JTextField valorText;
    // End of variables declaration//GEN-END:variables

//    void setIgreja(Igreja igreja) {
//        this.igreja = igreja;
//    }
//
//    void setDizimista(Dizimista dizimistaFormulario) {
//        this.dizimista=dizimistaFormulario;
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        GerenciadorDados bd = GerenciadorDados.getInstance();

        switch (cmd) {
            case "criarDizimo":
                try {
                    Dizimo dizimo = getDizimoFormulario();

                    if (dizimo == null) {
                        JOptionPane.showMessageDialog(null, "Valor pago deve ser maior do que o valor mínimo a ser pago." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {

                        boolean inserido = bd.setDizimoNoDizimista(igreja, dizimista, dizimo);

                        if (!inserido) {
                            JOptionPane.showMessageDialog(null, "Já existe um dízimo referente a esse mês e ano." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                        }

                        IODadosXML.salvar("./dados.xml", bd);

                        dizimoTableModel.atualizaTable();

                        limparFormulario();
                    }
//                dizimoTableModel.adicionaDizimo(dizimo);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
//            case "listarDizimo":
//                List<Dizimo> lista = bd.getDizimos(igreja, dizimista);
//                dizimoTableModel.setListaDizimo(lista);
//                break;
            case "excluirDizimo":
                List<Dizimo> listaParaExcluir = getDizimosParaExcluir();

                bd.removeDizimo(igreja, dizimista, listaParaExcluir);
                IODadosXML.salvar("./dados.xml", bd);

                dizimoTableModel.removeDizimo(listaParaExcluir);

                break;
            case "voltar":
                DizimistaFrame frame = new DizimistaFrame(igreja);
                frame.setVisible(true);
                this.dispose();
        }
    }

    private Dizimo getDizimoFormulario() {
        try {
            double valor = Double.parseDouble(valorText.getText().replace(",", "."));
            double valorMin = Double.parseDouble(valorMinText.getText().replace(",", "."));
            String mes = (String) comboMes.getSelectedItem();
            String ano = anoText.getText();

            if (valor < valorMin) {
                return null;
            }

            return new Dizimo(valor, valorMin, mes, ano);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Entre apenas com valores numéricos no campo valor e valor mínimo.");
        }
    }

    private List<Dizimo> getDizimosParaExcluir() {
        int[] linhasSelecionadas = this.tabelaDizimo.getSelectedRows();
        List<Dizimo> listaExcluir = new ArrayList();

        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Dizimo dizimos = dizimoTableModel.getDizimo(linhasSelecionadas[i]);
            listaExcluir.add(dizimos);
        }

        return listaExcluir;
    }

    private void limparFormulario() {
        valorText.setText("");
        valorMinText.setText("");
        comboMes.setSelectedIndex(0);
    }
}
