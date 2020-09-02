/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ufpr.sistemabanco.view.vinculaconta;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JOptionPane;
import org.ufpr.sistemabanco.controller.VinculaContaController;
import org.ufpr.sistemabanco.model.Cliente;
import org.ufpr.sistemabanco.model.ContaCorrente;
import org.ufpr.sistemabanco.model.ContaInvestimento;

/**
 *
 * @author Lia
 */
public class JanelaVinculaContaView extends javax.swing.JFrame {

    /**
     * Creates new form JanelaVinculaContaView
     */
    public JanelaVinculaContaView() {
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

        buscaClienteView = new org.ufpr.sistemabanco.view.vinculaconta.BuscaClienteView();
        tabelaClienteView = new org.ufpr.sistemabanco.view.vinculaconta.TabelaClienteView();
        tipoContaView = new org.ufpr.sistemabanco.view.vinculaconta.TipoContaView();
        panelConta = new javax.swing.JPanel();
        panelDefault = new javax.swing.JPanel();
        panelContaCorrente = new org.ufpr.sistemabanco.view.vinculaconta.ContaCorrenteView();
        panelContaInvestimento = new org.ufpr.sistemabanco.view.vinculaconta.ContaInvestimentoView();
        botaoNumeroConta = new org.ufpr.sistemabanco.view.vinculaconta.BotaoNumeroConta();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelConta.setToolTipText("");
        panelConta.setLayout(new java.awt.CardLayout());

        panelDefault.setForeground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout panelDefaultLayout = new javax.swing.GroupLayout(panelDefault);
        panelDefault.setLayout(panelDefaultLayout);
        panelDefaultLayout.setHorizontalGroup(
            panelDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDefaultLayout.setVerticalGroup(
            panelDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        panelConta.add(panelDefault, "card2");
        panelConta.add(panelContaCorrente, "card3");
        panelConta.add(panelContaInvestimento, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelConta, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tipoContaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(buscaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(tipoContaView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelConta, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoNumeroConta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.ufpr.sistemabanco.view.vinculaconta.BotaoNumeroConta botaoNumeroConta;
    private org.ufpr.sistemabanco.view.vinculaconta.BuscaClienteView buscaClienteView;
    private javax.swing.JPanel panelConta;
    private org.ufpr.sistemabanco.view.vinculaconta.ContaCorrenteView panelContaCorrente;
    private org.ufpr.sistemabanco.view.vinculaconta.ContaInvestimentoView panelContaInvestimento;
    private javax.swing.JPanel panelDefault;
    private org.ufpr.sistemabanco.view.vinculaconta.TabelaClienteView tabelaClienteView;
    private org.ufpr.sistemabanco.view.vinculaconta.TipoContaView tipoContaView;
    // End of variables declaration//GEN-END:variables

    private ClienteTableModel clienteTableModel = new ClienteTableModel();
    private int linhaClicada = -1;
    private String panelAtivo = "default";

    public void setController(VinculaContaController controller) {
        buscaClienteView.setController(controller);
        botaoNumeroConta.setController(controller);
        tipoContaView.setView(this);
        botaoNumeroConta.setView(this);
        controller.listarCliente();
        
    }
    
    public void mudarPanelCorrente(){
        System.out.println(panelAtivo);
        panelConta.removeAll();
        panelConta.repaint();
        panelConta.revalidate();
        
        panelConta.add(panelContaCorrente);
        panelConta.repaint();
        panelConta.revalidate();
        panelAtivo = "corrente";
    }
    
    public void mudarPanelInvestimento(){
        System.out.println(panelAtivo);
        panelConta.removeAll();
        panelConta.repaint();
        panelConta.revalidate();
        
        panelConta.add(panelContaInvestimento);
        panelConta.repaint();
        panelConta.revalidate();
         panelAtivo = "investimento";
    }
    
    public Cliente getClienteParaVincular(){
        linhaClicada = tabelaClienteView.getTabelaCliente().getSelectedRow();
        
        if (linhaClicada == -1){
            return null;
        }
        Cliente cliente = clienteTableModel.getCliente(linhaClicada);

        return cliente;
      }

    public void initView() {
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
        
        tabelaClienteView.getTabelaCliente().setModel(clienteTableModel);
    }

    public void mostrarListaClientes(List<Cliente> lista) {
        clienteTableModel.setListaCliente(lista);
    }

    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public String getBusca() {
        return buscaClienteView.getBuscaCampo().getText();
    }

    public String getPanelAtivo() {
        return panelAtivo;
    }

    public ContaCorrente getContaCorrente(Cliente cliente) {
        try{
            double depositoInicial = Double.parseDouble(panelContaCorrente.getDepositoCampo().getText().replace(",", "."));
            double limite = Double.parseDouble(panelContaCorrente.getLimiteCampo().getText().replace(",", "."));
            ContaCorrente contaCorrente = new ContaCorrente(limite, cliente, depositoInicial, 0);

            return contaCorrente;
        }catch(Exception e){
            if (e.getMessage().contains("empty String")){
                apresentaErro("Erro ao criar a conta. Preencha os campos da conta com valores numéricos.");
            }else{
                apresentaErro("Erro ao criar a conta.");
                e.printStackTrace();
            }
            return null;
        }
    }

    public ContaInvestimento ContaInvestimento(Cliente cliente) {
        try{
            double montanteMin = Double.parseDouble(panelContaInvestimento.getMontanteMinCampo().getText().replace(",", "."));
            double depositoMin = Double.parseDouble(panelContaInvestimento.getDepositoMinCampo().getText().replace(",", "."));
            double depositoInicial = Double.parseDouble(panelContaInvestimento.getDepositoInicialCampo().getText().replace(",", "."));

            ContaInvestimento contaInvestimento = new ContaInvestimento(montanteMin, depositoMin, cliente, depositoInicial, 0);

            return contaInvestimento;
        }catch(Exception e){
            if (e.getMessage().contains("empty String")){
                apresentaErro("Erro ao criar a conta. Preencha os campos da conta com valores numéricos.");
            }else{
                apresentaErro("Erro ao criar a conta.");
                e.printStackTrace();
            }
            return null;
        }
    }

    public void mostraNumeroConta(int numero) {
        botaoNumeroConta.getNumContaLabel().setText(String.format("Numero: %d",numero));
    }
}
