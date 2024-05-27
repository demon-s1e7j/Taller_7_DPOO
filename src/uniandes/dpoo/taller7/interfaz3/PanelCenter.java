package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelCenter extends JPanel {
	public PanelCenter() {
		setBackground(new Color( 156, 123, 84));
	}
	
    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;
        drawCuadricula(g2d);
    }
    public void drawCuadricula(Graphics2D g2d) {
    	
    }
}
