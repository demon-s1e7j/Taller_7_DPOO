package uniandes.dpoo.taller7.interfaz3;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSouth extends JPanel {
	public PanelSouth() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JLabel jugadas = new JLabel(" Jugadas:");
		JLabel jugador = new JLabel(" Jugador:");
		JTextField tfJugadas = new JTextField();
		JTextField tfJugador = new JTextField();
		this.add(jugadas);
		this.add(tfJugadas);
		this.add(jugador);
		this.add(tfJugador);
	}
}
