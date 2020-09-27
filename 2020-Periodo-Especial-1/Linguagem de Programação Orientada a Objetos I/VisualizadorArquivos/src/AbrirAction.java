
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SHORT_DESCRIPTION;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
class AbrirAction extends AbstractAction{

    private VisualizadorImagemJFrame frame;

    public AbrirAction(VisualizadorImagemJFrame frame) {
        super();
        this.frame = frame;
        //
        putValue(Action.NAME, "Abrir arquivo");
        //
        // para a letra do menu
        putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        //
        // para os ícones
        ImageIcon img = new ImageIcon(getClass().getResource("/iconearquivo.jpg"));
        putValue(SMALL_ICON, img);
        //
        // para a tecla de atalho CTRL+O
        KeyStroke keyStrokeToOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        putValue(Action.ACCELERATOR_KEY, keyStrokeToOpen);
        //
        // para a ajuda simples - hint
        putValue(SHORT_DESCRIPTION, "Abrir arquivo do computador.");
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
            chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            
            java.io.File arq = chooser.getSelectedFile();
            try {
                BufferedImage img = ImageIO.read(arq);
                if (arq != null && arq.isFile()) {
                    frame.setIntFrameImage(img);
                }
            } catch (IOException ex) {
                Logger.getLogger(AbrirAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
