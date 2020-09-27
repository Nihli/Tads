
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lia
 */
public class PanelImagem extends JPanel{
    BufferedImage img = null;

    public PanelImagem() {
        super();
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
    
    @Override
    public void paintComponent(Graphics g){
//        Image imgteste = new ImageIcon(getClass().getResource("/iconearquivo.jpg")).getImage();
	super.paintComponent(g);
	int x = 0;
	int y = 0;
	g.drawImage(img, x, y,this);
        
    }
}
