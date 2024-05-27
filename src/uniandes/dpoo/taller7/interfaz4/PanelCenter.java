package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelCenter extends JPanel {
	private int tamano;
	private int stepAlto;
	private int stepAncho;
	private Tablero tablero;
	private int alto;
	private int ancho;
	
	public PanelCenter(int ancho, int alto, Tablero tablero) {
		this.tamano = tablero.darTablero().length;
		this.stepAlto = (int) (alto - 40) / tamano;
		this.stepAncho = (int) (ancho - 150) / tamano;
		this.alto = alto;
		this.ancho = ancho;
		this.tablero = tablero;
		setBackground(new Color( 156, 123, 84));
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
		this.tamano = tablero.darTablero().length;
		this.stepAlto = (int) (alto - 40) / tamano;
		this.stepAncho = (int) (ancho - 150) / tamano;
	}
	
	public void actualizar() {
		repaint();
	}
	
	public Color getColor(boolean valor) {
		if (valor) {
			return Color.YELLOW;
		}
		return Color.black;
	}
	
    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;
        drawGame(g2d, tablero.darTablero());
    }
    
    public void drawGame(Graphics2D g2d, boolean[][] juego) {
    	for (int row = 0; row < juego.length; row++) {
    		for (int column = 0; column < juego[row].length; column++) {
    			drawRectangulo(g2d, row * stepAncho, column * stepAlto, getColor(juego[row][column]));
    		}
    	}
    }
    
    public void drawRectangulo(Graphics2D g2d, int x, int y, Color color) {
    	g2d.setColor(color);
    	g2d.fillRect(x, y, stepAncho, stepAlto);
    	g2d.setColor(Color.BLACK);
    	g2d.drawRect(x, y, stepAncho, stepAlto);
    }
}
