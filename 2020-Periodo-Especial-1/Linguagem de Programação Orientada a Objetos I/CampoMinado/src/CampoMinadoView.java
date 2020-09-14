
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class CampoMinadoView extends javax.swing.JFrame{

   private List<Integer> bombas;
   private int marcadores = 0;
    
    /**
     * Creates new form CampoMinadoView
     */
    public CampoMinadoView() {
        initComponents();
        
        setSize(400,400);
        setLocationRelativeTo(null);
        
        btnReinicia.setIcon(new ImageIcon(getClass().getResource("/happypqn.png")));   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        btnReinicia = new javax.swing.JButton();
        qtd1Marcador = new javax.swing.JLabel();
        qtd2Marcador = new javax.swing.JLabel();
        jogoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReinicia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnReinicia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                .addComponent(qtd1Marcador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qtd2Marcador)
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(qtd1Marcador)
                        .addComponent(qtd2Marcador))
                    .addComponent(btnReinicia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(menuPanel, java.awt.BorderLayout.PAGE_START);

        jogoPanel.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(jogoPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReiniciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciaActionPerformed
        
        Object[] options = {"Nível fácil", "Nível médio", "Nível avançado"};
        int option = JOptionPane.showOptionDialog(this, "Escolha um dos três níveis disponíveis para jogar:\n"
                + "Nível fácil: 9x9 com 10 minas\n"
                + "Nível médio: 16x16 com 40 minas\n"
                + "Nível avançado: 30x16 com 99 minas ", "Nível",
                JOptionPane.YES_NO_CANCEL_OPTION,   JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
                
        switch(option){
            case 0:
                removeComponentesJogoPanel();

                adicionaComponentesJogoPanel(81,9);
                
                setaMarcadores(10);
                
                setaBombas(81,10);
               
                repintaComponentesJogoPanel();
                
                observaEventos();
                
                setSize(450,450);
                setSize(400,400);
                setLocationRelativeTo(null);
                btnReinicia.setIcon(new ImageIcon(getClass().getResource("/happypqn.png")));   

                break;
            case 1:
                removeComponentesJogoPanel();

                adicionaComponentesJogoPanel(256,16);
                
                setaMarcadores(40);
                
                setaBombas(256,40);
               
                repintaComponentesJogoPanel();
                
                observaEventos();
                
                setSize(650,650);
                setLocationRelativeTo(null);
                
                btnReinicia.setIcon(new ImageIcon(getClass().getResource("/happypqn.png")));   

                break;
            default:
                removeComponentesJogoPanel();
        }      
    }//GEN-LAST:event_btnReiniciaActionPerformed

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
            java.util.logging.Logger.getLogger(CampoMinadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CampoMinadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CampoMinadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CampoMinadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CampoMinadoView().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReinicia;
    private javax.swing.JPanel jogoPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel qtd1Marcador;
    private javax.swing.JLabel qtd2Marcador;
    // End of variables declaration//GEN-END:variables

    public void observaEventos(){
        for (Component c : jogoPanel.getComponents()){
            c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (JButton.class==e.getComponent().getClass()){
                    JButton button = (JButton) e.getComponent();
                    ImageIcon icon = (ImageIcon)button.getIcon();
                    
                    //verifica se clicou com o botão direito
                    if(MouseEvent.BUTTON3 == e.getButton()) {
                        trataCliqueBotaoDireito(icon, button);
                        
                        if (verificaSeBombasEstaoMarcadas()){
                            JOptionPane.showMessageDialog(jogoPanel.getParent(), "Você ganhou!!", "Vitória", JOptionPane.INFORMATION_MESSAGE);
                            
                            removeListeners();
                        }
                    }else{
                        verificaSeTinhaMarcador(icon);
                        
                        Component[] componentes = jogoPanel.getComponents();
                  
                        removeComponentesJogoPanel();
                        
                        criaLabelReadicionaComponentes(button, componentes);

                        repintaComponentesJogoPanel();
                        
                        int numButton = Integer.parseInt(button.getName().substring(3).trim());
                        
                        if (bombas.contains(numButton)){
                            revelaBombaClicada(numButton);
                            
                            revelaOutrasBombas(numButton);
                            
                            removeListeners();
                        }else{
                            int qtdBombasAdjascentes = contarBombasAdjascentes(numButton);                            
                            
                            mudaIconeLabel(numButton, qtdBombasAdjascentes);
                        }
                        
                    }
                }
            }
        });
        }
    }
    
    private void removeListeners(){
        for (Component c : jogoPanel.getComponents()){
            for (MouseListener ml :c.getMouseListeners()){
                c.removeMouseListener(ml);
            }
        }
    }
    
    private void mudaIconeLabel(int numButton, int qtdBombasAdjascentes){
    Component componente = jogoPanel.getComponent(numButton);
    JLabel label = (JLabel) componente;
                            
    switch (qtdBombasAdjascentes) {
        case 1:
            label.setIcon(new ImageIcon(getClass().getResource("/1labelpqn4.png")));
            break;
        case 2:
            label.setIcon(new ImageIcon(getClass().getResource("/2labelpqn4.png")));
            break;
        case 3:
            label.setIcon(new ImageIcon(getClass().getResource("/3labelpqn4.png")));
            break;
        case 4:
            label.setIcon(new ImageIcon(getClass().getResource("/4labelpqn4.png")));
            break;
        case 5:
            label.setIcon(new ImageIcon(getClass().getResource("/5label.png")));
            break;
        case 6:
            label.setIcon(new ImageIcon(getClass().getResource("/6label.png")));
            break;
        case 7:
            label.setIcon(new ImageIcon(getClass().getResource("/7label.png")));
        case 8:
            label.setIcon(new ImageIcon(getClass().getResource("/8label.png")));
            break;
        default:
            label.setIcon(new ImageIcon(getClass().getResource("/labelvaziopqn4.png")));
    }
    }
    
    private int contarBombasAdjascentes(int numButton){
        GridLayout grid = (GridLayout) jogoPanel.getLayout();
        int matriz = grid.getColumns();
        int num =0;
        int[][] panel = new int[matriz][matriz];
                     
        //constroi matriz do jogoPanel
        for (int i=0;i<matriz;i++){
            for (int j=0;j<matriz;j++){
                panel[i][j] = num++;
            } 
        }
                            
        int qtdBombasAdjascentes=0;
        boolean foiContadoBombas = false;

        //verifica se o botao clicado não estava em uma das laterais da matriz
        for(int i=0;i<matriz-1;i++){
            if (panel[0][i]==numButton){
                if (i==0){
                    int[] posicoesAdjascentes = {numButton+1, numButton+matriz, numButton+(matriz+1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
                }else if (i==(matriz-1)){
                    int[] posicoesAdjascentes = {numButton-1, numButton+matriz, numButton+(matriz-1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
                }else {
                    int[] posicoesAdjascentes = {numButton-1, numButton+1, numButton+matriz, numButton+(matriz+1), numButton+(matriz-1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
                }
            } else if (panel[matriz-1][i]==numButton){
                if (i==0){
                    int[] posicoesAdjascentes = {numButton+1, numButton-matriz, numButton-(matriz-1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
                }else if (i==(matriz-1)){
                    int[] posicoesAdjascentes = {numButton-1, numButton-matriz, numButton-(matriz+1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
                }else {
                    int[] posicoesAdjascentes = {numButton-1, numButton+1, numButton-matriz, numButton-(matriz+1), numButton-(matriz-1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
                }
            } else if (panel[i][0]==numButton){
                int[] posicoesAdjascentes = {numButton-matriz, numButton+matriz, numButton+1, numButton+(matriz+1), numButton-(matriz-1)};
                qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                foiContadoBombas = true;
            } else if (panel[i][matriz-1]==numButton){
                    int[] posicoesAdjascentes = {numButton-matriz, numButton+matriz, numButton-1, numButton+(matriz-1), numButton-(matriz+1)};
                    qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
                    foiContadoBombas = true;
            }
        }
                            
        if (!foiContadoBombas){
            int[] posicoesAdjascentes = {numButton+1, numButton-1, numButton+matriz, numButton-matriz, numButton-(matriz-1), numButton-(matriz+1), numButton+(matriz-1), numButton+(matriz+1)};
            qtdBombasAdjascentes = contaBombasAdjascentes(posicoesAdjascentes);
        }
        
        return qtdBombasAdjascentes;
    }
    
    private int contaBombasAdjascentes(int[] posicoesAdjascentes){
        int qtdBombasAdjascentes = 0;

        for (int i=0;i<posicoesAdjascentes.length;i++){
            if (bombas.contains(posicoesAdjascentes[i])){
                qtdBombasAdjascentes++;
            }
        }
        
        return qtdBombasAdjascentes;
    }
    
    private boolean marcador(int aumenta){
        if (aumenta==0){
            if (marcadores>0){
                marcadores--;
                setQtdMarcadores(marcadores);
                return true;
            }
            JOptionPane.showMessageDialog(jogoPanel.getParent(), "Não é possível adicionar mais marcadores.\nSe quiser marcar este espaço, remova um marcador.", "Aviso", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            marcadores++;
            setQtdMarcadores(marcadores);
            return true;
        }
    }
    
    private boolean verificaSeBombasEstaoMarcadas(){
        int qtdBombasMarcadas=0;
        
        for (Component componente : jogoPanel.getComponents()){
            if (componente instanceof JButton){
                JButton button = (JButton) componente;
                ImageIcon icon = (ImageIcon) button.getIcon();
                
                int numButton = Integer.parseInt(button.getName().substring(3).trim());
                
                if (bombas.contains(numButton)&&icon.getDescription().contains("marcador")){
                    qtdBombasMarcadas++;
                    
                    if (qtdBombasMarcadas==bombas.size()){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private void verificaSeTinhaMarcador(ImageIcon icon){
        //se clicou em botão que tinha marcador, libera um marcador para uso
        if (icon.getDescription().contains("marcador")){
             marcador(1);
        }
    }
    
    private void criaLabelReadicionaComponentes(JButton button, Component[] componentes){
//        System.out.println(button.getName().substring(3));
        System.out.println("Você clicou no botão " + button.getName());
//        JOptionPane.showMessageDialog(jogoPanel.getParent(), "Você clicou no botão " + button.getName(), "Informação", JOptionPane.INFORMATION_MESSAGE);
        JLabel label = new JLabel();
        
        label.setName("lbl"+button.getName().substring(3).trim());
        label.setSize(button.getSize());
                        
        for (Component componente : componentes){
            if (componente.getName().equals(button.getName())){
                jogoPanel.add(label);
            }else{
                jogoPanel.add(componente);
            }
        }
    }
    
    private void revelaBombaClicada(int numButton){
        btnReinicia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/deadpqn.png")));

        Component componente = jogoPanel.getComponent(numButton);
        JLabel label = (JLabel) componente;
        label.setIcon(new ImageIcon(getClass().getResource("/bombaexplodida.png")));
    }
    
    private void revelaOutrasBombas(int numButton){
        
        for (int i=0;i<bombas.size();i++){
            if (!bombas.get(i).equals(numButton)){
                Component componente = jogoPanel.getComponent(bombas.get(i));
                JButton btn = (JButton) componente;
                Component[] componentes = jogoPanel.getComponents();
                
                removeComponentesJogoPanel();
                
                criaLabelReadicionaComponentes(btn, componentes);
                componente = jogoPanel.getComponent(bombas.get(i));
                JLabel label = (JLabel) componente;
                label.setIcon(new ImageIcon(getClass().getResource("/bomba.png")));
            }
        }
    }

    private void trataCliqueBotaoDireito(ImageIcon icon, JButton button){
        //verifica se deve colocar marcador de bomba ou retirar ele
        if (icon.getDescription().contains("marcador")){
            marcador(1);
            button.setIcon(new ImageIcon(getClass().getResource("/squarepqn3.png")));
        }else{
            if (marcador(0)){
                button.setIcon(new ImageIcon(getClass().getResource("/marcadorpqn.png")));
            }
        }
    }
    
    public void setQtdMarcadores(int qtd) {
        String strQtd = String.valueOf(qtd);
        char digito = strQtd.charAt(0);
        String icone = selecionaImagemReferenteAoDigito(digito);

        if (strQtd.length()>1){
            qtd1Marcador.setIcon(new ImageIcon(getClass().getResource(icone)));
            
            char segundoDigito = strQtd.charAt(1);
            icone = selecionaImagemReferenteAoDigito(segundoDigito);
            qtd2Marcador.setIcon(new ImageIcon(getClass().getResource(icone)));
        }else{
            qtd1Marcador.setIcon(new ImageIcon(getClass().getResource("/0contador.png")));
            qtd2Marcador.setIcon(new ImageIcon(getClass().getResource(icone)));
        }
        
    }
    
    private String selecionaImagemReferenteAoDigito(char digito){
        switch(digito){
            case '1':
                return "/1contador.png";
            case '2':
                return "/2contador.png";
            case '3':
                return "/3contador.png";
            case '4':
                return "/4contador.png";
            case '5':
                return "/5contador.png";
            case '6':
                return "/6contador.png";
            case '7':
                return "/7contador.png";
            case '8':
                return "/8contador.png";
            case '9':
                return "/9contador.png";
            default:
                return "/0contador.png";
        }
    }
    
    private void removeComponentesJogoPanel(){
        jogoPanel.removeAll();
        jogoPanel.repaint();
        jogoPanel.revalidate();
    }
    
    private void repintaComponentesJogoPanel(){
        jogoPanel.repaint();
        jogoPanel.revalidate();
    }
    
    private void adicionaComponentesJogoPanel(int totalComponentes, int matriz){
        GridLayout grid = (GridLayout) jogoPanel.getLayout();
        grid.setColumns(matriz);
        grid.setRows(matriz);
        jogoPanel.setLayout(grid);
        
        for (int j=0;j<totalComponentes;j++){
            JButton button = new JButton();
            button.setName("btn"+j);
//            button.setActionCommand("btnCampoMinado");
//            button.addActionListener(this);
            button.setContentAreaFilled(false);
            button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/squarepqn3.png")));

            jogoPanel.add(button, j);
        }
    }

    private void setaBombas(int totalComponentes, int qtdBombas){
        List<Integer> numeros = new ArrayList();
        
        for (int i = 0; i < totalComponentes; i++) {
            numeros.add(i);
        }
                
        Collections.shuffle(numeros);
                
        bombas = new ArrayList();
                
        for (int i = 0; i < qtdBombas; i++) {
            System.out.println("g"+numeros.get(i));
            bombas.add(numeros.get(i));
        }
    }
    
    private void setaMarcadores(int qtdMarcadores){
        marcadores = qtdMarcadores;
        setQtdMarcadores(qtdMarcadores);
    }
}
