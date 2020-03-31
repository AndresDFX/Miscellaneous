/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class MiPanel extends JPanel{
    
    Image im;
    
    public MiPanel(Image ima){
        this.im=ima;
        Dimension dim = new Dimension(im.getWidth(null),im.getHeight(null));
        
        this.setSize(dim);
        this.setPreferredSize(dim);
        this.setMaximumSize(dim);
        this.setMinimumSize(dim);
        
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        grphcs.drawImage(im, 0, 0, null);
    }

    
    
    
    
    
}
