package uniandes.dpoo.taller7.interfaz4;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelSouth extends JPanel {
	private JTextField tfJugadas;
	private JTextField tfJugador;
	public PanelSouth() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JLabel jugadas = new JLabel(" Jugadas:");
		JLabel jugador = new JLabel(" Jugador:");
		this.tfJugadas = new JTextField();
		tfJugadas.setText("0");
		this.tfJugador = new JTextField();
		this.add(jugadas);
		this.add(tfJugadas);
		this.add(jugador);
		this.add(tfJugador);
	}
	public void agregarJugada(String jugadas) {
		this.tfJugadas.setText(jugadas);
	}
}
