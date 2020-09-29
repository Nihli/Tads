/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.GerenciadorDados;
import dao.IODadosXML;
import entity.Dizimista;
import entity.Igreja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
    private int linhaClicadoParaAtualizacao = -1;
    private Dizimista dizimistaSelecionadoParaAtualizacao;


    /**
     * Creates new form DizimistaFrame
     */
    public DizimistaFrame(Igreja igreja) {
        this.igreja = igreja;

        dizimistaTableModel.setListaDizimista(igreja.getDizimistas());

        GerenciadorDados bd = GerenciadorDados.getInstance();
        int index = bd.getIgrejaList().indexOf(igreja);
        entregadorList = bd.getIgrejaList().get(index).getDizimistas();

        initComponents();

        setLocationRelativeTo(null);

        tabelaDizimista.setModel(dizimistaTableModel);

        btnCriar.addActionListener(this);
//        btnListar.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnAtualizar.addActionListener(this);
        btnDizimo.addActionListener(this);
        btnVoltar.addActionListener(this);

        tabelaDizimista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limparFormulario();

                linhaClicadoParaAtualizacao = tabelaDizimista.rowAtPoint(evt.getPoint());

                Dizimista dizimista = dizimistaTableModel.getDizimista(linhaClicadoParaAtualizacao);

                dizimistaSelecionadoParaAtualizacao = dizimista;
                setDizimistaNoFormulario(dizimista);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        panelBotoes = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        btnDizimo = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                        .addComponent(comboEntregador, 0, 440, Short.MAX_VALUE))
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
                .addGap(71, 71, 71)
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

        btnAtualizar.setText("Atualizar");
        btnAtualizar.setActionCommand("atualizarDizimista");

        btnExcluir.setText("Excluir");
        btnExcluir.setActionCommand("excluirDizimista");

        btnCriar.setText("Criar");
        btnCriar.setActionCommand("criarDizimista");

        btnDizimo.setText("Dízimo");
        btnDizimo.setActionCommand("abrirDizimo");

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btnDizimo)
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
                    .addComponent(btnDizimo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVoltar.setText("< Voltar");
        btnVoltar.setActionCommand("voltar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnDizimo;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
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
                try {
                    Dizimista dizimista = getDizimistaFormulario();

                    boolean inserido = bd.setDizimistaIgreja(igreja, dizimista);

                    if (!inserido) {
                        JOptionPane.showMessageDialog(null, "Já existe um dizimista com esse CPF cadastrado." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                    } else {

                        IODadosXML.salvar("./dados.xml", bd);

                        atualizaComboEntregador(dizimista);

                        dizimistaTableModel.atualizaTable();

                        limparFormulario();

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage() + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "excluirDizimista":
                List<Dizimista> dizimistas = getDizimistasParaExcluir();

                if (dizimistas == null) {
                    JOptionPane.showMessageDialog(null, "Escolha um dizimista para remover." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                
                    bd.removeDizimistaIgreja(dizimistas, igreja);
                    IODadosXML.salvar("./dados.xml", bd);

                    dizimistaTableModel.removeDizimistas(dizimistas);

                    limparFormulario();
                }
                break;
            case "atualizarDizimista":
                if (linhaClicadoParaAtualizacao == -1) {
                    JOptionPane.showMessageDialog(null, "Escolha um dizimista para atualizar." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Dizimista dizimistaAtt = getDizimistaFormulario();

                    bd.atualizaDizimista(dizimistaAtt, igreja);
                    IODadosXML.salvar("./dados.xml", bd);

                    atualizarDizimista();

                    limparFormulario();
                }
                break;
            case "abrirDizimo":
                if (linhaClicadoParaAtualizacao == -1) {
                    JOptionPane.showMessageDialog(null, "Escolha um dizimista para acessar o dízimo." + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    DizimoFrame frame = new DizimoFrame(igreja, dizimistaSelecionadoParaAtualizacao);
                    frame.setVisible(true);
                    this.dispose();
                }
                break;
            case "voltar":
                FrameInicial frame = new FrameInicial();
                frame.setVisible(true);
                this.dispose();
                break;
        }
    }

    private List<Dizimista> getDizimistasParaExcluir() {
        int[] linhasSelecionadas = this.tabelaDizimista.getSelectedRows();
        List<Dizimista> listaExcluir = new ArrayList();
        
        if (linhasSelecionadas.length==0){
            return null;
        }

        for (int i = 0; i < linhasSelecionadas.length; i++) {
            Dizimista dizimista = dizimistaTableModel.getDizimista(linhasSelecionadas[i]);
            listaExcluir.add(dizimista);
        }

        return listaExcluir;
    }

    private Dizimista getDizimistaFormulario() {
        String nome = nomeText.getText();
        String endereco = enderecoText.getText();
        String cpf = cpfText.getText();
        Dizimista entregador = (Dizimista) comboEntregador.getSelectedItem();

        if (nome.isEmpty()||endereco.isEmpty()){
            throw new RuntimeException("Nome e endereço devem ser preenchidos antes de criar o dizimista.");
        }
        
        if (cpf.length() != 11) {
            throw new RuntimeException("CPF deve possuir 11 caracteres, somente numéricos.");
        }

        return new Dizimista(nome, endereco, cpf, entregador);
    }

    private void atualizaComboEntregador(Dizimista dizimista) {
        GerenciadorDados bd = GerenciadorDados.getInstance();
        int index = bd.getIgrejaList().indexOf(igreja);
        entregadorList = bd.getIgrejaList().get(index).getDizimistas();
        comboEntregador.setModel(new DizimistaComboBoxModel(entregadorList));
    }

    private void setDizimistaNoFormulario(Dizimista dizimista) {
        nomeText.setText(dizimista.getNome());
        enderecoText.setText(dizimista.getEndereco());
        cpfText.setText(dizimista.getCPF());

        int index = entregadorList.indexOf(dizimista.getEntregadorDizimo());

        comboEntregador.setSelectedIndex(index);
    }

    private void atualizarDizimista() {
        dizimistaTableModel.fireTableRowsUpdated(linhaClicadoParaAtualizacao, linhaClicadoParaAtualizacao);
    }

    private void limparFormulario() {
        nomeText.setText("");
        enderecoText.setText("");
        cpfText.setText("");
        comboEntregador.setModel(new DizimistaComboBoxModel(entregadorList));
    }
}
